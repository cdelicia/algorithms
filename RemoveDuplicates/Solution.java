package remove.duplicates;

import java.util.Arrays;

public class Solution {
    private int[] nums;
    private int length = 0;
    private int variety = 0;

    public void setAllValues(int[] nums, int length, int variety) {
        this.nums = nums;
        this.length = length;
        this.variety = variety;
    }

    public PrintArray removeDuplicates() {
        PrintArray print = new PrintArray();
        int i, j;

        if (length < 2) {
            print.setValuesForPrint(nums, length, length);
            return print;
        }

        if (length < 1000 && variety > length / 10) {
            int gap;
            int temp;
            for (gap = length / 2; gap > 0; gap /= 2)
                for (i = gap; i < length; i++)
                    for (j = i - gap; j >= 0 && nums[j] > nums[j + gap]; j -= gap) {
                        temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
        }
        else
            Arrays.sort(nums);

        i = 0;
        j = 0;
        while (++j < length)
            if (nums[i] != nums[j])
                nums[++i] = nums[j];
        print.setValuesForPrint(nums, ++i, length);
        return print;
    }
}