import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        int start = 0; //1
        int last = arr.length -1; //3 //2
        
        for(int i=0; i<query.length; i++){
            if(i%2 ==0){
                last = start + query[i] -1;
            }else{
                start += query[i];
            }
        }
        
        return Arrays.copyOfRange(arr,start,last+2);
    }
}