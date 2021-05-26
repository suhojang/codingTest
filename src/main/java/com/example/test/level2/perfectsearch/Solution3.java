package com.example.test.level2.perfectsearch;

public class Solution3 {
    public int[] solution(int brown, int yellow) throws Exception {
        if (brown < 8 || brown > 5000)
            throw new Exception("갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.");
        if (yellow < 1 || yellow > 2000000)
            throw new Exception("노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.");

        int[] answer = new int[2];

        //총 블록 수
        int block   = brown + yellow;

        //가운데에 블록이 들어가기 위해서는 최소 3
        //width, height 의 값은 3이상인 부분부터 하나씩 계산
        for (int i=3;i<=block;i++) {
            //약수 구하기
            if (block % i == 0) {
                int width   = block / i;        //가로
                int height  = block / width;    //세로

                /**
                 * yellow 격자의 행, 열의 길이는 테두리 길이가 2씩 빠지게 됨
                 */
                int yellow_w    = width - 2;    //yellow 가로
                int yellow_h    = height - 2;   //yellow 세로

                //yellow 의 가로*세로가 yellow 와 같고 가로길이가 세로길이보다 크거나 같다면 answer 에 할당 후 break
                if (yellow_w * yellow_h == yellow && width >= height) {
                    answer[0]   = width;
                    answer[1]   = height;

                    break;
                }
            }
        }

        return answer;
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
        int yellow  = 3;

        try {
            int[] ints = new Solution3().solution(brown, yellow);
            System.out.println(ints[0]+", "+ints[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
