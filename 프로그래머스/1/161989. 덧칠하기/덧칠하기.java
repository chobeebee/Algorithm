class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int painted = 0; //덧칠한 부분 끝 위치
        
        for(int i=0; i<section.length; i++){
            //칠할 부분이 덧칠한 부분보다 클 경우
            if(section[i] > painted){
                answer++; //덧칠 횟수 추가
                painted = section[i] - 1 + m; //덧칠 끝 위치 갱신
            }
        }
        
        return answer;
    }
}