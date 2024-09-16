package org.gfg.sliding.window.size.dynamic;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] tree = {1, 2, 1, 2, 3};
        System.out.println(totalFruit(tree));
    }

    public static int totalFruit(int[] fruits) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int l = 0, r = 0; r < fruits.length; ++r) {
            count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[l], count.get(fruits[l]) - 1);
                count.remove(fruits[l], 0);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    /*public static int totalFruit(int[] tree) {
        int maxFruits = 0;
        int windowStart;
        int windowEnd;
        int fruitCount = 0;
        int fruit1 = -1;
        int fruit2 = -1;
        for (windowEnd = 0; windowEnd < tree.length; windowEnd++) {
            if (fruit1 == -1 || tree[windowEnd] == fruit1) {
                fruit1 = tree[windowEnd];
                fruitCount++;
            } else if (fruit2 == -1 || tree[windowEnd] == fruit2) {
                fruit2 = tree[windowEnd];
                fruitCount++;
            } else {
                maxFruits = Math.max(maxFruits, fruitCount);
                windowStart = windowEnd - 1;
                while (windowStart >= 0 && tree[windowStart] == tree[windowEnd - 1]) {
                    windowStart--;
                    fruitCount--;
                }
                fruit1 = tree[windowEnd - 1];
                fruit2 = tree[windowEnd];
                fruitCount = 2;
            }
        }
        return Math.max(maxFruits, fruitCount);
    }*/
}
