/*************************************************************************************
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
**************************************************************************************/

import java.util.Arrays;

public class longestCommonPrefix {	
    
    public static void main(String[] args) {

        Solution x = new Solution();
        //(1 <= strs.length <= 200) and strs[i] consists of only lowercase English letters.
        
        String[] strs1 = {"qwer", "qwert", "qwerty", "qwe", "qw"};
        String[] strs2 = {"qwer", "qwer"};
        String[] strs3 = {""};
        String[] strs4 = {"qwerty"};
        String[] strs5 = {"qwer", "qwer", "qwer", "wer"};
        String[] strs6 = {};
        String[] strs7 = {"l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", 
                        "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l", "l"};
        
                        
        System.out.println("1. \"qw\" - " + "\"" + x.longestCommonPrefix(strs1) + "\"");
        System.out.println("2. \"qwer\" - " + "\"" + x.longestCommonPrefix(strs2) + "\"");
        System.out.println("3. \"\" - " + "\"" + x.longestCommonPrefix(strs3) + "\"");
        System.out.println("4. \"qwerty\" - " + "\"" + x.longestCommonPrefix(strs4) + "\"");
        System.out.println("5. \"\" - " + "\"" + x.longestCommonPrefix(strs5) + "\"");
        System.out.println("6. \"\" - " + "\"" + x.longestCommonPrefix(strs6) + "\"");
        System.out.println("7. \"\" - " + "\"" + x.longestCommonPrefix(strs7) + "\"");
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int howManyStrs = strs.length;

        if (howManyStrs == 0 || howManyStrs > 200)
            return "";
        if (howManyStrs == 1)
            return strs[0];

        Arrays.sort(strs);

        int i = 0;
        String strLast = strs[howManyStrs - 1];
        int str1Length = strs[0].length();
        
        while (i < str1Length) {
            if (strs[0].charAt(i) == strLast.charAt(i))
                i++;
            else if (i == 0)
                return "";
            else
                break;
        }
        return strLast.substring(0, i);
    }
}
