package com.sakura.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        /**
        '4' in row 7 is encoded as "(4)7".
        '4' in column 7 is encoded as "7(4)".
        '4' in the top-right block is encoded as "0(4)2".
        */
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if (!set.add(s + i) || !set.add(j + s) || !set.add(i / 3 + s + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
