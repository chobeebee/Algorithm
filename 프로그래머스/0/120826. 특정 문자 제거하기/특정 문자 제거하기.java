class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        String[] arr = my_string.split("");
        
        for(String str : arr){
            if(!str.equals(letter)){
                answer+=str;
            }
        }
        
        return answer;
    }
}