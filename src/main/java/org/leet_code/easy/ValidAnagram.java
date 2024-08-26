package org.leet_code.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String input1, String input2) {
        if (input1.length() != input2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            char current = input1.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        for (int i = 0; i < input2.length(); i++) {
            char current = input2.charAt(i);
            if (map.get(current) != null) {
                if (map.get(current) == 1) {
                    map.remove(current);
                } else {
                    map.put(current, map.get(current) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
