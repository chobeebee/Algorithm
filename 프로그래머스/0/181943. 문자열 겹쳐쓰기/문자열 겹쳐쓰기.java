class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        for(int i =0; i < 2; i++){
            String temp = "";
            int length = overwrite_string.length()+s;
            temp = my_string.substring(0,s)+overwrite_string+my_string.substring(length);
            answer = temp;
        }        
        
        return answer;
    }
}