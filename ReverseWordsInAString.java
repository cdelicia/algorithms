/* Given an input string s, reverse the order of the words.
* A word is defined as a sequence of non-space characters. 
* The words in s will be separated by at least one space.
* Return a string of the words in reverse order concatenated by a single space.
* Note that s may contain leading or trailing spaces or multiple spaces between two words. 
* The returned string should only have a single space separating the words. */

package reverse.words;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println("tst1="+reverseWords("the sky is blue") +'$');
        System.out.println("tst2="+reverseWords("  hello world  ") +'$');
        System.out.println("tst3="+reverseWords("a good   example") +'$');
        System.out.println("tst4="+reverseWords("milk, sugar!") +'$');
        System.out.println("tst5="+reverseWords("milk , sugar !") +'$');
        System.out.println("tst6="+reverseWords("") +'$');
        System.out.println("tst7="+reverseWords("a") +'$');
        System.out.println("tst8="+reverseWords("\t\t") +'$');
        System.out.println("tst9="+reverseWords("\n") +'$');
        System.out.println("tst10="+reverseWords("               ") +'$');
    }

    public static String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        String[] arr = s.split(" ");
        String newStr = "";
        for (int index = arr.length-1; index >= 0; index--) {
            newStr = newStr + arr[index];
            if (index > 0)
                newStr = newStr + ' ';
        }
        return newStr;
    }
}
