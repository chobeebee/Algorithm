class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<nums.length; i++){
            numbers = numbers.replace(nums[i], String.valueOf(i));
        }
        
        answer = Long.parseLong(numbers);
        
        return answer;
    }
}