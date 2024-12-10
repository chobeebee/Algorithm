class Solution {
    public int solution(String message) {
        int answer = 0;        
        String[] words = message.split("");
        
        answer += words.length*2;
        
        return answer;
    }
}