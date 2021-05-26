package com.example.test.level3.dfs;

public class Solution2 {
	int answer;                        //최소 단계
    boolean[] used;                    //단어를 사용 중인지를 판단하는 visited와 같은 역할을 하는 배열
	/**
	 * 
	 * @param begin		출발 문자열
	 * @param target	도착 문자열
	 * @param words		주어지는 문자열 배열
	 * @return
	 */
	/**
	 * @param begin
	 * @param target
	 * @param words
	 * @return
	 */
	public int solution(String begin, String target, String[] words) {
		//단어 최대값이 50이므로
		answer = 51;
        used = new boolean[words.length];
        
        dfs(begin, target, 0, words);
        
      //answer이 51이면 target과 같은 단어가 없는 것으로 판단.
        return answer == 51 ? 0 : answer;
    }
	
	public void dfs(String begin, String target, int count,String[] words) {
        if(begin.equals(target)) {
            answer = (answer > count) ? count : answer;
            return;
        }
        
        //탐색한 글자중 하나만 차이나고 탐색되지 않은 글자이 있다면. dfs 수행
        for(int i = 0; i < words.length; i++) {
            if(!used[i] && check(begin, words[i])) {
                used[i] = true;
                dfs(words[i], target, count+1, words);
                
                used[i] = false;
            }
        }
    }
    
	//주어진 문자열과 비교대상의 문자열의 다른문자열 차이가 하나인지 검증
    public boolean check(String begin, String nextWord) {
        int count = 0;
        for(int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }

	/**
	 * 	각 단어는 알파벳 소문자로만 이루어져 있습니다.
		
		각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
		
		words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
		
		begin과 target은 같지 않습니다.
		
		변환할 수 없는 경우에는 0를 return 합니다.
		
		예를 들어 begin이 
		"hit", target가 "cog", 
		words가 ["hot","dot","dog","lot","log","cog"]라면 
		"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이
		 4단계를 거쳐 변환할 수 있습니다.
		
	 * @param args
	 */
	public static void main(String[] args) {
		String begin	= "hit";
		String target	= "cog";
		
		String[] words	= new String[]{
				"hot", 
				"dot", 
				"dog", 
				"lot", 
				"log", 
				"cog"
		};
		
		Solution2 solution	= new Solution2();
		System.out.println(solution.solution(begin, target, words));
		System.out.println();
		
		begin	= "hit";
		target	= "cog";
		words	= new String[]{
				"hot",
				"dot", 
				"dog", 
				"lot", 
				"log"
		};
		System.out.println(solution.solution(begin, target, words));
		
	}

}
