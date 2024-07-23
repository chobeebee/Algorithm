import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<Integer>();
        
        int first = -1;
        int last = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2){
                first = i;
                
                break;
            }
        }
        
        if(first!=-1){
            for(int i=first; i<arr.length; i++){
                if(arr[i] == 2){
                    last = i;
                }
            }
            for(int i=first; i<=last; i++){
                answer.add(arr[i]);
            }
        }else{
            answer.add(first);
        }    
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}