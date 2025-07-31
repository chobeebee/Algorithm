import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {        
        int height = park.length; // 공원 세로 길이
        int width = park[0].length; // 공원 가로 길이
        
        Arrays.sort(mats); // 돗자리 크기 정렬
        
        // 큰 돗자리부터 진행
        for(int i=mats.length-1; i >= 0; i--) {
            int size = mats[i];
            
            // 돗자리 영역 탐색
            for(int h=0; h<=height-size; h++) {
                for(int w=0; w<=width-size; w++){
                    // 현재 위치부터 size × size가 모두 빈 자리인지 확인
                    if(seatOk(h, w, park, size)){
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean seatOk(int h, int w, String[][] park, int size) {
        // 시작 좌표부터 size × size 영역에 사람이 한 명이라도 있으면 false 반환
        for(int i=h; i<h+size; i++) {
            for(int j=w; j<w+size; j++) {
                if(!park[i][j].equals("-1")) return false;
            }
        }
        // 모든 칸이 비어 있다면 true (돗자리 깔 수 있음)
        return true;
    }
}