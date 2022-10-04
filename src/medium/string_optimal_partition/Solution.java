package medium.string_optimal_partition;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/optimal-partition-of-string/
 */
public class Solution {
    
    public int partitionString(String s) {
        int partitions = 1;
        int currentPartitionStart = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(currentPartitionStart, i).contains(String.valueOf(s.charAt(i)))) {
                currentPartitionStart = i;
                partitions++;
            }
        }
    
        return partitions;
    }

    public int partitionStringSet(String s) {
        int partitions = 1;
        Set<Character> currentChars = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!currentChars.add(s.charAt(i))) {
                currentChars.clear();
                currentChars.add(s.charAt(i));
                partitions++;
            }
        }
    
        return partitions;
    }

}
