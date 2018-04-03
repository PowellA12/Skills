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
package org.inspirenxe.skills.impl.component.filter.data;

import com.almuradev.droplet.component.filter.FilterTypeParser;
import com.almuradev.droplet.parser.Parser;
import com.almuradev.droplet.registry.Registry;
import com.almuradev.droplet.registry.RegistryKey;
import com.google.inject.Inject;
import net.kyori.xml.node.Node;
import org.spongepowered.api.data.key.Key;

public final class DataKeyFilterParser implements FilterTypeParser<DataKeyFilter> {

  private final Registry<Key<?>> registry;
  private final Parser<RegistryKey> keyParser;

  @Inject
  public DataKeyFilterParser(final Registry<Key<?>> registry, final Parser<RegistryKey> keyParser) {
    this.registry = registry;
    this.keyParser = keyParser;
  }

  @Override
  public DataKeyFilter throwingParse(Node node) {
    return new DataKeyFilter(this.registry.ref(this.keyParser.parse(node)).require());
  }
}