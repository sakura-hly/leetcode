package com.sakura.leetcode.array;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (recursive(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recursive(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] ^= 256;
        boolean exist = recursive(board, i, j + 1, word, index + 1)
                || recursive(board, i, j - 1, word, index + 1)
                || recursive(board, i + 1, j, word, index + 1)
                || recursive(board, i - 1, j, word, index + 1);
        board[i][j] ^= 256;

        return exist;
    }

    public static void main(String[] args) {
        System.out.println(
                new WordSearch().exist(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "ABCCED"));
    }
}
