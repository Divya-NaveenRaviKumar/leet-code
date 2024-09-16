package org.gfg.sliding.window.size.dynamic;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 7;
        System.out.println(findLongestSubArrayWithSumK(k, arr));
    }

    public static int findLongestSubArrayWithSumK(int k, int[] arr) {
        int maxLength = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowSum == k) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            } else if (windowSum > k) {
                while (windowSum > k) {
                    windowSum -= arr[windowStart];
                    windowStart++;
                }
                if (windowSum == k) {
                    maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                }
            }
        }
        return maxLength;
    }
}
