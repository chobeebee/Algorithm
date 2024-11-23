import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int endIdx = numbers.length -1;
        
        Arrays.sort(numbers);
        
        answer += numbers[endIdx-1]*numbers[endIdx];
        
        return answer;
    }
}