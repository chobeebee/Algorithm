import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 중복 방지를 위해 set사용
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        // 잃어 버린 친구 세팅
        for(int l : lost){
            lostSet.add(l);
        }
        
        // 여분 가진 친구가 잃어 버린 친구와 동일하면
        for(int r : reserve){
            if(lostSet.contains(r)){
                // 잃어 버린 친구 리스트에서 제거
                lostSet.remove(r);
                
            }else{
                // 동일하지 않다면, 빌려줄 친구 리스트에 추가
                reserveSet.add(r);
            }
        }
        
        // 여분 친구의 앞 이나 뒤 친구에게 빌려주기 
        for(int r : reserveSet){
            // 빌렸으니 잃어버린 친구는 리스트에서 삭제
            if(lostSet.contains(r-1)){
                lostSet.remove(r-1);
                
            }else if(lostSet.contains(r+1)){
                lostSet.remove(r+1);
            }
        }
        
        // 전체 학생 수 - 못 빌린 친구
        answer = n - lostSet.size();
        
        return answer;
    }
}