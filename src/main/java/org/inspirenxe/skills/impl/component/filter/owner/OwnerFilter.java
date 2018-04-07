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
package org.inspirenxe.skills.impl.component.filter.owner;

import com.almuradev.droplet.component.filter.AbstractFilter;
import com.almuradev.droplet.component.filter.FilterQuery;
import com.almuradev.droplet.component.filter.FilterResponse;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public final class OwnerFilter implements AbstractFilter<OwnerQuery> {

  private final Optional<UUID> owner;

  OwnerFilter(final UUID owner) {
    this.owner = Optional.ofNullable(owner);
  }

  @Override
  public boolean canQuery(FilterQuery query) {
    return query instanceof OwnerQuery;
  }

  @Override
  public FilterResponse queryInternal(OwnerQuery query) {
    return FilterResponse.from(Objects.equals(this.owner, query.owner()));
  }
}
