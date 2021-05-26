package com.example.test.level2.heap;

import java.util.PriorityQueue;

public class Solution {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap	= new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
			heap.offer(scoville[i]);
		}
        
        //PriorityQueue 의 peek 메소드, poll 메소드 사용시 가장 작은값을 추출함.
        while(heap.peek() < K) {
        	if (heap.size() < 2)
        		return -1;
        	
        	int f1	= heap.poll();
        	int f2	= heap.poll();
        	
        	heap.offer(f1 + (f2 * 2));
        	answer++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] scoville	= {
			1, 2, 2, 2, 3, 9, 10, 12	
		};
		int K	= 7;
		
		int result	= new Solution().solution(scoville, K);
		System.out.println(result);
	}
}
