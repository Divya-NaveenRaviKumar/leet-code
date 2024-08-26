package org.leet_code.easy;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] input = {1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 6};
        System.out.println(removeDuplicate(input));
    }

    private static int removeDuplicate(int[] input) {
        int next = 1;
        for (int current = 1; current < input.length; current++) {
            if (input[current] != input[current - 1]) {
                input[next] = input[current];
                next++;
            }
        }
        System.out.println(Arrays.toString(input));
        return next;
    }
}
