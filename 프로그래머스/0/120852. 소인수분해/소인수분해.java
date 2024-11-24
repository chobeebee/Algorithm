import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 2;
        
        while(n > 1){
            
            if(n%num == 0){
                
                if(!list.contains(num)) {
                    list.add(num);
                }
                n /= num;
                
            }else{
                
                num++;
            }            
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}