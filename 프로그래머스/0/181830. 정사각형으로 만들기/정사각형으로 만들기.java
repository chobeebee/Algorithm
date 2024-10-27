import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {        
        int xLen = arr.length;
        int yLen = arr[0].length;
        
        int max = Math.max(xLen, yLen);
        int[][] answer = new int[max][max];
        
        for(int i=0; i<xLen; i++){
            for(int j=0; j<yLen; j++){
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}