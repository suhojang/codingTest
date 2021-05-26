package com.example.test.level2.stackQueue;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
	public int[] solution(int[] prices) {
//        int[] answer = {};
        
        List<Integer> list	= new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
        	int check	= 0;
			for (int j = i+1; j < prices.length; j++) {
//				System.out.println("prices["+i+"] :: "+prices[i] + ", prices["+j+"] :: " + prices[j]);
				
				check++;
				if (prices[i] > prices[j]) {
					break;
				}
			}
//			System.out.println();
			list.add(check);
		}
        
        return list.stream().mapToInt(i->i.intValue()).toArray();
        
        //return answer;
    }

	public static void main(String[] args) {
		int[] prices	= {
				1, 2, 3, 2, 1, 4, 2
		};
		
		int[] result	= new Solution4().solution(prices);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
