package com.example.test.level2.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> list	= new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
			list.add((int)Math.ceil((100 - progresses[i]) / (float) speeds[i]));
		}
        
        Map<Integer,Integer> orderMap	= new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
        	if(i==0) {
        		orderMap.put(i, 1);
        		continue;
        	}
        	
        	if(list.get(i-1) >= list.get(i)) {
        		orderMap.put(i-1, orderMap.get(i-1) + 1);
        		list.remove(i);
        		i--;
        	} else {
        		orderMap.put(i, 1);
        	}
		}
        
        Object[] mapKey	= orderMap.keySet().toArray();
        Arrays.sort(mapKey);
        
        return new ArrayList<>(orderMap.values()).stream().mapToInt(i->i.intValue()).toArray();
    }

	public static void main(String[] args) {
		int[] progresses	= {93, 30, 55};
		int[] speeds		= {1, 30, 5};
		
		int[] result	= new Solution().solution(progresses, speeds);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
