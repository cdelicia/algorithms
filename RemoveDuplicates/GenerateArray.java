package remove.duplicates;

import java.util.Random;

public class GenerateArray {

    public Solution generateRandomArray(Solution solution, int length, int variety) {
        if (length < 1 || variety < 1 || length > 10000000)
            length = 0;

        Random random = new Random();
        int[] nums = new int[length];

        for (int i = 0; i < length; i++)
            nums[i] = random.nextInt(variety);
        solution.setAllValues(nums, length, variety);
        return solution;
    }
}
