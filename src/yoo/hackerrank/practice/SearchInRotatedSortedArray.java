package yoo.hackerrank.practice;

/**
 * SearchInRotatedSortedArray
 *
 * 2진 탐색으로 k를 찾고 k값을 바탕으로 이진탐색을 다시 하는 방식으로 진행했으나 여러가지 통과하지 못하는 케이스가 존재하여 실패
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int k = binarySearchCustom(nums);
        int result = binarySearch(nums, target, k);
        return getOrginalIdx(result, k, nums.length);
    }

    /**
     * 이진 탐색
     */
    private static int binarySearch(int[] nums, int target, int k) {
        int middle = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (true) {
            if (nums[getOrginalIdx(middle, k, nums.length)] > target) {
                end = middle;
                middle = (middle + start) / 2;
            } else if (nums[getOrginalIdx(middle, k, nums.length)] < target) {
                start = middle;
                middle = (end + middle) / 2;
            } else {
                return middle;
            }

            count++;
            if (count >= nums.length) {
                return -1;
            }
        }
    }

    private static int getOrginalIdx(int middle, int k, int size) {
        if (middle == -1) {
            return middle;
        }

        return middle < k ? middle + (size - k) : middle - k;
    }

    private static int binarySearchCustom(int[] nums) {
        int middle = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            if (nums[middle] > nums[start]) {
                if ((middle != nums.length - 1) && nums[middle] > nums[middle + 1]) {
                    return middle;
                }

                start = middle;
                middle = (end + middle) / 2;
            } else if (nums[middle] < nums[start]) {
                if ((middle != 0) && nums[middle] < nums[middle - 1]) {
                    return middle;
                }

                end = middle;
                middle = (middle + start) / 2;
            } else {
                return middle;
            }
        }
    }
}
