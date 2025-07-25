import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 담는 바구니
        
        for(int m : moves) {
            int col = m - 1; // 배열 0부터
            
            for(int row=0; row<board.length; row++) {
                if(board[row][col] != 0) {
                    // 0이 아닐 경우 뽑고 0 처리
                    int pick = board[row][col];
                    board[row][col] = 0;
                    
                    // stack이 비어있지 않고 꼭대기에 있는 인형과 뽑은 인형이 같을 경우, 터트림
                    if(!stack.isEmpty() && stack.peek() == pick) {
                        stack.pop();
                        answer+= 2; // 터진 인형 개수
                    } else {
                        // 아닐 경우, 바구니에 넣기
                        stack.push(pick);
                    }
                    
                    // 인형 한게 뽑고 종료
                    break;
                }
            }
        }
        
        return answer;
    }
}