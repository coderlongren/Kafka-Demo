/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Solution
 * Author:   coderlong
 * Date:     2019/4/20 16:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/20
 * @since 1.0.0
 */
class Solution {
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visit = new boolean[rows][cols];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, visit, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int row, int col, boolean[][] visit, int len, String word) {
        if (!isSafeIndex(row,col, board)) {
            return false;
        }
        if (visit[row][col] == true) {
            return false;
        }
        if (len >= word.length() || word.charAt(len) != board[row][col]) {
            return false;
        }
        if (len == word.length() - 1) {
            return true;
        }
        visit[row][col] = true;
        for (int[] dir : dirs) {
            if (dfs(board, row + dir[0], col + dir[1], visit, len + 1, word)) {
                return true;
            }
        }
        visit[row][col] = false;
        return false;

    }
    private boolean isSafeIndex(int row, int col, char[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
    }
}