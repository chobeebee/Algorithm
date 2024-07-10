import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=l; i<=r; i++){
            if(Integer.toString(i).matches("[05]+")){
                list.add(i);
            }
        }
        
        if(list.isEmpty()){
            list.add(-1);
        }
        
        int[] answer = new int[list.size()];
        
        for(int j=0; j<list.size(); j++){
            answer[j] = list.get(j);
        }
        
        return answer;
    }
}