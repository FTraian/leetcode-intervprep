package three_sum;

import javax.swing.*;
import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer val = map.get(nums[i]);
//            if (val == null) {
//                map.put(nums[i], 1);
//            } else {
//                map.put(nums[i], ++val);
//            }
//        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ( nums[i] +  nums[j] + nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        list.sort(Integer::compareTo);
                        result.add(list);
                    }
                }
//                if (map.get(-nums[i] - nums[j]) != null) {
//                    result.add(List.of(nums[i], nums[j], -nums[i] - nums[j]));
//                }
            }
        }

        return List.copyOf(result);
    }

}
