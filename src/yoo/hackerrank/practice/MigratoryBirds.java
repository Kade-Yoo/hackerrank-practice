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
 *
 * 풀이 방법
 * 입력받는 타입이 1,2,3,4,5로 정해져 있기 때문에 해당하는 번호로 배열의 인덱스를 잡고 목격 횟수를 배열의 값으로 저장한다.
 * 가장 많이 목격된 가장 작은 타입의 번호를 출력해야하기 때문에 배열을 반복하며 최댓값의 인덱스를 찾는다.
 *
 * 단, 동일한 값이 있으면 인덱스를 저장하지 않고 무시한다. 무시하는 이유는 배열의 인덱스는 반복할 때 가장 작은 값부터 시작한다
 * 즉, 비교하는 대상은 항상 인덱스 번호가 크다는 것이다. 그러므로 목표인 가장 작은 타입을 찾기 위해선 동일한 값일 때 인덱스 번호를 저장하지 말아야 한다.
 */
public class MigratoryBirds {
    
    private final static int TYPE_SIZE = 5;

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
        int[] birdsType = new int[TYPE_SIZE];
        arr.forEach(type -> birdsType[type - 1]++);
        return birdsType;
    }
}
