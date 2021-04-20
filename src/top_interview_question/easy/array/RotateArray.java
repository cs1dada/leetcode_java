package top_interview_question.easy.array;

import java.util.Arrays;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        //暴力法
        for (int i = 0; i < k; i++) {
            // array向右shift一步
            int temp = nums[nums.length - 1];            
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }

    }
    /**
     * 
     * nums = "----->-->"; k =3 result = "-->----->";
     * 
     * reverse "----->-->" we can get "<--<-----" 
     * reverse "<--" we can get "--><-----" 
     * reverse "<-----" we can get "-->----->" 
     * this visualization help me figure it out :)
     * 
     * 
     */
    public void rotate2(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(numbers));
        RotateArray aa = new RotateArray();

        aa.rotate2(numbers, 3);        
        System.out.println(Arrays.toString(numbers));

        // aa.rotate2(numbers, 3);
        // System.out.println(Arrays.toString(numbers));
        System.out.println("hello world");
    }
}