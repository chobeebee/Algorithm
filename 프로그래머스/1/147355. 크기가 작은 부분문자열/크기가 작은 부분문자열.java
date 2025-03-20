class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0; i<=t.length()-p.length(); i++){
            int endIdx = i + p.length();
            long num = Long.parseLong(t.substring(i, endIdx));
            
            if(num <= Long.parseLong(p)) answer++;
        }
        
        return answer;
    }
}