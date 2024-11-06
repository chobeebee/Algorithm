class Solution {
    public int solution(int n) {
        int answer = 1;
        
        while(true){
            if((6*answer) % n==0){
                
                return answer;
                
            }else{
                answer++;
            }
        }
    }
}