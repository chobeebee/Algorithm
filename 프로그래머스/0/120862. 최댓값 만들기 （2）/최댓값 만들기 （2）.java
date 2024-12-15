import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        int leng = numbers.length;
        
        Arrays.sort(numbers);
        
        int maxNum = numbers[leng-2]*numbers[leng-1];
        int minNum = numbers[0]*numbers[1];
        
        return Math.max(maxNum, minNum);
    }
}