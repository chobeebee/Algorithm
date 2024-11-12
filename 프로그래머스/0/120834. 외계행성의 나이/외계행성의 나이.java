class Solution {
    public String solution(int age) {
        String[] strAge = String.valueOf(age).split("");
        String alpha = "abcdefghij";
        String answer = "";
        
        for(int i=0; i<strAge.length; i++){
            
            answer+= alpha.charAt(Integer.valueOf(strAge[i]));
        }
        
        return answer;
    }
}