package org.leet_code.dynamic.programming;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        System.out.println("Is subset sum possible: " + isSubsetSumRecursion(arr, sum, arr.length));
        System.out.println("Is subset sum possible: " + isSubsetSumDp(arr, sum, arr.length));
    }

    private static boolean isSubsetSumDp(int[] arr, int target, int n) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for (int noOfElements = 0; noOfElements <= arr.length; noOfElements++) {
            dp[noOfElements][0] = true;
        }
        for (int noOfElements = 1; noOfElements <= arr.length; noOfElements++) {
            for (int sum = 1; sum <= target; sum++) {
                if (arr[noOfElements - 1] <= sum) {
                    dp[noOfElements][sum] = dp[noOfElements - 1][sum - arr[noOfElements - 1]] || dp[noOfElements - 1][sum];
                } else {
                    dp[noOfElements][sum] = dp[noOfElements - 1][sum];
                }
            }
        }
        return dp[arr.length][target];
    }
    private static boolean isSubsetSumRecursion(int[] arr, int sum, int n) {
        if(sum == 0)
            return true;
        if (n == 0)
            return false;
        return isSubsetSumRecursion(arr, sum, n-1) || isSubsetSumRecursion(arr, sum - arr[n-1], n-1);
    }
}
