import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int size = 1;
        
        while(size < arr.length){
            size *= 2;
        }
        
        return Arrays.copyOf(arr,size);
    }
}