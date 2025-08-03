class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int zeroCount = 0; // 현재 문자열의 0개수
            
            // 0 제거 후 길이 차이 만큰 0개수 누적
            for(char c : s.toCharArray()){
                if(c == '0') zeroCount++;
            }
            
            answer[1] += zeroCount; // 제거한 0 개수 누적
            s = s.replace("0",""); // 0제거
            s = Integer.toBinaryString(s.length()); // 2진변환
            answer[0]++; //변환 횟수 증가
        } 
        
        return answer;
    }
}