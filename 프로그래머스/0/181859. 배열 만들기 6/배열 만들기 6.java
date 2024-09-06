import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int i=0;
        
        while(i<arr.length){
            if(answer.isEmpty()){
                answer.add(arr[i]);
                i++;
            }else if(answer.get(answer.size()-1)==arr[i]){
                answer.remove(answer.size()-1);
                i++;
            }else{
                answer.add(arr[i]);
                i++;
            }
        }
                                                                          
        if(answer.isEmpty()){
            answer.add(-1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}