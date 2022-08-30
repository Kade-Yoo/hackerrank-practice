package yoo.hackerrank.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yoo.hackerrank.practice.testcase.CountCoinTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountCoinTest {

    private CountCoin countCoin;
    private CountCoinTestCase countCoinTestCase;

    @BeforeEach
    void init() {
        countCoin = new CountCoin();
        countCoinTestCase = new CountCoinTestCase();
    }

    @Test
    @DisplayName("예제1")
    void example_1() {
        int[] coin = countCoinTestCase.createFirstExample();
        int solution = countCoin.solution(coin);
        assertEquals(500, solution);
    }

    @Test
    @DisplayName("예제2")
    void example_2() {
        int[] coin = countCoinTestCase.createSecondExample();
        int solution = countCoin.solution(coin);
        assertEquals(300, solution);
    }

    @Test
    @DisplayName("예제3")
    void example_3() {
        int[] coin = countCoinTestCase.createThirdExample();
        int solution = countCoin.solution(coin);
        assertEquals(100, solution);
    }
}