package com.example.test.level2.hash;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Solution3 {
	public int solution(String[][] clothes) {
		return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	}

	public static void main(String[] args) {
		String[][] clothes	= new String[][] {
			{"yellowhat", "headgear"}, 
//			{"bluesunglasses", "eyewear"}, 
//			{"bluesunglasses2", "eyewear"}, 
//			{"green_turban", "headgear"}
//			{"green_turban2", "headgear"},
//			{"green_turban3", "headgear2"},
//			{"green_turban3", "headgear2"}
		};
		/*String[][] clothes	= new String[][] {
			{"crow_mask", "face"}, 
			{"blue_sunglasses", "face"}, 
			{"smoky_makeup", "face"}
		};*/
		
		int result	= new Solution3().solution(clothes);
		System.out.println(result);
	}

}
