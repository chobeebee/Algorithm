class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long val = x;
        
        for(int i=0; i<n; i++){
            answer[i] = val;
            val+=x;
        }
        
        return answer;
    }
}