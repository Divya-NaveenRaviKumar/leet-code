package org.example;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args){
        int[] input = {1, 2, 3, 4};
        System.out.println("ans = " + isContainsDuplicate(input));
    }

    private static boolean isContainsDuplicate(int[] input) {
        Set<Integer> set = new HashSet<>();
        for (int i : input) {
            if (set.contains(i)) return true;
            else {
                set.add(i);
            }
        }
        return false;
    }
}
