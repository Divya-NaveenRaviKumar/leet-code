package org.gfg.sliding.window.fixed.windiw.size;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(findMaxSumSubarray(k, arr));
    }

    static int findMaxSumSubarray(int windowSize, int[] array) {
        int initialSum = 0;
        for (int i = 0; i < windowSize; i++) {
            initialSum += array[i];
        }
        int maxSum = 0;
        for (int i = windowSize; i < array.length; i++) {
            initialSum = initialSum - array[i - windowSize] + array[i];
            maxSum = Math.max(maxSum, initialSum);
        }
        return maxSum;
    }
    /*public static int findMaxSumSubarray(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }*/
}
