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
package org.inspirenxe.skills.impl.content.type.skill.builtin.query.item;

import org.inspirenxe.skills.impl.content.type.skill.builtin.query.item.stack.FuzzyItemStack;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;

public final class ItemQueries {

    public static ItemQuery DEFAULT = state -> true;

    public static MatchTypeItemQuery itemType(final ItemType... types) {
        return new MatchTypeItemQuery(types);
    }

    public static MatchTypeItemQuery itemTypesFor(final String id) {
        return new MatchTypeItemQuery(Sponge.getRegistry().getAllFor(id, ItemType.class));
    }

    public static FuzzyMatchStackQuery fuzzyStack(final FuzzyItemStack... stacks) {
        return new FuzzyMatchStackQuery(stacks);
    }

    private ItemQueries() {}
}
