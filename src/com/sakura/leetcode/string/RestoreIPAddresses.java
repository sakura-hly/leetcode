package com.sakura.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        backTrack(result, new LinkedList<>(), s, 0);

        return result;
    }

    private void backTrack(List<String> result, LinkedList<String> temp, String s, int start) {
        if (temp.size() > 4) {
            return;
        }
        if (temp.size() == 4 && start == s.length()) {
            result.add(String.join(".", temp));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < start + 4 && i < s.length(); i++) {
                sb.append(s.charAt(i));
                if ((sb.length() > 1 && sb.charAt(0) == '0') || (Integer.valueOf(sb.toString()) > 255)) {
                    break;
                }
                temp.add(sb.toString());
                backTrack(result, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }
}
