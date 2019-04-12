/*
 * This file is part of Skills, licensed under the MIT License (MIT).
 *
 * Copyright (c) InspireNXE
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
package org.inspirenxe.skills.api.skill.holder;

import static com.google.common.base.Preconditions.checkNotNull;

import org.inspirenxe.skills.api.Nameable;
import org.inspirenxe.skills.api.SkillService;
import org.spongepowered.api.util.Identifiable;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface SkillHolderContainer extends Identifiable, Nameable {

    Map<UUID, SkillHolder> getHolders();

    default Optional<SkillHolder> getHolder(UUID holderId) {
        checkNotNull(holderId);

        return Optional.ofNullable(this.getHolders().get(holderId));
    }

    default SkillHolder createHolder(UUID holderId) {
        return this.createHolder(holderId, SkillService.UNKNOWN_NAME);
    }

    SkillHolder createHolder(UUID holderId, String name);

    default void saveHolder(UUID holderId) {
        this.getHolder(holderId).ifPresent(SkillHolder::save);
    }

    Optional<SkillHolder> removeHolder(UUID holderId);

    default void save() {
        this.getHolders().values().forEach(SkillHolder::save);
    }
}