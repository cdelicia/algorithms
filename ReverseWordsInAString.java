/* Given an input string s, reverse the order of the words.
* A word is defined as a sequence of non-space characters. 
* The words in s will be separated by at least one space.
* Return a string of the words in reverse order concatenated by a single space.
* Note that s may contain leading or trailing spaces or multiple spaces between two words. 
* The returned string should only have a single space separating the words. */


public class ReverseWordsInAString {

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
        s = s.trim();
        int length = s.length();
        int wordLen;
        int start;

        s = reverse(s, -1, length);
        for (int i = 0; i < length; i++) {
            start = i;
            wordLen = 0;
            while (i < length && s.charAt(i) != ' ') {
                wordLen++;
                i++;
            }
            s = reverse(s, start-1, start+wordLen);
        }
        return skipSpaces(s);
    }

    private static String reverse(String s, int start, int end) {
        char temp;
        while (++start < --end) {
            temp = s.charAt(start);
            s = s.substring(0,start) + s.charAt(end) + s.substring(start+1);
            s = s.substring(0,end) + temp + s.substring(end+1);
        }
        return s;
    }

    private static String skipSpaces(String s) {
        int length = s.length();
        int currIndex = 0;

        while (currIndex < length) {
            if (currIndex < length - 1 && s.charAt(currIndex) == ' ' && s.charAt(currIndex+1) == ' ') {
                s = s.substring(0, currIndex) + s.substring(currIndex + 1);
                length = s.length();
            }
            else
                currIndex++;
        }
        return s;
    }
}