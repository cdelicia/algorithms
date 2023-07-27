/* Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * 1 <= nums.length <= 100000          0 <= k <= 100000    */

package rotate.array;

import java.util.Random;

public class RotateArray {
    public static void main(String[] args) {
        try {
            printResult(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
            printResult(rotate(new int[]{-1, -100, 3, 99}, 2));
            printResult(rotate(new int[]{1, 2, 3, 4, 5}, 100000));
            printResult(rotate(new int[]{1, 2, 3, 4, 5}, 0));
            printResult(rotate(new int[]{1}, 1));
            System.out.println(rotate(generateUpperBoundaryArray(), 99999).length);
        } catch (ArithmeticException e) {
            System.out.println("Can't be divided by Zero " + e);
        }

    }

    public static int[] rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k != 0 && length != 1) {
            reverse(nums, -1, length);
            reverse(nums, -1, k);
            reverse(nums, k - 1, length);
        }
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        int temp;
        while (++start < --end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    private static void printResult(int[] nums) {
        int lastElement = nums.length - 1;
        System.out.print('[');
        for (int i = 0; i <= lastElement; i++) {
            if (i == lastElement) {
                System.out.print(nums[i]);
                break;
            }
            System.out.print(nums[i] + ", ");
        }
        System.out.println(']');
    }

    private static int[] generateUpperBoundaryArray() {
        Random rand = new Random();
        int[] nums = new int[100000];
        for (int i = 0; i < 100000; i++) {
            nums[i] = rand.nextInt(1000);
        }
        return nums;
    }
}
