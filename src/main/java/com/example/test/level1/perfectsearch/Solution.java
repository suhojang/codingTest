package com.example.test.level1.perfectsearch;

import java.util.ArrayList;

public class Solution {
	public int[] solution(int[] answer) {
		int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == person1[i%person1.length]) {score[0]++;}
            if(answer[i] == person2[i%person2.length]) {score[1]++;}
            if(answer[i] == person3[i%person3.length]) {score[2]++;}
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

	public static void main(String[] args) {
		int[] answers	= new int[] {
				1,2,3,4,5
		};
		int[] result	= new Solution().solution(answers);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
