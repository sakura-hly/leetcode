package com.sakura.leetcode.hashtable;


import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null | strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

//    private static int cal(String str) {
//        char[] arr = str.toCharArray();
//        Arrays.sort(arr);
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i] << i;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
