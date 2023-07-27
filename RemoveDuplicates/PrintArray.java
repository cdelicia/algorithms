package remove.duplicates;

class PrintArray {
    private int newLength;
    private int oldLength;
    private int[] nums;

    public PrintArray() {
        newLength = 0;
        oldLength = 0;
        nums = null;
    }

    public void setValuesForPrint(int[] nums, int length, int oldLength) {
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
        System.out.print('\n');
    }
}
