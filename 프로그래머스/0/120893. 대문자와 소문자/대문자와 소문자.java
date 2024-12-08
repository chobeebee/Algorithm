class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i=0; i<my_string.length(); i++){
            
            char character = my_string.charAt(i);
            
            if(character>='a'){
                answer+=Character.toUpperCase(character);
            }else{
                answer+=Character.toLowerCase(character);
            }
        }
        
        return answer;
    }
}