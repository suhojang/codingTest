package com.example.test.level2.hash;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 위장
 *
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 */
public class Solution2 {
	public int solution(String[][] clothes) {
		int answer = 1;
		
		HashMap<String, Integer> map	= new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			//종류
			String key	= clothes[i][1];
			//종류별 요소 갯수
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			//요소의 개수 + 1을 하는 이유는 아무것도 선택하지 않을 경우가 있으므로 +1을 해준다.
			answer	*= entry.getValue() + 1;
		}
        
        return answer - 1;
    }

	public static void main(String[] args) {
		String[][] clothes	= new String[][] {
			{"yellowhat", "headgear"}, 
			{"bluesunglasses", "eyewear"}, 
//			{"bluesunglasses2", "eyewear"}, 
			{"green_turban", "headgear"}
//			{"green_turban2", "headgear"},
//			{"green_turban3", "headgear2"},
//			{"green_turban3", "headgear2"}
		};
		/*String[][] clothes	= new String[][] {
			{"crow_mask", "face"}, 
			{"blue_sunglasses", "face"}, 
			{"smoky_makeup", "face"}
		};*/
		
		int result	= new Solution2().solution(clothes);
		System.out.println(result);
	}
}
