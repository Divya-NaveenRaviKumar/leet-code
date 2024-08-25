package org.example;

public class LowestCommonPrefix {

    private static String getLowestCommonPrefix(String[] input) {
        if (input.length == 0) return "";
        String prefix = input[0];
        if (input.length == 1) return prefix;
        for (int i = 1; i < input.length; i++) {
            while (input[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
