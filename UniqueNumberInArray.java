/**
 * Given an integer array nums where every element appears three times except for one,
 * which appears exactly once. Find the single element and return it.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 1 <= nums.length <= 3 * 10000
 */

package unique.number;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumberInArray {
    public static void main(String[] args) {
        System.out.println("3=" + singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println("99=" + singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println("2=" + singleNumber(new int[]{2}));
        System.out.println("111=" + singleNumber(generateUpperBoundaryArray()));

        System.out.println("0=" + singleNumber(new int[]{}));
        System.out.println("0=" + singleNumber(new int[]{2, 2, 2}));
        System.out.println("2=" + singleNumber(new int[]{2, 3, 4, 5, 6}));
    }

    public static int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 2; i < len; i++) {
            if (nums[i - 2] < nums[i - 1] && i == 2) {
                return nums[i - 2];
            } else if (nums[i - 2] < nums[i - 1] && nums[i - 1] < nums[i]) {
                return nums[i - 1];
            } else if (nums[i - 1] < nums[i] && i == len - 1) {
                return nums[i];
            }
        }
        return 0;
    }

    private static int[] generateUpperBoundaryArray() {
        Random rand = new Random();
        int[] nums = new int[30000];
        for (int i = 0; i < 29999; i++) {
            nums[i] = rand.nextInt(30);
        }
        nums[29999] = 111;
        return nums;
    }
}
