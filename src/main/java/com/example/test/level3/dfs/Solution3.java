package com.example.test.level3.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 네트워크 
 *
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * 제한사항
 *      컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 *      각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 *      i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 *      computer[i][i]는 항상 1입니다.
 *
 * 입출력 예
 * n	computers	                        return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 *
 * 입출력 예 설명
 * 예제 #1
 * 아래와 같이 2개의 네트워크가 있습니다.
 */
public class Solution3 {
    public int solution(int n, int[][] computers) {
        List<Set<Integer>> group   = new ArrayList<>();
        Set<Integer> network       = null;
        Set<Integer> network2      = null;
        
        for(int i=0;i<n;i++){
            network 	= check(group, i);
            if(network==null){
                network       = new HashSet<>();
                network.add(i);
                group.add(network);
            }
            
            for(int j=0;j<n;j++){
                if(i!=j && computers[i][j]==1){
                    network2 = check(group, j);
                    if(network2==null)
                    	network.add(j);
                    else if(!network2.contains(i)){
                    	network.addAll(network2);
                    	group.remove(network2);
                    }
                }
            }
        }
        
        return group.size();
    }
    
    public Set<Integer> check(List<Set<Integer>> group, int n){
        for(int i=0;i<group.size();i++){
            if(group.get(i).contains(n))
                return group.get(i);
        }
        return null;
    }
    
    public static void main(String[] args) {
    	int n	= 3;
    	int[][] computers	= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    	
    	int result	= new Solution3().solution(n, computers);
    	System.out.println(result);
    }

}
