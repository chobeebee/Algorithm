class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] lang = {"aya", "ye", "woo", "ma"};
        
        for(String bab : babbling){
            
            String tmp = bab;
            
            for(String l : lang){
                tmp = tmp.replace(l," ");
            }
            
            if (tmp.replace(" ", "").isEmpty()) {
                answer++;
            }
        }    
        
        return answer;
    }
}