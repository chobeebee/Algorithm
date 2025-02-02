class Solution {
    public String solution(String s) {
        int len = s.length();
        String answer = len%2 == 0 ? s.substring(len/2-1, len/2+1) : String.valueOf(s.charAt(len / 2));
        
        return answer;
    }
}