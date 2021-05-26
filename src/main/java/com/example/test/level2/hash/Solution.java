package com.example.test.level2.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 전화번호 목록
 *
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 	- 구조대 : 119
 * 	- 박준영 : 97 674 223
 * 	- 지영석 : 11 9552 4421
 *
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        Map<String, String> map	= new HashMap<>();
        for (String temp : phone_book) {
			map.put(temp, temp);
		}
        
        for (String str : phone_book) {
			for (int i = 0; i < str.length(); i++) {
				//1. 정렬 된 문자열에서 문자열을 추출 
				//2. 문자열의 길이보다 -1 작을때까지 문자열을 추출 
				//3. 추출 된 문자열을 map에 담긴 키가 있는지 검증
				String temp	= str.substring(0, i);
				if (map.containsKey(temp)) {
					return false;
				}
			}
		}
        
        return answer;
    }

	public static void main(String[] args) {
		String[] phone_book	= new String[] {
				"12","567","65","567","657"
		};
		
		boolean result	= new Solution().solution(phone_book);
		System.out.println(result);
	}

}
