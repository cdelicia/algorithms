/***********************************************************************************
Given an integer array nums unsorted, remove the duplicates in-place such that each 
unique element appears only once. Then return the number of unique elements in nums.
************************************************************************************/

import java.util.Arrays;
import java.util.Random;

public class removeDuplicates
{	  
    public static void main(String[] args) {

            Solution array = new Solution();
            generateArray perform = new generateArray();
            //Constraints:  1 <= length <= 10000000
            //              1 <= variety <= 2147483647
            long startTime, stopTime;
            startTime = System.currentTimeMillis();

            perform.generateRandomArray(array, 10, 10).removeDuplicates().printNewArray();
            perform.generateRandomArray(array, 10, 2147483647).removeDuplicates().printNewArray();
            perform.generateRandomArray(array, 1, 10).removeDuplicates().printNewArray();
            perform.generateRandomArray(array, 10, 1).removeDuplicates().printNewArray();
            perform.generateRandomArray(array, 10000000, 10).removeDuplicates().printNewArray();

            perform.generateRandomArray(array, 10000001, 10).removeDuplicates().printNewArray();
            perform.generateRandomArray(array, 0, 10).removeDuplicates().printNewArray();
            perform.generateRandomArray(array, 10, 0).removeDuplicates().printNewArray();
            perform.generateRandomArray(array, -1, -1).removeDuplicates().printNewArray();

            stopTime = System.currentTimeMillis();
            System.out.println("Execution time: " + (stopTime - startTime) + "ms");
    }
}


class Solution {
    private int[] nums;
    private int length = 0;
    private int variety = 0;

    public void setNumsVar(int[] nums, int length, int variety) {
        this.nums = nums;
        this.length = length;
        this.variety = variety;
    }

    public printArray removeDuplicates() {
        printArray print = new printArray();
        int i = 0;
        int j = 0;

        if (length < 2) {
            print.setForPrint(nums, length, length);
            return print;
        }

        if (length < 1000 && variety > length / 10) {  //shell sort
            int gap = 0;
            int temp = 0;
            for (gap = length / 2; gap > 0; gap /= 2)
                for (i = gap; i < length; i++)
                    for (j = i - gap; j >= 0 && nums[j] > nums[j + gap]; j -= gap) {
                        temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
        }
        else
            Arrays.sort(nums); //using quick sort OR merge sort
        
        i = 0;
        j = 0;
        while (++j < length)
            if (nums[i] != nums[j])
                nums[++i] = nums[j];
        print.setForPrint(nums, ++i, length);
        return print;
    }
}


class generateArray {
    public Solution generateRandomArray(Solution solution, int length, int variety) {
        if (length < 1 || variety < 1 || length > 10000000)
            length = 0;
        int nums[] = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++)
            nums[i] = random.nextInt(variety);
        solution.setNumsVar(nums, length, variety);
        return solution;
    }
}


class printArray {
    private int newLength = 0;
    private int oldLength = 0;
    private int[] nums;

    public void setForPrint(int[] nums, int length, int oldLength) {
        this.nums = nums;
        this.newLength = length;
        this.oldLength = oldLength;
    }

    public void printNewArray() {
        System.out.print("Before = " + oldLength + ", After = "  + newLength + "      newArray: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i]);
            if (i != newLength - 1)
                System.out.print(",");
        }
        System.out.println();
    }
}
