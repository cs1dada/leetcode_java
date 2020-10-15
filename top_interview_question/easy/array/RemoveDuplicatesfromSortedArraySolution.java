package top_interview_question.easy.array;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class RemoveDuplicatesfromSortedArraySolution {

    public int removeDuplicates(int[] nums) {        
        //cur代表沒有重複的Array的index
        int cur = 0;        
        
        for (int i=0;i<nums.length;i++){
            //i會走得比cur快
            //因為order array的關係只要if成立, 代表發現新的元素
            if (nums[i]>nums[cur]){
                nums[++cur] = nums[i];
            }

        }
        
        return cur+1;

    }

    public static void main(String[] args) {
        //int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] numbers = {1, 2, 3, 3, 4, 5, 6, 6, 6, 7, 8};
        RemoveDuplicatesfromSortedArraySolution aa = new RemoveDuplicatesfromSortedArraySolution();      
        int count = aa.removeDuplicates(numbers);  
        System.out.println(count);
        System.out.println("hello world");
    }
}