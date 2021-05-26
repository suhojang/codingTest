package com.example.test.level3.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 베스트 앨범
 *
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 	1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 	2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 	3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 *
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 */
public class Solution {
	public int[] solution(String[] genres, int[] plays) {
        /**
         *  1. 장르별 재생 횟수를 구해야 했으므로 HashMap을 사용했다. getOrDefault 메서드를 사용하여 원래 값이 있으면 원래 값에 value를 더해주고 없으면 value를 넣어주었다. 
			2. 장르별 가장 많은 재생횟수를 구해야 했으므로 ArrayList<String>에 keySet을 넣어주고 ArrayList를 내림차순으로 sort했다.
			3. 가장 많이 재생된 순서대로 장르를 뽑았고, 뽑은 장르의 첫 번째 많은 재생 횟수를 갖는 인덱스와 두번째로 많은 재생횟수를 갖는 인덱스를 ArrayList에 저장해주었다.
			4. 인덱스들이 들어가 있는 ArrayList를 int형 배열로 바꾸어주어 리턴한다
         */
        
        //1. 장르별 재생횟수를 구하기
        Map<String, Integer> valueMap	= new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
			valueMap.put(genres[i], valueMap.getOrDefault(genres[i], 0) + plays[i]);
		}
        
        ArrayList<Integer> answers		= new ArrayList<>();
        ArrayList<String> genresList	= new ArrayList<>(valueMap.keySet());
        
        //2. ArrayList를 valueMap Value 내림차순 순으로 정렬
        Collections.sort(genresList, (o1, o2) -> valueMap.get(o2).compareTo(valueMap.get(o1)));
        
        //3. 첫번째, 두번째 값 구하기
        for (int i = 0; i < genresList.size(); i++) {
			String tempGenres	= genresList.get(i);
			
			int firstIdx	= 0;
			int secondIdx	= 0;
			
			int max			= 0;
			//첫번째 값 구하기
			for (int j = 0; j < genres.length; j++) {
				if(tempGenres.equals(genres[j])) {
					//장르별 가장 큰 값 구하기 
					if (plays[j] > max) {
						max			= plays[j];
						firstIdx	= j;
					}
				}
			}
			
			//장르가 하나일 수 있으므로 max를 -1로 지정하여 구분한다.
			max	= -1;
			//두번째 값 구하기
			for (int j = 0; j < genres.length; j++) {
				if (tempGenres.equals(genres[j])) {
					if(j != firstIdx && plays[j] > max) {
						max			= plays[j];
						secondIdx	= j;
					}
				}
			}
			
			answers.add(firstIdx);
			if (max != -1) {
				answers.add(secondIdx);
			}
		}
        
        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static void main(String[] args) {
		String[] genres	= new String[] {
			"classic", "pop", "classic", "classic", "pop", "balad"/*, "balad", "balad", "balad"*/
		}; 
		
		int[] plays		= new int[] {
				500, 600, 150, 800, 2500, 6000/*, 2000, 1000, 200*/
		};
		
		int[] result	= new Solution().solution(genres, plays);
		for (int i = 0; i < result.length; i++) {
			System.out.println("result["+i+"] :: "+result[i]);
		}
	}
}
