package one_ten;

import java.util.HashSet;
import java.util.Set;

/**
 * 这道题第一种解法是基于set的解法 常规解法
 * 第二种解法利用了数组下标和数组值得对应关系
 */
public class One {
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }

    public static int findRepeatNumber(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // nums[i] 应该放在下标为 i 的位置上
            while (nums[i] != i) {
                //如果num[i]不在他本来的位置  而且他本来的位置有值了  则一定重复
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        throw new IllegalArgumentException("数组中不存在重复数字！");
    }
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String[] args) {
        int []nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));
    }
}
