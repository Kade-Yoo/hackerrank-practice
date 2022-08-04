package yoo.hackerrank.practice;

/**
 * SearchInRotatedSortedArray
 *
 * 2진 탐색으로 k를 찾고 k값을 바탕으로 이진탐색을 다시 하는 방식으로 진행했으나 여러가지 통과하지 못하는 케이스가 존재하여 실패
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int k = binarySearchK(nums);
        int result = binarySearch(nums, target, k);
        return getOrginalIdx(result, k, nums.length);
    }

    /**
     * 이진 탐색
     */
    private static int binarySearch(int[] nums, int target, int k) {
        int length = nums.length;
        int middle = length / 2;
        int start = 0;
        int end = length - 1;
        int count = 0;
        while (true) {
            if (nums[getOrginalIdx(middle, k, length)] > target) {
                end = middle - 1;
                middle = (end + start) / 2;
            } else if (nums[getOrginalIdx(middle, k, length)] < target) {
                start = middle + 1;
                middle = (end + start) / 2;
            } else {
                return middle;
            }

            count++;
            if (count > length / 2) {
                return -1;
            }
        }
    }

    private static int getOrginalIdx(int result, int k, int size) {
        if (result == -1) {
            return -1;
        }

        return result < k ? result + (size - k) : result - k;
    }

    /**
     * k의 값을 찾는 이진 탐색
     */
    private static int binarySearchK(int[] nums) {
        int length = nums.length;
        int middle = length / 2;
        int start = 0;
        int end = length - 1;
        int count = 0;
        while (true) {
            if (nums[middle] > nums[start]) {
                if ((middle != length - 1) && nums[middle] > nums[middle + 1]) {
                    return middle;
                }

                start = (middle  + 1) == nums.length ? middle : middle + 1;
                middle = (end + middle) / 2;
            } else if (nums[middle] < nums[start]) {
                if ((middle != 0) && nums[middle] < nums[middle - 1]) {
                    return middle;
                }

                end = (middle - 1) == -1 ? middle : middle - 1;
                middle = (middle + start) / 2;
            } else {
                return 0;
            }

            count++;
            if (count > (length / 2)) {
                return 0;
            }
        }
    }
}
