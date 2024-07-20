class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";        
        String temp = my_string.substring(s,e+1);
        
        StringBuffer sb = new StringBuffer(temp);
        String reverse = sb.reverse().toString();
        
        answer = my_string.replace(temp, reverse);
        
        return answer;
    }
}