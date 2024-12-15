class Solution {
    public int solution(int[][] dots) {
        
        int w = 0;
        int h = 0;
        int x = dots[0][0];
        int y = dots[0][1];
        
        for(int i=0; i<dots.length; i++){
            int curX = dots[i][0];
            int curY = dots[i][1];
            
            if(x!=curX) w = Math.abs(x-curX);
            if(y!=curY) h = Math.abs(y-curY);
        }
        
        return w*h;
    }
}