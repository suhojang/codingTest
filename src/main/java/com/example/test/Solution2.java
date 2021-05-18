package com.example.test;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Solution2 {
    /**
     * 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return
     *
     * @param lottos    구매한 로또번호를 담은 배열
     * @param win_nums  당첨 번호를 담은 배열
     * @return
     */
    public int[] solution(int[] lottos, int[] win_nums){
        //최저 순위는 6
        int min_tier    = 6;

        return LongStream.of(
                //최고 순위 7 - (번호가 동일하거나 0인거)의 count
                (lottos.length + 1) - Arrays.stream(lottos).filter(lotto -> Arrays.stream(win_nums).anyMatch(w -> w == lotto) || lotto == 0).count(),
                //최저 순위 7 - 번호가 동일한것의 count
                (lottos.length + 1) - Arrays.stream(lottos).filter(lotto -> Arrays.stream(win_nums).anyMatch(w -> w == lotto)).count()
                )
                .mapToInt(tier -> (int) (tier > min_tier ? min_tier : tier))
                .toArray();
    }

    public static void main(String[] args){
        int[] lottos    = {44,1,0,0,31,25};
        int[] win_nums  = {31,10,45,1,6,19};
        int[] result    = new Solution2().solution(lottos, win_nums);

        System.out.println(Arrays.toString(lottos) + "\t" + Arrays.toString(win_nums) + "\t" + Arrays.toString(result));

        lottos    = new int[]{0,0,0,0,0,0};
        win_nums  = new int[]{38,19,20,40,15,25};
        result    = new Solution2().solution(lottos, win_nums);

        System.out.println(Arrays.toString(lottos) + "\t" + Arrays.toString(win_nums) + "\t" + Arrays.toString(result));


        lottos    = new int[]{45,4,35,20,3,9};
        win_nums  = new int[]{20,9,3,45,4,35};
        result    = new Solution2().solution(lottos, win_nums);

        System.out.println(Arrays.toString(lottos) + "\t" + Arrays.toString(win_nums) + "\t" + Arrays.toString(result));
    }
}
