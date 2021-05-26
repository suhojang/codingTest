package com.example.test.level1.dfs;

public class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int num) {
        if (index == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return dfs(numbers, target, index + 1, num + numbers[index]) + dfs(numbers, target, index + 1, num - numbers[index]);
        }

    }

    public static void main(String[] args){
        int[] numbers = {1, 1, 1, 1, 1};
        int target  = 3;

        System.out.println(new Solution().solution(numbers, target));
    }
}
