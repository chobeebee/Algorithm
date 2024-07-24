import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for(int i=n-1; i<num_list.length; i++){
            answer.add(num_list[i]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}