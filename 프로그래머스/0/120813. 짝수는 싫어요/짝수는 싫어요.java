import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            if(i <= n && i % 2 == 1){
                answer.add(i);
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}