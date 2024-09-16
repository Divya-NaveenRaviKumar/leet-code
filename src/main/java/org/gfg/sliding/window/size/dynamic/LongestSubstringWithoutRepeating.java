package org.gfg.sliding.window.size.dynamic;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(findLongestSubstringWithoutRepeating(input));
    }

    public static int findLongestSubstringWithoutRepeating(String input) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);
            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
