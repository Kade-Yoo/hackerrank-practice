package yoo.hackerrank.practice;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int idx = 0; idx < nums.length; idx++) {
            for (int multiIdx = idx + 1; multiIdx < nums.length; multiIdx++) {
                if (nums[idx] + nums[multiIdx] == target) {
                    return new int[] {idx, multiIdx};
                }
            }
        }

        return new int[] {};
    }
}
