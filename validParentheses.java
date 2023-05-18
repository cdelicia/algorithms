/******************************************************************************* 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
    3. Every close bracket has a corresponding open bracket of the same type.
****************************************************************************** */
//new line

public class validParentheses {	
    
    public static void main(String[] args) {

            Solution x = new Solution();
            //only parentheses {} or [] or (), no other characters. String length from 0 to 10000;

            System.out.println("true  - " + x.isValid("{}[]()"));
            System.out.println("true  - " + x.isValid("{[()]}"));
            System.out.println("true  - " + x.isValid("()"));
            System.out.println("true  - " + x.isValid("({(({})([()]){()})([()]{})[()]})"));
            System.out.println("false - " + x.isValid("[[]"));
            System.out.println("false - " + x.isValid("{{()}}}"));
            System.out.println("false - " + x.isValid("}{"));
            System.out.println("false - " + x.isValid("{")); 
            System.out.println("false - " + x.isValid(""));
            
    }
}


class Solution {
    public boolean isValid(String str) {
        int i = 0;
        int len = str.length();
        int char1, char2;

        if (2 <= len && len <= 10000) {
            StringBuilder newStr = new StringBuilder(str);
            while (i < len) {
                if ((i + 1) == len)
                    return false;
                char1 = (int)newStr.charAt(i);
                char2 = (int)newStr.charAt(i + 1);
                if ((char1 == 40 && char2 == 41) || (char1 == 123 && char2 == 125) || (char1 == 91 && char2 == 93)) {
                    newStr.deleteCharAt(i + 1);
                    newStr.deleteCharAt(i);
                    len = newStr.length();
                    if (i > 0)
                        i--;
                }
                else
                    i++;            
            }
            if (i == 0)
                return true;
        }
        return false;
    }
}
