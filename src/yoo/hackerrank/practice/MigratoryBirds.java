package yoo.hackerrank.practice;

import java.util.List;

/**
 * Migratory Birds
 *
 * 새의 이동이 가장 많이 목격되는 타입의 가장 작은 번호를 찾아라.
 *
 * int arr[n] : 새가 목격되는 타입
 *
 * 조건
 * 1. 5 <= n <= 2 * 10^5
 * 2. type : 1,2,3,4,5
 */
public class MigratoryBirds {
    
    private final static int typeSize = 5;

    public static int migratoryBirds(List<Integer> arr) {
        int[] frequentlySightingsOfType = createFrequentlySightingsType(arr);
        return getMaximumSightingOfType(frequentlySightingsOfType) + 1;
    }

    /**
     * 가장 많이 목격된 타입 조회
     *
     * @param frequentlySightingsOfType 타입별 목격되는 횟수 배열
     * @return 가장 많이 목격된 타입
     */
    private static int getMaximumSightingOfType(int[] frequentlySightingsOfType) {
        int initialType = 1;
        for (int index = 0; index < frequentlySightingsOfType.length; index++) {
            if (frequentlySightingsOfType[initialType] < frequentlySightingsOfType[index]) {
                initialType = index;
            }
        }
        return initialType;
    }

    /**
     * 타입별 목격되는 횟수 셋팅
     *
     * @param arr 입력받은 배열
     * @return 타입별 목격되는 횟수
     */
    private static int[] createFrequentlySightingsType(List<Integer> arr) {
        int[] birdsType = new int[typeSize];
        for (Integer type : arr) {
            birdsType[type - 1]++; 
        }
        return birdsType;
    }
}
