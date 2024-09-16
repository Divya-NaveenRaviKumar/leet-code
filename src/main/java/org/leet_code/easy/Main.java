package org.leet_code.easy;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Ans -----> "+containsNearbyDuplicate(new int[]{99,99}, 2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> mapValueVsIndex = new HashMap<>();
        while(right < nums.length){
            if(mapValueVsIndex.containsKey(nums[right])){
                if(Math.abs(right - left) <= k){
                    return true;
                }

            }
            if(mapValueVsIndex.size() == k){
                mapValueVsIndex.remove(nums[left]);
                left++;
            }
            mapValueVsIndex.put(nums[right], right);
            right++;
        }
        return false;
    }
}