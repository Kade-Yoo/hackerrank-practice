package yoo.hackerrank.practice;

import java.util.*;

public class CountCoin {

    public int solution(int[] coin) {
        Map<Integer, Integer> coinMap = initCoinMap(coin);
        return caculateMaxCount(coinMap);
    }

    private int caculateMaxCount(Map<Integer, Integer> coinMap) {
        int result = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : coinMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    private Map<Integer, Integer> initCoinMap(int[] coin) {
        Map<Integer, Integer> coinMap = new HashMap<>();
        for (int value : coin) {
            coinMap.put(value, coinMap.getOrDefault(value, 0) + 1);
        }

        return coinMap;
    }
}
