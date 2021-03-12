package subject;

import java.util.*;

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

    // 给定一个包含n 个整数的数组nums 和一个目标值target，判断nums 中是否存在三个元素a，b，c，使得a + b + c 的值与target 相等？
    // 找出所有满足条件且不重复的三元组。 答案中不可以包含重复的三元组。
    private List<List<Integer>> test(int[] nums, int target){

        //[[],[],[]]
//        List<List<Integer>> result = Lists.newArrayList();
//
//        Map<Integer, Integer> map = Maps.newHashMap();
//        for (int i = 0;i < nums.length;i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0;i < nums.length;i++){
//            int twoSum = target - nums[i];
//            for (int j = i + 1;j < nums.length - 1;j++) {
//                int one = nums[j];
//                if (map.containsKey(twoSum - one) && map.get(twoSum - one) != i && map.get(twoSum - one) != j) {
//                    result.add(Lists.newArrayList(i, j, map.get(twoSum - one)));
//                }
//            }
//        }
//        return result;
        return null;
    }

    // 给定一个包含n 个整数的数组nums 和一个目标值target，判断nums 中是否存在四个元素a，b，c 和d ，使得a + b + c + d 的值与target 相等？
    // 找出所有满足条件且不重复的四元组。 答案中不可以包含重复的四元组。
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0 || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target){
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;
                    }
                }
            }

        }

        return result;
    }
}
