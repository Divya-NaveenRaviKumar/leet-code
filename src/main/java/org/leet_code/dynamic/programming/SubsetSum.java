package org.leet_code.dynamic.programming;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        System.out.println("Is subset sum possible: " + isSubsetSumRecursion(arr, sum, arr.length));
        System.out.println("Is subset sum possible: " + isSubsetSumDp(arr, sum, arr.length));
    }

    private static boolean isSubsetSumDp(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
    private static boolean isSubsetSumRecursion(int[] arr, int sum, int n) {
        if(sum == 0)
            return true;
        if (n == 0)
            return false;
        return isSubsetSumRecursion(arr, sum, n-1) || isSubsetSumRecursion(arr, sum - arr[n-1], n-1);
    }
}
