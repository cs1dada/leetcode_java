package top_interview_question.easy.strings;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        char [] charArray = s.toCharArray();
        int head = 0;
        int tail = charArray.length - 1;
        
        while (head<=tail) {
            if(!Character.isLetterOrDigit(charArray[head])){
                head++;
            } else if(!Character.isLetterOrDigit(charArray[tail])) {
                tail--;
            } else {
                if(Character.toLowerCase(charArray[head]) != Character.toLowerCase(charArray[tail])) {
                    return false;
                } else {
                    head++;
                    tail--;
                }
            }            
        }

        return true;
    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        String s = "A man, a plan, a canal: Panama";

        ValidPalindrome aa = new ValidPalindrome();

        System.out.println(aa.isPalindrome(s));

    }
}