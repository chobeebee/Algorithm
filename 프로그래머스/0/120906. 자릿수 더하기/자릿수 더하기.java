class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String[] arr = Integer.toString(n).split("");
        
        for(String a : arr){
            answer += Integer.parseInt(a);
        }
        
        return answer;
    }
}