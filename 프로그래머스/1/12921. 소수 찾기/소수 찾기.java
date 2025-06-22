class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] primeArr = new boolean[n+1];
        
        for(int i=2; i <= n; i++) {
            if(!primeArr[i]) {
                answer++;
                
                for(int j = i*2; j <= n; j+=i) {
                    primeArr[j] = true;
                }
            }
        }
        
        return answer;
    }
}