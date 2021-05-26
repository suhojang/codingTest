package com.example.test.level2.perfectsearch;

import java.util.HashSet;

public class Solution {

    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);

            //2는 소수이므로 count증가
            if(a==2)
                count++;

            //2는 나머지가 0이므로 패스 됨.
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }

        return count;
    }

    public boolean isPrime(int n){
        //0, 1는 소수가 아니므로 false 리턴
        if(n==0 || n==1)
            return false;
        //2는 위에서 처리했으므로 3부터 시작하고 제곱근을 구해서
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }

    //순열루틴 방식
    //전달 된 숫자문자열을 순차적으로 돌면서 set에 담는다.
    public void permutation(String prefix, String numbers, HashSet<Integer> set) {
        int len = numbers.length();

        if(!prefix.equals(""))
            set.add(Integer.valueOf(prefix));

        for (int i = 0; i < len; i++) {
            permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, len), set);
        }
    }

    public static void main(String[] args){
        String numbers  = "17";
        int count   = new Solution().solution(numbers);
        System.out.println(count);
    }
}