package org.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] getTwoSum(int[] input, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(target - input[i])) {
                ans[0] = map.get(target - input[i]);
                ans[1] = i;
                return ans;
            } else {
                map.put(input[i], i);
            }
        }
        return ans;
    }
}
