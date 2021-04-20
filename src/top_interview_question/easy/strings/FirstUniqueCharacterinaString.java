package top_interview_question.easy.strings;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        //26個英文字母
        int [] buffer = new int[26];


        //累計字母出現的頻率
        for (int i = 0; i < s.length(); i++) {
            //字母相減a, 等於a之後第幾個字母
            //ex e - a = 4, a之後第幾4個字母
            buffer[ s.charAt(i)- 'a'] ++;
        }

        //頻率為1代表此字母只出現一次
        for (int i = 0; i < s.length(); i++) {
            if(buffer[ s.charAt(i)- 'a'] == 1)
                return i;
        }

        return -1;        
    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        String input = "loveleetcode";//"leetcode";

        FirstUniqueCharacterinaString aa = new FirstUniqueCharacterinaString();
        System.out.println(aa.firstUniqChar(input));
        // int count = aa.removeDuplicates(numbers);  
        // System.out.println(count);
        // System.out.println("hello world");
    }
}