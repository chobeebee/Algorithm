import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[k];
        int idx = 0;
        
        for(int i=0; i<arr.length; i++){            
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                answer[idx] = arr[i];
                idx++;
            }
            if(idx == k) break;
        }
        
        for(int i=idx; i<k; i++){
            answer[i] = -1;
        }
        
        return answer;
    }
}