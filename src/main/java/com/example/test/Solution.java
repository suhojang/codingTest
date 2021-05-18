package com.example.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    /**
     * 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return
     *
     * @param lottos    구매한 로또번호를 담은 배열
     * @param win_nums  당첨 번호를 담은 배열
     * @return
     */
    public int[] solution(int[] lottos, int[] win_nums){
        int zero    = 0;
        int matched = 0;

        for (int lotto : lottos){
            if (lotto==0){
                zero++;
                continue;
            }

            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    matched++;
                    break;
                }
            }
        }

        int min = matched;
        int max = matched + zero;

        /**
         * 순위	당첨 내용
         * 1	6개 번호가 모두 일치
         * 2	5개 번호가 일치
         * 3	4개 번호가 일치
         * 4	3개 번호가 일치
         * 5	2개 번호가 일치
         * 6(낙첨)	그 외
         */
        int[] answer    = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        return answer;
    }

    public static void main(String[] args){
        int[] lottos    = {44,1,0,0,31,25};
        int[] win_nums  = {31,10,45,1,6,19};
        int[] result    = new Solution().solution(lottos, win_nums);

        System.out.println(Arrays.toString(lottos) + "\t" + Arrays.toString(win_nums) + "\t" + Arrays.toString(result));

        lottos    = new int[]{0,0,0,0,0,0};
        win_nums  = new int[]{38,19,20,40,15,25};
        result    = new Solution().solution(lottos, win_nums);

        System.out.println(Arrays.toString(lottos) + "\t" + Arrays.toString(win_nums) + "\t" + Arrays.toString(result));


        lottos    = new int[]{45,4,35,20,3,9};
        win_nums  = new int[]{20,9,3,45,4,35};
        result    = new Solution().solution(lottos, win_nums);

        System.out.println(Arrays.toString(lottos) + "\t" + Arrays.toString(win_nums) + "\t" + Arrays.toString(result));
    }
}
