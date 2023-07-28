/**
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 * 1 <= nums.length <= 100000
 */

package longest.subarray;

import java.util.Random;

public class LongestSubarray {
    public static void main(String[] args) {
        System.out.println("0="+longestSubarray(new int[]{0}));
        System.out.println("0="+longestSubarray(new int[]{1}));
        System.out.println("5="+longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println("2="+longestSubarray(new int[]{1, 1, 1}));
        System.out.println("0="+longestSubarray(new int[]{0, 0, 0}));
        System.out.println("6="+longestSubarray(new int[]{0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}));
        System.out.println("n="+longestSubarray(generateUpperBoundaryArray()));
    }

    public static int longestSubarray(int[] nums) {
        int length = nums.length;
        int count = 0;
        int maxCount = 0;
        boolean isDelete = false;
        int rememberedIndex = 0;
        for (int i = 0; i < length; ++i) {
            if (nums[i] == 1) {
                while (i < length && nums[i] == 1) {
                    i++;
                    count++;
                }
                if (i < length - 1 && nums[i] == 0 && nums[i + 1] == 1) {
                    i++;
                    isDelete = true;
                    rememberedIndex = i - 1;
                } else if (count > maxCount) {
                    maxCount = count;
                }
                while (i < length && nums[i] == 1) {
                    i++;
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
                if (isDelete) {
                    i = rememberedIndex;
                }
            }
            count = 0;
            isDelete = false;
        }
        if (maxCount == length)
            maxCount--;
        return maxCount;
    }

    private static int[] generateUpperBoundaryArray() {
        Random rand = new Random();
        int[] nums = new int[100000];
        for (int i = 0; i < 100000; i++) {
            nums[i] = rand.nextInt(2);
        }
        return nums;
    }
}
