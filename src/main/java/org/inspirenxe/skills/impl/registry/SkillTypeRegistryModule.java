/*
 * This file is part of Skills, licensed under the MIT License (MIT).
 *
 * Copyright (c) InspireNXE <https://github.com/InspireNXE/>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.inspirenxe.skills.impl.registry;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.inspirenxe.skills.impl.database.Queries.createFetchSkillTypeQuery;
import static org.inspirenxe.skills.impl.database.Queries.createInsertSkillTypeQuery;

import org.inspirenxe.skills.api.SkillType;
import org.inspirenxe.skills.impl.Constants;
import org.inspirenxe.skills.impl.SkillsImpl;
import org.inspirenxe.skills.impl.database.DatabaseManager;
import org.inspirenxe.skills.impl.level.MMOStyleLevelFunction;
import org.inspirenxe.skills.impl.skill.builtin.FarmingSkillType;
import org.inspirenxe.skills.impl.skill.builtin.MiningSkillType;
import org.jooq.DSLContext;
import org.spongepowered.api.registry.AdditionalCatalogRegistryModule;
import org.spongepowered.api.registry.RegistrationPhase;
import org.spongepowered.api.registry.util.DelayedRegistration;
import org.spongepowered.api.registry.util.RegistrationDependency;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RegistrationDependency(LevelFunctionRegistryModule.class)
public class SkillTypeRegistryModule implements AdditionalCatalogRegistryModule<SkillType> {

    private final Map<String, SkillType> map = new HashMap<>();

    @Override
    @DelayedRegistration(RegistrationPhase.PRE_INIT)
    public void registerDefaults() {
        // Remove when these are read from config
        this.registerAdditionalCatalog(new MiningSkillType());
        this.registerAdditionalCatalog(new FarmingSkillType());
    }

    @Override
    public void registerAdditionalCatalog(SkillType catalogType) {
        checkNotNull(catalogType);
        this.map.put(catalogType.getId(), catalogType);

        // This triggers the caching of this max level
        catalogType.getLevelFunction().buildLevelTable(catalogType.getMaxLevel());

        // Find out if this SkillType has been put in the db (Primarily for associations)
        final DatabaseManager manager = SkillsImpl.instance.databaseManager;

        try (final DSLContext context = manager.createContext()) {
            createFetchSkillTypeQuery(catalogType.getId())
                    .build(context)
                    .fetchAsync(SkillsImpl.instance.asyncExecutor)
                    .whenCompleteAsync((rows, ex) -> {

                        // Not in the db, insert it
                        if (rows.isEmpty()) {
                            createInsertSkillTypeQuery(catalogType.getId())
                                    .build(context)
                                    .keepStatement(false)
                                    .executeAsync(SkillsImpl.instance.asyncExecutor);
                        }
                    });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<SkillType> getById(String id) {
        if (!id.contains(":")) {
            id = Constants.Plugin.ID + ":" + id;
        }
        return Optional.ofNullable(this.map.get(id));
    }

    @Override
    public Collection<SkillType> getAll() {
        return Collections.unmodifiableCollection(this.map.values());
    }
}
