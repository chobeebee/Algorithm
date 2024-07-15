import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<intStrs.length; i++){
            int txt = Integer.parseInt(intStrs[i].substring(s,s+l));
            if(txt > k){
                list.add(txt);
            }
        }
        
        int[] arr = new int[list.size()];
        
        for(int j=0; j<list.size(); j++){
            arr[j] = list.get(j);
        }
        
        return arr;
    }
}