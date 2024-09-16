package org.searching;

import java.util.ArrayList;
import java.util.List;

public class FindRepeatedElementsIndexInSortedArray {
    public static void main(String[] args) {
        int[] input = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = new int[2];
        result[0] = findFirstOccurrence(input, target);
        result[1] = findLastOccurrence(input, target);

        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }

    public static List<Integer> findRepeatedIndices(int[] nums) {
        List<Integer> repeatedIndices = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Skip already processed repeated elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int firstIndex = findFirstOccurrence(nums, nums[i]);
            int lastIndex = findLastOccurrence(nums, nums[i]);

            // If the element is repeated (i.e., lastIndex > firstIndex)
            if (firstIndex != -1 && lastIndex != -1 && lastIndex > firstIndex) {
                // Add all indices from firstIndex to lastIndex
                for (int j = firstIndex + 1; j <= lastIndex; j++) {
                    repeatedIndices.add(j);
                }
            }
        }

        return repeatedIndices;
    }

    public static int findFirstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int firstIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                firstIndex = mid;  // Update the first occurrence
                high = mid - 1;    // Continue searching in the left half
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return firstIndex;
    }

    public static int findLastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int lastIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                lastIndex = mid;  // Update the last occurrence
                low = mid + 1;    // Continue searching in the right half
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lastIndex;
    }


}
