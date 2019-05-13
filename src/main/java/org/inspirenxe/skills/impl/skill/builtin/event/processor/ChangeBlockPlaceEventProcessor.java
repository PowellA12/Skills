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
package org.inspirenxe.skills.impl.skill.builtin.event.processor;

import org.inspirenxe.skills.api.skill.builtin.SkillsEventContextKeys;
import org.inspirenxe.skills.impl.SkillsImpl;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

public final class ChangeBlockPlaceEventProcessor extends AbstractBlockTransactionEventProcessor {

    public ChangeBlockPlaceEventProcessor() {
        super(SkillsImpl.ID + ":change_block_place", "Change Block Place", event -> event instanceof ChangeBlockEvent.Place);
    }

    @Override
    EventContext populateTransactionContext(final EventContext context, final Transaction<BlockSnapshot> transaction) {
        return EventContext
            .builder()
            .from(context)
            .add(SkillsEventContextKeys.PROCESSING_ITEM, context.get(EventContextKeys.USED_ITEM).orElse(ItemStackSnapshot.NONE))
            .add(SkillsEventContextKeys.PROCESSING_BLOCK, transaction.getFinal())
            .build();
    }
}