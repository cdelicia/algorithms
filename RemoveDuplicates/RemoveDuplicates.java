/***********************************************************************************
 Given an integer array nums unsorted, remove the duplicates in-place such that each
 unique element appears only once. Then return the number of unique elements in nums.
 Constraints:  1 <= length <= 10000000
               1 <= variety <= 2147483647
               of course, Collectioins are not allowed
 ************************************************************************************/

package remove.duplicates;

public class RemoveDuplicates
{
    public static void main(String[] args) {

        Solution array = new Solution();
        GenerateArray perform = new GenerateArray();

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
