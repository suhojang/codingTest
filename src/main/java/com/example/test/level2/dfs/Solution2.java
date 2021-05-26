package com.example.test.level2.dfs;

public class Solution2 {
    int target;
    int count = 0;
    private void search(int[] numbers, int idx, int num) {
        if (idx == numbers.length) {
            if (num == target)
                count++;
            return;
        }
        search(numbers, idx+1, num + numbers[idx]);
        search(numbers, idx+1, num - numbers[idx]);
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.target = target;
        search(numbers, 0, 0);

        return count;
    }

    public static void main(String[] args){
        int[] numbers = {1, 1, 1, 1, 1};
        int target  = 3;

        System.out.println(new Solution2().solution(numbers, target));
    }
}
