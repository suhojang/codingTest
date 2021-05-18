package com.example.test.sort.bignum;

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) throws Exception {
        if (numbers.length < 1 || numbers.length > 100000)
            throw new Exception("numbers의 길이는 1 이상 100,000 이하입니다.");

        for (int i=0;i<numbers.length;i++) {
            if (numbers[i] < 0 || numbers[i] > 1000)
                throw new Exception("numbers의 원소는 0 이상 1,000 이하입니다.");
        }

        String answer   = Arrays.stream(numbers)
                // 숫자를 문자열로 변환
                .mapToObj(String::valueOf)
                // 정렬
                .sorted((s1,s2) -> s2.concat(s1).compareTo(s1.concat(s2)))
                // 0으로 구성된거 빼기
                .reduce("", (s1, s2) -> s1.equals("0") && s2.equals("0") ? "0" : s1.concat(s2))
                //.collect(Collectors.joining())
                ;

        return answer;
    }

    public static void main(String[] args){
        try {
            int[] numbers   = new int[]{1, 2, 3, 4, 9, 33};

            String result   = new Solution().solution(numbers);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
