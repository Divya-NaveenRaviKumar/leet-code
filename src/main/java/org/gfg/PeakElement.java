package org.gfg;

public class PeakElement {
    public static void main(String[] args) {
        //int[] arr = {1, 3, 20, 4, 1, 0};
        //int[] arr = { 1, 3, 5, 6, 9, 10 };
        //int[] arr = { 10, 9, 6, 5, 3, 1 };
        //int[] arr = { 1, 3, 5, 6, 9, 10 };
        int[] arr= {5, 10, 12, 15, 20};
        /*
            Input: arr[]= {5, 10, 20, 15}
            Output: 20
            Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.

            Input: arr[] = {10, 20, 15, 2, 23, 90, 90}
            Output: 20 or 90
            Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20, similarly 90 has neighbors 23 and 67.

            Input: arr[] = [1, 1, 1]
            Output : 1
            Explanation: All elements are peak in the given array, we can return any of them,

        * */

        System.out.print("Index of a peak point is " + findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int length = nums.length;
        if (nums.length == 1)
            return 0;
        if (nums[0] >= nums[1])
            return 0;
        if (nums[length - 1] >= nums[length - 2])
            return length - 1;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1])
                return nums[i];
        }
        return 0;
    }
}
