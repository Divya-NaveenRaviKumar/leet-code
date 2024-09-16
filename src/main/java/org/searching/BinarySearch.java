package org.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        System.out.println(binarySearchRecursion(input, 0, input.length - 1, target));
        System.out.println(binarySearch(input, target));
    }

    private static boolean binarySearchRecursion(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return true;
            if (arr[mid] > target)
                return binarySearchRecursion(arr, low, mid - 1, target);
            return binarySearchRecursion(arr, mid + 1, high, target);
        }
        return false;
    }

    private static boolean binarySearch(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] == target) {
                return true;
            } else if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
