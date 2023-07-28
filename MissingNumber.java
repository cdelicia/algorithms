/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * 1 <= n <= 10000
 */

package missing.number;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("2=" + missingNumber(new int[]{3, 0, 1}));
        System.out.println("3=" + missingNumber(new int[]{0, 1, 2}));
        System.out.println("8=" + missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println("1=" + missingNumber(new int[]{0}));
    }


    public static int missingNumber(int[] nums) {
        int len = nums.length;

        int sum = len * (len + 1) / 2;
        int count = 0;
        for (int n = 0; n < len; n++) {
            count += nums[n];
        }
        return sum - count;
    }
}
