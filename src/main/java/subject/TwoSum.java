package subject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: TwoSum
 * @description:
 * @author: jxx
 * @date: 2021/1/18 3:02 PM
 **/
public class TwoSum {
    //给定一个数组和一个整数target，返回数组中两个数之和为target其在数组中的下标。
    public static int[] findTwoSum(int[] nums, int target){
        int[] refs = new int[2];
        for (int i = 0; i < nums.length - 1;i++) {
            int remaining = target - nums[i];
            for (int j = i + 1; j < nums.length;j++) {
                if (nums[j] == remaining) {
                    refs[0] = i;
                    refs[1] = j;
                }
            }
        }
        return refs;
    }


    //建立元素和其索引之间的快速映射,通过哈希表
    public static int[] findTwoSumByHashTable(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0;i < nums.length;i++) {
            map.put(nums[i],i);
        }
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[2];
    }

    public static int[] findTwoSumOrdered(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
//        for (int i = left;i <= right;i++) {
//            if (target - nums[left] == nums[right]) {
//                return new int[]{left,right};
//            }
//            if (target - nums[left] > nums[right]) {
//                left ++;
//            }
//            if (target - nums[left] < nums[right]) {
//                right --;
//            }
//        }
        while (left < right) {
            if (target - nums[left] == nums[right]) {
                return new int[]{left,right};
            }
            if (target - nums[left] > nums[right]) {
                left ++;
            }
            if (target - nums[left] < nums[right]) {
                right --;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        System.out.println(Arrays.toString(findTwoSumByHashTable(nums, 6)));
        System.out.println(Arrays.toString(findTwoSum(nums, 6)));
        System.out.println(Arrays.toString(findTwoSumOrdered(nums, 6)));


    }
}
