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
package org.inspirenxe.skills.impl.content.type.skill.builtin.query.item.stack;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Sets;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Collection;

public final class FuzzyItemStack {

    public static FuzzyItemStack stack(ItemType type, KeyValue... values) {
        checkNotNull(type);
        checkNotNull(values);

        return new FuzzyItemStack(type, values);
    }

    private final ItemType type;
    private final Collection<KeyValue> values;

    private FuzzyItemStack(final ItemType type, final KeyValue... values) {
        this.type = type;
        this.values = Sets.newHashSet(values);
    }

    public boolean matches(final ItemStack stack) {
        if (this.type != stack.getType()) {
            return false;
        }

        boolean matches = false;
        for (KeyValue value : this.values) {
            Object actualValue = stack.get(value.getKey()).orElse(null);
            if (actualValue == null) {
                continue;
            }

            if (hackyEqualsCheck(actualValue, value.getValue())) {
                matches = true;
                break;
            }
        }

        return matches;
    }

    private boolean hackyEqualsCheck(Object a, Object b) {
        if (a instanceof String) {
            return a.toString().equalsIgnoreCase(b.toString());
        }

        if (a instanceof Enum) {
            return ((Enum) a).name().equalsIgnoreCase(b.toString());
        }

        if (a instanceof Number) {
            return a == b;
        }

        return a.equals(b);
    }
}