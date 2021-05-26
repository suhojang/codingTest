package com.example.test.level2.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	class Printer{
		int location;
		int prior;
		
		public Printer(int location, int prior) {
			this.location	= location;
			this.prior		= prior;
		}
	}
	
	public int solution(int[] priorities, int location) {
        int answer 		= 0;
        
        Queue<Printer> queue	= new LinkedList<>();
        //Queue에 index, 우선순위 넣기
        for (int i = 0; i < priorities.length; i++) {
			queue.offer(new Printer(i, priorities[i]));
		}
        
        while (!queue.isEmpty()) {
			boolean flag	= false;
			int prior		= queue.peek().prior;
			for (Printer printer : queue) {
				//앞에 숫자보다 큰 숫자가 존재하는지 확인
				if (prior < printer.prior) {
					flag	= true;
				}
			}
			
			if (flag) {
				//꺼내서 다시 넣기(뒤로 이동)
				queue.offer(queue.poll());
			} else {
				//queue가 돌면서 location의 값이 
				int loc	= queue.poll().location;
				if (loc == location) {
					answer	= priorities.length - queue.size();
				}
			}
		}
        
        return answer;
    }
	
	

	public static void main(String[] args) {
		int[] priorities	= {
				2, 1, 3, 2, 1, 2	
		};
		int location		= 4;
		
		int result	= new Solution2().solution(priorities, location);
		System.out.println(result);
	}
}
