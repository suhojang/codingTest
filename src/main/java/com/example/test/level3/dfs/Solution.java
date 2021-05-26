package com.example.test.level3.dfs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 여행경로
 *
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 *
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 		모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 * 		주어진 공항 수는 3개 이상 10,000개 이하입니다.
 * 		tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 * 		주어진 항공권은 모두 사용해야 합니다.
 * 		만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 * 		모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 *
 * 입출력 예
 * tickets																				return
 * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]										["ICN", "JFK", "HND", "IAD"]
 * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]		["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 *
 * 입출력 예 설명
 * 예제 #1
 *
 * ["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.
 *
 * 예제 #2
 *
 * ["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
 *
 */
public class Solution {

	boolean[] visited;                    //방문한지 안한지를 체크하는 visited배열
    ArrayList<String> answers;

	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];    
        answers = new ArrayList<String>();
        
        int count = 0;                                    //몇개의 공항을 들렸는지 알려주는 카운트
        dfs(count, "ICN", "ICN", tickets);
        
        Collections.sort(answers);                        //답들 중 가장 알파벳순이 빠른 배열들로 정렬
        String[] answer = answers.get(0).split(" ");    //가장 빠른 배열을 뽑아서 String형 배열로 만듬
        return answer;
    }
	
	public void dfs(int count, String present, String answer, String[][]ticktes) {
        if(count == ticktes.length) {            //모든 공항을 들렸다면
            answers.add(answer);                //answers에 추가
            return;
        }
        
        for(int i = 0; i < ticktes.length; i++) {
            if(!visited[i] && ticktes[i][0].equals(present)) {        //present와 같고 들리지 않은 공항을 찾고
                visited[i] = true;                                    //해당 공항을 들린걸로 만듬.
                
              //카운트 +1 도착 공항을 present로 넣어주고 answer에 도착공항을 추가해준다.
                dfs(count + 1, 
            		ticktes[i][1],
            		answer+" "+ticktes[i][1], 
            		ticktes
            		);
                
                visited[i] = false;
            }
        }
    }
	
	
	public static void main(String[] args) {
		String[][] tickets	= new String[][] {
				{"ICN", "JFK"}, 
				{"HND", "IAD"},
				{"JFK", "HND"}
		};
		
		String[] result	= new Solution().solution(tickets);
		for (String res	: result) {
			System.out.println(res);
		}
		
		System.out.println();
		System.out.println();
		
		tickets	= new String[][] {
			{"ICN", "SFO"}, 
			{"ICN", "ATL"}, 
			{"SFO", "ATL"}, 
			{"ATL", "ICN"}, 
			{"ATL","SFO"}
		};
		new Solution().solution(tickets);
		result	= new Solution().solution(tickets);
		for (String res	: result) {
			System.out.println(res);
		}
	}
}
