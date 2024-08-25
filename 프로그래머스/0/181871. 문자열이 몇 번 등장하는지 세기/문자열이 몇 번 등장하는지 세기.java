class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int length = myString.length()-pat.length();
        
        for(int i=0; i<=length; i++){
            String tmp = myString.substring(i,i+pat.length());
            if(tmp.equals(pat)){
                answer++;
            }
        }
        
        return answer;
    }
}