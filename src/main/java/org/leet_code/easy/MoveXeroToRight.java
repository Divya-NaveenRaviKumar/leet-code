package org.leet_code.easy;

import java.util.Arrays;

public class MoveXeroToRight {
    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        moveZeroes(input);
    }

    private static void moveZeroes(int[] input) {
        int left = 0;

        for (int right = 0; right < input.length; right++) {
            if (input[right] != 0) {
                int temp = input[right];
                input[right] = input[left];
                input[left] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}
