import java.util.*;
class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        String[] arr = my_string.split("");
        
        for(int i=0; i<queries.length; i++){
            int first = queries[i][0];
            int end = queries[i][1];
            
            for(int j=end; j>first; j--){
                String temp = arr[first];
                arr[first] = arr[j];
                arr[j] = temp;
                first++;
            }
        }
        
        for(int k=0; k<arr.length; k++){
            answer+=arr[k];
        }
        
        return answer;
    }
}