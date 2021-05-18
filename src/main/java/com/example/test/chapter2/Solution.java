package com.example.test.chapter2;

import java.util.Arrays;

public class Solution {
    public static int map[][];

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer    = new int[queries.length];

        map = new int[rows][columns];

        int count   = 1;
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                map[i][j]   = count++;
            }
        }

        for (int i=0;i<queries.length;i++){
            answer[i]   = rotation(queries[i][0] - 1, queries[i][1] - 1,queries[i][2] - 1, queries[i][3] -1);
        }

        return answer;
    }

    private int rotation(int sx, int sy, int ex, int ey) {
        int min     = Integer.MAX_VALUE;
        int next    = 0;
        int before  = 0;

        //왼쪽회전
        next    = map[sx][ey];
        for (int i=ey;i>sy;i--){
            map[sx][i]  = map[sx][i-1];
        }

        //아래회전
        before  = next;
        next    = map[ex][ey];
        for (int i = ex; i > sx+1; i--){
            map[i][ey]  = map[i-1][ey];
        }
        map[sx+1][ey]   = before;

        //오른쪽 회전
        before  = next;
        next    = map[ex][sy];
        for (int i = sy; i < ey - 1; i++){
            map[ex][i]  = map[ex][i+1];
        }
        map[ex][ey-1]   = before;

        //위쪽 회전
        for (int i = sx; i < ex - 1; i++){
            map[i][sy]  = map[i+1][sy];
        }
        map[ex-1][sy]   = next;

        for (int i=sx; i < ey + 1; i++){
            min = Math.min(min, map[i][sy]);
            min = Math.min(min, map[i][ey]);
        }

        for (int i=sy;i<ey+1;i++){
            min = Math.min(min, map[sx][i]);
            min = Math.min(min, map[ex][i]);
        }

        return min;

    }

    public static void main(String[] args){
        int[][] queries = new int[][]{
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };

        int rows    = 6;
        int columns  = 6;

        int[] result  = new Solution().solution(rows, columns, queries);
        System.out.println(Arrays.toString(result));


        queries = new int[][]{
                {1,1,2,2},
                {1,2,2,3},
                {2,1,3,2},
                {2,2,3,3}
        };

        rows    = 3;
        columns  = 3;

        result  = new Solution().solution(rows, columns, queries);
        System.out.println(Arrays.toString(result));


        queries = new int[][]{
                {1,1,100,97}
        };

        rows    = 100;
        columns  = 97;

        result  = new Solution().solution(rows, columns, queries);
        System.out.println(Arrays.toString(result));

    }
}
