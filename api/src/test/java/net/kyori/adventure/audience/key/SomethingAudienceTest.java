package net.kyori.adventure.audience.key;

import java.util.Optional;
import java.util.UUID;
import net.kyori.adventure.audience.Audience;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SomethingAudienceTest {
  @Test
  void testGet() {
    assertEquals(Optional.empty(), SomethingAudience.get(Audience.empty(), AudienceKeys.UUID));
  }

  @Test
  void testGetOrDefault() {
    final UUID uuid = UUID.randomUUID();
    assertNull(SomethingAudience.getOrDefault(Audience.empty(), AudienceKeys.UUID, null));
    assertEquals(uuid, SomethingAudience.getOrDefault(Audience.empty(), AudienceKeys.UUID, uuid));
  }

  @Test
  void testGetOrDefaultFrom() {
    final UUID uuid = UUID.randomUUID();
    assertEquals(uuid, SomethingAudience.getOrDefaultFrom(Audience.empty(), AudienceKeys.UUID, () -> uuid));
  }
}
