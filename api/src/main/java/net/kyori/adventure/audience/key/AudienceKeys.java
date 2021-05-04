package net.kyori.adventure.audience.key;

import java.util.UUID;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;

import static net.kyori.adventure.audience.key.AudienceKey.audienceKey;

/**
 * Standard {@link AudienceKey}s.
 *
 * @since 4.8.0
 */
public final class AudienceKeys {
  /**
   * A name.
   *
   * <p>Commonly (but not always) available for audiences which are a world, entity, or player.</p>
   *
   * @since 4.8.0
   */
  public static final AudienceKey<String> NAME = audienceKey(String.class, Key.key("adventure", "name"));
  /**
   * A display name.
   *
   * <p>Commonly (but not always) available for audiences which are a player.</p>
   *
   * @since 4.8.0
   */
  public static final AudienceKey<Component> DISPLAY_NAME = audienceKey(Component.class, Key.key("adventure", "display_name"));
  /**
   * A uuid.
   *
   * <p>Commonly (but not always) available for audiences which are a world, entity, or player.</p>
   *
   * @since 4.8.0
   */
  public static final AudienceKey<UUID> UUID = audienceKey(UUID.class, Key.key("adventure", "uuid"));

  private AudienceKeys() {
  }
}
