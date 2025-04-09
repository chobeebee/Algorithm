import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        //재료 쌓을 용
        Stack<Integer> stack = new Stack<>();
        
        for(int i : ingredient){
            
            stack.push(i); //현 재료 stack에 쌓기
            
            //stack 크기가 4개 이상일 경우, 쌓인 재료 파악
            if(stack.size() >= 4){              
                //빵-야채-고기-빵 순서가 맞다면 햄버거 개수++
                if(stack.get(stack.size()-1) == 1 &&
                   stack.get(stack.size()-2) == 3 &&
                   stack.get(stack.size()-3) == 2 &&
                   stack.get(stack.size()-4) == 1){
                    
                    answer++;
                    
                    //만든 햄버거 stack에서 빼기
                    for(int j=0; j<4; j++){
                        stack.pop();
                    }
                }
            }
        }
        
        return answer;
    }
}