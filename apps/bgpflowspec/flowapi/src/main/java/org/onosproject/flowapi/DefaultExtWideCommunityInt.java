/*
 * Copyright 2016-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.flowapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Wide community attributes for RPD implementation.
 */
public class DefaultExtWideCommunityInt implements ExtWideCommunityInt {

    private List<Integer> wCommInt;
    private ExtType type;

    /**
     * Creates an object of type DefaultExtWideCommunityInt which contains wide community attributes.
     *
     * @param wCommInt is a wide community value
     * @param type ExtType type
     */
    DefaultExtWideCommunityInt(List<Integer> wCommInt, ExtType type) {
        this.wCommInt = wCommInt;
        this.type = type;
    }

    @Override
    public ExtType type() {
        return type;
    }

    @Override
    public List<Integer> communityInt() {
        return wCommInt;
    }

    @Override
    public boolean exactMatch(ExtWideCommunityInt value) {
        return this.equals(value) &&
                Objects.equals(this.wCommInt, value.communityInt())
                && Objects.equals(this.type, value.type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(wCommInt, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultExtWideCommunityInt) {
            DefaultExtWideCommunityInt that = (DefaultExtWideCommunityInt) obj;
            return Objects.equals(wCommInt, that.communityInt())
                    && Objects.equals(this.type, that.type());
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("value", wCommInt.toString())
                .add("type", type.toString())
                .toString();
    }

    /**
     * Builder class for wide community value rule.
     */
    public static class Builder implements ExtWideCommunityInt.Builder {
        private List<Integer> wCommInt = new ArrayList<>();
        private ExtType type;

        @Override
        public Builder setwCommInt(Integer wCommInt) {
            this.wCommInt.add(wCommInt);
            return this;
        }

        @Override
        public Builder setType(ExtType type) {
            this.type = type;
            return this;
        }

        @Override
        public ExtWideCommunityInt build() {
            checkNotNull(wCommInt, "value cannot be null");
            return new DefaultExtWideCommunityInt(wCommInt, type);
        }
    }
}
