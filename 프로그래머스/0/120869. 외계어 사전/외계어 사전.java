class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for(String str : dic){
            
            boolean check = true;
            
            for(String s : spell){
                if(!str.contains(s)){
                    check = false;
                    break;
                }                
            }
            if(check){
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
}