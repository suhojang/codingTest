package com.example.test.level2.sort;

import java.util.Arrays;

/**
 * H-Index 구하기
 *
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 *
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 *
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution {
	/**
	 * 	논문수 = 배열의크기 n
		인용 횟수 h
		인용횟수가 h 인 논문의 수가 h 이면 통과
		반복 횟수 k

	 H-Index
	 * @param citations
	 * @return
	 */
	public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
        	int h	= citations.length - i;
        	if (citations[i] >= h) {
				answer	= h;
				break;
			}
        }

        
        return answer;
    }

	public static void main(String[] args) {
		int[] citations	= new int[] {
				3,0,6,1,5
		};
		
		int cnt	= new Solution().solution(citations);
		System.out.println(cnt);
	}

}
