package yoo.hackerrank.practice.leetcode;

public class LongestIncreasingSubsequence_300 {

    public int lengthOfLIS(int[] nums) {
        return isDefaultAnswer(nums) ? 1 : getLongestSequence(nums);
    }

    private boolean isDefaultAnswer(int[] nums) {
        return nums.length == 1;
    }

    private int getLongestSequence(int[] nums) {
        int max = 0;
        int count;
        int firstValue;
        for (int idx = 0; idx < nums.length; idx++) {
            if (isRemainSequenceSmallerThanMax(nums, max, idx)) {
                return max;
            }

            count = 1;
            firstValue = nums[idx];
            for (int secondIdx = idx; secondIdx < nums.length; secondIdx++) {
                if (firstValue < nums[secondIdx]) {
                    count++;
                    firstValue = nums[secondIdx];
                }
            }

            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isRemainSequenceSmallerThanMax(int[] nums, int max, int idx) {
        return nums.length - idx + 1 <= max;
    }
}
