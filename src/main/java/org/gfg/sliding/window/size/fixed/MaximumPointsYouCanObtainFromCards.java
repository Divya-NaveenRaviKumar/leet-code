package org.gfg.sliding.window.size.fixed;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int windowEnd) {
        int windowSum = 0;
        for (int i = 0; i < windowEnd; i++) {
            windowSum += cardPoints[i];
        }
        int maxSum = windowSum;
        int left = windowEnd - 1;
        int right = cardPoints.length;
        while (left >= 0) {
            windowSum = windowSum - cardPoints[left];
            left--;
            windowSum += cardPoints[right - 1];
            right--;
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
