package com.example.test.level2.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue	= new LinkedList<Integer>();
        
        int max	= 0;
        for(int w : truck_weights) {
        	while (true) {
				if (queue.isEmpty()) {
					//weight 담기
					queue.offer(w);
					//max에 weight 추가
					max += w;
					//시간 증가
					answer++;
					break;
				} else if (queue.size() == bridge_length) {
					//queue의 길이와 다리의 길이가 같아 진다면 queue의 첫번째 트럭의 무게를 빼내서 max에서 뺀다.
					//무게를 빼서 다음거 진행을 위한 처리
					max -= queue.poll();
				} else {
					//max + 트럭의 무게가 기준치를 넘었다면 queue 0을 넣고 시간을 증가
					if (max+w > weight) {
						queue.offer(0);
						answer++;
					} else {
						queue.offer(w);
						max += w;
						answer++;
						break;
					}
				}
			}
        }
        
        return answer + bridge_length;
    }
	
	
	
	

	public static void main(String[] args) {
		int bridge_length	= 2;
		int weight			= 10;
		int[] truck_weights	= {7,4,5,6};
		
		int result	= new Solution3().solution(bridge_length, weight, truck_weights);
		System.out.println(result);
	}
}
