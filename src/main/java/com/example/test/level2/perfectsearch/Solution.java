package com.example.test.level2.perfectsearch;

import java.util.HashSet;

/**
 * 소수 찾기
 *
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 *  numbers는 길이 1 이상 7 이하인 문자열입니다.
 *  numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 *  "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */
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