package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yoo.hackerrank.practice.testcase.QueensAttackIITestCase;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class QueensAttackIITest {

    @Test
    @DisplayName("첫번째 예제")
    void 첫번째_예제() {
        int result = QueensAttackII.queensAttack(4, 0, 4, 4, Collections.emptyList());
        assertEquals(result, 9);
    }

    @Test
    @DisplayName("두번째 예제")
    void 두번째_예제() {
        int result = QueensAttackII.queensAttack(5, 3, 4, 3, QueensAttackIITestCase.createSecondExample());
        assertEquals(result, 10);
    }
}