package top_interview_question.easy.strings;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int [] buffer = new int[26];
        for (int i = 0; i < s.length(); i++) {
            buffer[s.charAt(i)-'a'] += 1;    
        }

        for (int i = 0; i < t.length(); i++) {
            if(buffer[t.charAt(i)-'a'] -1 < 0){
                return false;
            }
            buffer[t.charAt(i)-'a'] -= 1;    
        }

        return true;

        
    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        String  s = "anagram";
        String  t = "nagaram";

        ValidAnagram aa = new ValidAnagram();

        System.out.println(aa.isAnagram(s,t));

    }
}