package com.example.test.select.carpet;

public class Solution2 {
    public int[] solution(int brown, int red) {
        for(int i=1; i<=red; i++) {
            if(red%i==0 && (red/i+i)*2+4==brown) {
                return new int[] {red/i+2, i+2};
            }
        }
        return null;
    }

    public static void main(String[] args){
        /**
         * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
         * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
         * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
         *
         * brown	yellow	return
         * 10	        2	[4, 3]
         * 8	        1	[3, 3]
         * 24	        24	[8, 6]
         */

        //brown과 yellow의 합은 총 블럭의 개수
        int brown   = 10;
        int yellow  = 2;

        try {
            int[] ints = new Solution().solution(brown, yellow);
            System.out.println(ints[0]+", "+ints[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
