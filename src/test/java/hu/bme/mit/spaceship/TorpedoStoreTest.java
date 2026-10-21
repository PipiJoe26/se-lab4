package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Failure() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        // Act & Assert (közvetlenül a blokkban vizsgáljuk)
        assertThrows(IllegalArgumentException.class, () -> store.fire(1));
    }

    @Test
    void fire_MultipleFires() {
        // Arrange
        TorpedoStore store = new TorpedoStore(3);

        // Act & Assert
        assertEquals(true, store.fire(1));
        assertEquals(true, store.fire(1));
        assertEquals(true, store.fire(1));
        // A 4. tüzelés üres tárnál dob kivételt:
        assertThrows(IllegalArgumentException.class, () -> store.fire(1));
    }

    @Test
    void fire_ZeroAmount() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
    }

    @Test
    void fire_NegativeAmount() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(-1));
    }

    @Test 
    void torpedoStore_getTorpedoCount() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        int result = store.getTorpedoCount();

        // Assert
        assertEquals(1, result);
    }
}