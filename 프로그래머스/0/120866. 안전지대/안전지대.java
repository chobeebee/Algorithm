class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int size = board.length;
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == 1){
                    bombs(i,j,size,board);
                }
            }
        }
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
    
    private void bombs(int x, int y, int size, int[][]board){
        int[] dx = {0,0,1,-1,1,-1,1,-1};
        int[] dy = {1,-1,0,0,1,-1,-1,1};
        
        for(int i=0; i<dx.length; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            
            if(newX >= 0 && newY >=0 && newX < size && newY < size && board[newX][newY] == 0){
                board[newX][newY] = -1;
            }
        }
    }
}