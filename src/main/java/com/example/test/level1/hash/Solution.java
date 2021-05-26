package com.example.test.level1.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하기 못한 선수
 *
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
        Map<String, Integer> result = new HashMap<>();
        for (String player : participant) {
        	result.put(player, result.getOrDefault(player, 0) + 1);
        }
        
        for (String player : completion) {
        	result.put(player, result.get(player) - 1);
        }
        
        for (String key : result.keySet()) {
            if (result.get(key) != 0){
                answer = key;
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		String[] participant	= new String[] {
				"mislav", "stanko", "mislav", "ana"
		}; 
		String[] completion		= new String[] {
				"stanko", "ana", "mislav"
		};
		
		String result	= new Solution().solution(participant, completion);
		System.out.println(result);
	}

}
