package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    @DisplayName("")
    void twoSum() {
        int[] integers = new int[] {2,7,11,15};
        int target = 9;
        int[] ints = TwoSum.twoSum(integers, target);
        assertEquals(ints[0], 0);
        assertEquals(ints[1], 1);
    }

    @Test
    @DisplayName("")
    void twoSum2() {
        int[] integers = new int[] {-3,4,3,90};
        int target = 0;
        int[] ints = TwoSum.twoSum(integers, target);
        for (int anInt : ints) {
            System.out.println("ints = " + anInt);
        }
    }
}