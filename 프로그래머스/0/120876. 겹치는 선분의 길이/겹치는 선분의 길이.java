class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] count = new int[201];
        
        for(int[] l : lines){
            int start = l[0] + 100;
            int end = l[1] + 100;
            
            for(int i=start; i<end; i++){
                count[i]++;
            }
        }
        
        for(int c: count){
            if(c > 1) answer++;
        }
        
        return answer;
    }
}