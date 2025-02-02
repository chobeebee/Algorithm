class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] talk = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++){
            String bab = babbling[i];
            boolean flag = false;
            
            for(String t : talk){
                 if(bab.contains(t+t)){
                     flag = true;
                     break;
                 }
            }
            
            if(flag) continue;
            
            for (String t : talk) {
                bab = bab.replace(t, " ");
            }
            
            
            if(bab.replace(" ", "").length() == 0) answer++;
        }
        
        return answer;
    }
}