import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int diff = Integer.MAX_VALUE;
        
        for(int i=0; i<array.length; i++){
            int current = Math.abs(array[i]-n);
            
            if(diff > current || (current == diff && array[i] < answer)){
                answer = array[i];
                diff = current;
            }
        }
        
        return answer;
    }
}