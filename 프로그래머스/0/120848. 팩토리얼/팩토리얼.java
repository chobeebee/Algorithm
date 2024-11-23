class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;
        int multi = 1;
        
        while(true){
            
            multi *= num;
            
            if(multi > n) break;
            
            answer = num++; 
        }
        
        return answer;
    }
}