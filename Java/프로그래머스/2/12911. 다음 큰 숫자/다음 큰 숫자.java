class Solution {
    public int solution(int n) {
        int answer = countOne(n); // 입력값 n의 2진수에서 1의 개수를 구함
        
        while(true) {
            n++; // n보다 큰 수
            
            // 1의 개수가 같으면 해당 n 반환
            if(answer == countOne(n)) {
                return n;
            }
        }
    }
    
    // 정수 n의 2진수 표현에서 1의 개수를 세는 메소드
    private int countOne(int n) {
        int count = 0; // 1의 개수
        
        while( n > 0) {
            // 현재 자릿수가 1이면 횟수 증가
            if(n % 2 == 1) {
                count++;
            }
            // 다음 비트를 확인하기 위해 2로 나눔 (오른쪽 시프트)
            n /= 2;
        }
        
        // 1의 최종 개수 반환
        return count;
    }
}