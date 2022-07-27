package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoIntegersTest {

    @Test
    @DisplayName("12 + 5")
    void sum() {
        int sum = AddTwoIntegers.sum(12, 5);
        assertEquals(sum, 17);
    }
}