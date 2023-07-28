/*************************************************************************************
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

1 <= strs.length <= 20) and strs[i] consists of only lowercase English letters.
**************************************************************************************/

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs1 = {"qwer", "qwert", "qwerty", "qwe", "qw"};
        String[] strs2 = {"qwer", "qwer"};
        String[] strs3 = {""};
        String[] strs4 = {"qwerty"};
        String[] strs5 = {"qwer", "qwer", "qwer", "wer"};
        String[] strs6 = {};
        String[] strs7 = {"l", "l", "l", "l", "l", "l", "l", "l", "l", "l",
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l"}; //20 elements
        String[] strs8 = {"l", "l", "l", "l", "l", "l", "l", "l", "l", "l",
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l"}; //21 elements


        System.out.println("1. \"qw\" - " + "\"" + longestCommonPrefix(strs1) + "\"");
        System.out.println("2. \"qwer\" - " + "\"" + longestCommonPrefix(strs2) + "\"");
        System.out.println("3. \"\" - " + "\"" + longestCommonPrefix(strs3) + "\"");
        System.out.println("4. \"qwerty\" - " + "\"" + longestCommonPrefix(strs4) + "\"");
        System.out.println("5. \"\" - " + "\"" + longestCommonPrefix(strs5) + "\"");
        System.out.println("6. \"\" - " + "\"" + longestCommonPrefix(strs6) + "\"");
        System.out.println("7. \"l\" - " + "\"" + longestCommonPrefix(strs7) + "\"");
        System.out.println("8. \"\" - " + "\"" + longestCommonPrefix(strs8) + "\"");
    }

    private static String longestCommonPrefix(String[] strs) {
        int howManyStrs = strs.length;
        int firstStrLength;
        int i = 0;

        if (howManyStrs == 0 || howManyStrs > 20)
            return "";
        else if (howManyStrs == 1)
            return strs[0];

        Arrays.sort(strs);

        String lastStr = strs[howManyStrs - 1];
        firstStrLength = strs[0].length();
        while (i < firstStrLength) {
            if (strs[0].charAt(i) == lastStr.charAt(i))
                i++;
            else if (i == 0)
                return "";
            else
                break;
        }
        return lastStr.substring(0, i);
    }
}
