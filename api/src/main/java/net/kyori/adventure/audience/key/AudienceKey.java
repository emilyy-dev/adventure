/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2021 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.adventure.audience.key;

import java.util.stream.Stream;
import net.kyori.adventure.key.Key;
import net.kyori.examination.Examinable;
import net.kyori.examination.ExaminableProperty;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An audience key.
 *
 * @param <T> the type
 * @since 4.8.0
 */
public interface AudienceKey<T> extends Examinable {
  /**
   * Creates an audience key.
   *
   * @param type the type
   * @param key the key
   * @param <T> the type
   * @return the audience key
   * @since 4.8.0
   */
  static <T> @NonNull AudienceKey<T> audienceKey(final @NonNull Class<T> type, final @NonNull Key key) {
    return new AudienceKeyImpl<>(type, key);
  }

  /**
   * Gets the type.
   *
   * @return the type
   * @since 4.8.0
   */
  @NonNull Class<T> type();

  /**
   * Gets the key.
   *
   * @return the key
   * @since 4.8.0
   */
  @NonNull Key key();

  @Override
  default @NonNull Stream<? extends ExaminableProperty> examinableProperties() {
    return Stream.of(
      ExaminableProperty.of("type", this.type()),
      ExaminableProperty.of("key", this.key())
    );
  }
}
