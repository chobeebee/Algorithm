class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for(int i=0; i<myString.length(); i++){
            char tmp = myString.charAt(i);
            if(tmp == 'a'){
                answer+= Character.toUpperCase(tmp);
            } else if ('A'< tmp && tmp <='Z'){
                answer+= Character.toLowerCase(tmp);
            }else{
                answer+=tmp;
            }
        }
        
        return answer;
    }
}