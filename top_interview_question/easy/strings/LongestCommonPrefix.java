package top_interview_question.easy.strings;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 0; i < strs.length; i++) {
            //只要prefix和strs沒有共同的prefix
            while(strs[i].indexOf(prefix)!=0) {
                //prefix內容 => prefix-1 (prefix扣掉尾巴)
                prefix = prefix.substring(0, prefix.length()-1);
            }    
            //prefix和strs有共同的prefix (最差為"")
        }

        return prefix;
        
    }

    public static void main(String[] args) {
 

        String[] strs = {"dog","racecar","car"};
        String[] strs2 = {"flower","flow","flight"};
        LongestCommonPrefix aa = new LongestCommonPrefix();

        System.out.println(aa.longestCommonPrefix(strs2));

    }
}