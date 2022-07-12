package yoo.hackerrank.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Organizing Containers of Balls
 *
 * 각 컨테이너에 같은 볼 타입만 포함해야 한다.
 * 같은 타입의 볼이 다른 컨테이너에 위치해선 안된다.
 *
 * Function Description
 * int containter[n][m]: a two dimensional array of integers that represent the number of balls of each color in each container
 *
 * Returns
 * string: either Possible or Impossible
 *
 * Input Format
 * The first line contains an integer , the number of queries.
 *
 * Each of the next  sets of lines is as follows:
 * The first line contains an integer , the number of containers (rows) and ball types (columns).
 * Each of the next  lines contains  space-separated integers describing row container[i].
 *
 * Constraints
 * 1 <= q <= 10
 * 1 <= n <= 100
 * 0 <= containers[i][j] <= 10^9
 */
public class OrganizingContainersOfBalls {
    
    private static final int INITIAL_NUMBER = -1;

    public static String organizingContainers(List<List<Integer>> container) {
        SumArray sumArray = makeSumArrayOfTypeAndContainer(container);
        List<Integer> differentSum = initializeNumberWhenDifferentSum(sumArray);
        return getResult(differentSum);
    }

    /**
     * 타입별, 컨테이너별 합을 구한 배열 생성
     * 
     * @param container 입력받은 컨테이너 배열
     * @return 타입별, 컨테이너별 합을 구한 배열
     */
    private static SumArray makeSumArrayOfTypeAndContainer(List<List<Integer>> container) {
        List<Integer> sumOfcontainerList = new ArrayList<>();
        List<Integer> sumOfTypeList = new ArrayList<>();
        for (int containerIdx = 0; containerIdx < container.size(); containerIdx++) {
            int sumOfContainer = 0;
            int sumOfType = 0;
            for (int typeIdx = 0; typeIdx < container.get(containerIdx).size(); typeIdx++) {
                sumOfContainer += container.get(typeIdx).get(containerIdx);
                sumOfType += container.get(containerIdx).get(typeIdx);
            }
            sumOfcontainerList.add(sumOfContainer);
            sumOfTypeList.add(sumOfType);
        }
        
        return new SumArray(sumOfcontainerList, sumOfTypeList);
    }

    /**
     * 타입별 합과 컨테이너별 합이 다를 때 값을 셋팅한 배열을 생성
     * 
     * @param sumArray 타입별 합, 컨테이너별 합
     * @return 타입별 합과 컨테이너별 합이 다를 때 값을 셋팅한 배열
     */
    private static List<Integer> initializeNumberWhenDifferentSum(SumArray sumArray) {
        List<Integer> initializeNumber = new ArrayList<>(sumArray.getSumOfTypeList());
        for (Integer sumOfContainer : sumArray.getSumOfContainerList()) {
            Integer sumContainer = Optional.ofNullable(sumOfContainer).orElse(0);
            for (int typeIdx = 0; typeIdx < initializeNumber.size(); typeIdx++) {
                Integer sumType = Optional.ofNullable(initializeNumber.get(typeIdx)).orElse(0);
                if (sumType == INITIAL_NUMBER) {
                    continue;
                }

                if (sumContainer.equals(sumType)) {
                    initializeNumber.set(typeIdx, INITIAL_NUMBER);
                    break;
                }
            }
        }

        return initializeNumber;
    }

    /**
     * 결과 반환
     *
     * @param initialNumberArr 비교 후 INITIAL_NUMBER로 셋팅한 배열
     * @return Possible or Impossible
     */
    private static String getResult(List<Integer> initialNumberArr) {
        String result = ResultString.Possible.getDescription();
        for (Integer number : initialNumberArr) {
            if (number != INITIAL_NUMBER) {
                result = ResultString.Impossible.getDescription();
            }
        }
        return result;
    }

    public static class SumArray {
        private final List<Integer> sumOfContainerList;
        private final List<Integer> sumOfTypeList;

        public SumArray(List<Integer> sumOfContainerList, List<Integer> sumOfTypeList) {
            this.sumOfContainerList = sumOfContainerList;
            this.sumOfTypeList = sumOfTypeList;
        }

        public List<Integer> getSumOfContainerList() {
            return this.sumOfContainerList;
        }

        public List<Integer> getSumOfTypeList() {
            return this.sumOfTypeList;
        }
    }

    public enum ResultString {
        Possible("Possible"),
        Impossible("Impossible");

        private final String description;

        ResultString(String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
