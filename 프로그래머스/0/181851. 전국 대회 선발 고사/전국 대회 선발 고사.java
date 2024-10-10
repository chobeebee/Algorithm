import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] newRank = new int[rank.length];
        
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                newRank[i] = rank[i];
            }else{
                rank[i] = Integer.MAX_VALUE;
            }
        }
        
        Arrays.sort(rank);
        
        for(int i=0; i<rank.length; i++){
            if(rank[0] == newRank[i]){
                answer+=i*10000;
            }else if(rank[1] == newRank[i]){
                answer+=i*100;
            }else if(rank[2] == newRank[i]){
                answer+=i;
            }
        }
        
        return answer;
    }
}