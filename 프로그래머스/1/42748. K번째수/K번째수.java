import java.util.*;

class Solution {   
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] arr = commands[i];
            int start = arr[0] - 1;
            int end = arr[1];
            int num = arr[2] - 1;
            
            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);
            
            answer[i] = subArray[num];
        }
        
        return answer;
    }
}