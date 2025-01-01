class Solution {
    public int[] solution(long n) {
        String leng = String.valueOf(n);
        int[] answer = new int[leng.length()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = leng.charAt(leng.length() - 1 - i) - '0';
        }
        
        return answer;
    }
}