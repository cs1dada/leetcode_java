package top_interview_question.easy.strings;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class ReverseString {



    public void reverseString(char[] s) {
        int leng = s.length - 1;
        int start = 0;
        while (start<leng) {
            char temp = s[start];
            s[start]=s[leng];
            s[leng]=temp;
            start++;
            leng--;
        }
    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        String input="hello";
        char[] charInput= input.toCharArray();

        ReverseString aa = new ReverseString();
        aa.reverseString(charInput);
        System.out.println(charInput);
        // int count = aa.removeDuplicates(numbers);  
        // System.out.println(count);
        // System.out.println("hello world");
    }
}