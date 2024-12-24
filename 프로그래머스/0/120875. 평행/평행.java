class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x1 = dots[0][0], y1 = dots[0][1];
        int x2 = dots[1][0], y2 = dots[1][1];
        int x3 = dots[2][0], y3 = dots[2][1];
        int x4 = dots[3][0], y4 = dots[3][1];
        
        //(점1, 점2)와 (점3, 점4) 비교
        if ((y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1)) return 1;
        
        //(점1, 점3)와 (점2, 점4) 비교
        if ((y3 - y1) * (x2 - x4) == (y4 - y2) * (x3 - x1)) return 1;
        
        //(점1, 점4)와 (점2, 점3) 비교
        if ((y4 - y1) * (x3 - x2) == (y3 - y2) * (x4 - x1)) return 1;
        
        return 0;
    }
}