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
package org.inspirenxe.skills.api.event;

import org.inspirenxe.skills.api.skill.Skill;
import org.inspirenxe.skills.api.skill.SkillType;
import org.inspirenxe.skills.api.skill.holder.SkillHolder;
import org.inspirenxe.skills.api.skill.holder.SkillHolderContainer;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.util.annotation.eventgen.AbsoluteSortPosition;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

import java.util.UUID;

public interface SaveExperienceEvent extends ExperienceEvent {

    /**
     * Gets the original experience change that would occur barring no other changes.
     *
     * @return The original experience change
     */
    double getOriginalExperience();

    /**
     * Helper method that returns the difference in experience from the original amount passed to the registrar
     * from what it'll be when the registrar is resolved.
     *
     * @return The difference in experience
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default double getExperienceDifference() {
        final double xp = this.getExperience();
        final double oldXp = this.getOriginalExperience();
        return xp - oldXp;
    }

    /**
     * Called before saving experience.
     *
     * <Note>
     *   May be called asynchronously.
     * </Note>
     */
    interface Pre extends SaveExperienceEvent, Cancellable {

        /**
         * Sets the experience that will be changed.
         *
         * @param experience The new experience change
         */
        void setExperience(final double experience);
    }

    /**
     * Called after experience is saved.
     *
     * <Note>
     *   This will always be called on the main thread.
     * </Note>
     */
    interface Post extends SaveExperienceEvent {

        @PropertySettings(requiredParameter = false, generateMethods = false)
        @Override
        default UUID getContainerId() {
            return this.getContainer().getUniqueId();
        }

        @PropertySettings(requiredParameter = false, generateMethods = false)
        @Override
        default UUID getHolderId() {
            return this.getHolder().getUniqueId();
        }

        @PropertySettings(requiredParameter = false, generateMethods = false)
        @Override
        default SkillType getSkillType() {
            return this.getSkill().getSkillType();
        }

        /**
         * Gets the {@link SkillHolderContainer}.
         *
         * @return The container
         */
        @PropertySettings(requiredParameter = false, generateMethods = false)
        default SkillHolderContainer getContainer() {
            return this.getHolder().getContainer();
        }

        /**
         * Gets the {@link SkillHolder}.
         *
         * @return The holder
         */
        @PropertySettings(requiredParameter = false, generateMethods = false)
        default SkillHolder getHolder() {
            return this.getSkill().getHolder();
        }

        /**
         * Gets the {@link Skill}.
         *
         * @return The skill
         */
        @AbsoluteSortPosition(1)
        Skill getSkill();
    }
}
