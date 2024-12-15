class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        int w = (board[0]-1)/2;
        int h = (board[1]-1)/2;
        
        for (String key : keyinput) {
            
            switch (key) {
                    
                case "left":
                    if (x > -w) x -= 1;
                    break;
                    
                case "right":
                    if (x < w) x += 1;
                    break;
                    
                case "up":
                    if (y < h) y += 1;
                    break;
                    
                case "down":
                    if (y > -h) y -= 1;
                    break;
            }
        }
        
        answer[0] = x;
        answer[1] = y;        
        
        return answer;
    }
}