/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * 1 <= nums.length <= 100000
 */

package contains.duplicate;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("true=" + containsDuplicate(new int[]{1, 1}));
        System.out.println("false=" + containsDuplicate(new int[]{1, 2, 3, 4, 5}));
        System.out.println("true=" + containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println("false=" + containsDuplicate(new int[]{1}));
        System.out.println("true=" + containsDuplicate(generateUpperBoundaryArray()));
    }

    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return false;
        Set<Integer> hs = new HashSet<>(len);
        int i = -1;

        while (++i < len) {
            if (hs.contains(nums[i]))
                return true;
            else
                hs.add(nums[i]);
        }
        return false;
    }

    private static int[] generateUpperBoundaryArray() {
        Random rand = new Random();
        int[] nums = new int[100000];
        for (int i = 0; i < 100000; i++) {
            nums[i] = rand.nextInt(100000);
        }
        return nums;
    }
}
