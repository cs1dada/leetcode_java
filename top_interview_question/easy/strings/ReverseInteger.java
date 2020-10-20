package top_interview_question.easy.strings;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class ReverseInteger {

    public int reverse(int x) {

        int val=0;
        int sign = x < 0 ? -1 : 1;
        //ex: 1534236469 overflow　!
        /**
         *  ex: 789
         *  789 => 78 | 9
         *  78 => 7 | 98 (9*10+8)
         *  7 => 0 | 987 (98*10+7)
         */
        if(sign == -1){
            x *= -1;
        }

        while (x>0) {
            //避免運算後overflow
            if (Integer.MAX_VALUE / 10 < val ) {
                return 0;
            }
            val *= 10; 
            val += x%10;
            x /= 10;
        }        
        
        return val*sign;
        
    }

    public static void main(String[] args) {
        // Constraints: -2^31 <= x <= 23^1 - 1
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        //overflow 1534236469 =>1056389759
        int input = 1534236469;//1534236469;//-123456789;


        ReverseInteger aa = new ReverseInteger();
        if(input>Integer.MAX_VALUE) {
            System.out.println("input>Integer.MAX_VALUE");
        } else{
            System.out.println("input<Integer.MAX_VALUE");
        }

        System.out.println(Integer.MAX_VALUE); //2147483647
        System.out.println(Integer.MAX_VALUE+1); //-2147483648
        System.out.println(Integer.MIN_VALUE); //-2147483648
        System.out.println(Integer.MIN_VALUE-1); //2147483647

        System.out.println(aa.reverse(input));
        // int count = aa.removeDuplicates(numbers);  
        // System.out.println(count);
        // System.out.println("hello world");
    }
}