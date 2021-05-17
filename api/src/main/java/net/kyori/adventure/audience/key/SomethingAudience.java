package net.kyori.adventure.audience.key;

import java.util.Optional;
import java.util.function.Supplier;
import net.kyori.adventure.audience.Audience;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.PolyNull;

public interface SomethingAudience extends Audience {
  static <T> @NonNull Optional<T> get(final @NonNull Audience audience, final @NonNull AudienceKey<T> key) {
    if(audience instanceof SomethingAudience) return ((SomethingAudience) audience).get(key);
    return Optional.empty();
  }

  @SuppressWarnings("checkstyle:MethodName")
  static <T> @PolyNull T getOrDefault(final @NonNull Audience audience, final @NonNull AudienceKey<T> key, final @PolyNull T defaultValue) {
    return get(audience, key).orElse(defaultValue);
  }

  @SuppressWarnings("checkstyle:MethodName")
  static <T> @PolyNull T getOrDefaultFrom(final @NonNull Audience audience, final @NonNull AudienceKey<T> key, final @NonNull Supplier<? extends T> defaultValue) {
    return get(audience, key).orElseGet(defaultValue);
  }

  /**
   * Gets the value of {@code key}.
   *
   * @param key the key
   * @param <T> the type
   * @return the value
   * @since 4.8.0
   */
  default <T> @NonNull Optional<T> get(final @NonNull AudienceKey<T> key) {
    return Optional.empty();
  }

  /**
   * Gets the value of {@code key}.
   *
   * <p>If this {@code Audience} is unable to provide a value for {@code key}, {@code defaultValue} will be returned.</p>
   *
   * @param key the key
   * @param defaultValue the default value
   * @param <T> the type
   * @return the value
   * @since 4.8.0
   */
  @SuppressWarnings("checkstyle:MethodName")
  default <T> @PolyNull T getOrDefault(final @NonNull AudienceKey<T> key, final @PolyNull T defaultValue) {
    return this.get(key).orElse(defaultValue);
  }

  /**
   * Gets the value of {@code key}.
   *
   * <p>If this {@code Audience} is unable to provide a value for {@code key}, the value supplied by {@code defaultValue} will be returned.</p>
   *
   * @param key the key
   * @param defaultValue the default value supplier
   * @param <T> the type
   * @return the value
   * @since 4.8.0
   */
  @SuppressWarnings("checkstyle:MethodName")
  default <T> @PolyNull T getOrDefaultFrom(final @NonNull AudienceKey<T> key, final @NonNull Supplier<? extends T> defaultValue) {
    return this.get(key).orElseGet(defaultValue);
  }
}
