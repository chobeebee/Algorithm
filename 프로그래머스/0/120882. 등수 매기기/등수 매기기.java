import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        double[] avg = new double[score.length];
        
        for(int i = 0; i < score.length; i++){
            avg[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        int[] answer = new int[score.length];
        for(int i = 0; i < score.length; i++){
            int rank = 1;
            for(int j = 0; j < score.length; j++){
                if(avg[j] > avg[i]){
                    rank++;
                }
            }
            answer[i] = rank;
        }
        
        return answer;
    }
}