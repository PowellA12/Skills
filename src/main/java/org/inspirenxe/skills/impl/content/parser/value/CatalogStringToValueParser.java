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
package org.inspirenxe.skills.impl.content.parser.value;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;

import java.util.Optional;

public final class CatalogStringToValueParser<V extends CatalogType> implements StringToValueParser<V> {

  private final GameRegistry registry;

  @Inject
  public CatalogStringToValueParser(final GameRegistry registry) {
    this.registry = registry;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Optional<V> parse(final TypeToken<?> token, final String value) {
    return (Optional<V>) this.registry.getType((Class<CatalogType>) token.getRawType(), value);
  }
}