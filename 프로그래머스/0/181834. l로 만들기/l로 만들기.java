class Solution {
    public String solution(String myString) {
        String answer = "";
        
        char[] arr = myString.toCharArray();
        
        for(char a : arr){
            if(a - 'l' < 0){
                a = 'l';
            }
            answer+=Character.toString(a);
        }
        
        return answer;
    }
}