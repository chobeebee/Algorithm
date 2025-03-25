import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<score.length; i++){
            
            pq.offer(score[i]);
            
            //k일 이후 가장 낮은 점수 빼기
            if(pq.size() > k){
                pq.poll();
            }
            
            answer[i] = pq.peek();
            
        }        
        
        return answer;
    }
}