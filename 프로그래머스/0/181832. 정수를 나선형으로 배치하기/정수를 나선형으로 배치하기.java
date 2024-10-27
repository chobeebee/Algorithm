class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int startX = 0;
        int endX = n-1;
        int startY = 0;
        int endY = n-1;
        int cnt = 1;
        
        while(cnt <= n*n){
            
            for(int i=startY; i<=endY; i++){
                answer[startX][i] = cnt++;
            }
        
            for(int i=startX+1; i<=endX; i++){
                answer[i][endY] = cnt++;
            }
        
            for(int i=endY-1; i>=startY; i--){
                answer[endX][i] = cnt++;
            }
        
            for(int i=endX-1; i>startX; i--){
                answer[i][startY] = cnt++;
            }
        
            startX++;
            startY++;
            endX--;
            endY--;           
        }
        
        return answer;
    }
}