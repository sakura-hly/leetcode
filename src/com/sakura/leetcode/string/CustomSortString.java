package com.sakura.leetcode.string;

import java.util.*;
import java.util.stream.IntStream;

public class CustomSortString {

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>(T.length());

        IntStream.range(0, S.length()).forEach(value -> {
            map.put(S.charAt(value), value);
        });
        IntStream.range(0, T.length()).forEach(value -> {
            list.add(T.charAt(value));
        });


        Collections.sort(list, (o1, o2) -> (map.getOrDefault(o1, 0) - map.getOrDefault(o2, 0)));

        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new CustomSortString().customSortString("awjeuldzxknyocsrfpvq", "itnmbfynwuktoeulvfrjowqqnburnvendrafgfcgjiaovffzoxocsonpxmuqfhluzhaiuvldldvrcvofsfnaqfxrdnkvoguxqbke"));
    }
}
