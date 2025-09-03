import java.util.*;

class Solution {
    /*
    * 보트 최대 인원 2명 : 가장 무거운 사람 + 가장 가벼운 사람을 한 보트에 태우는 것이 최적
    * 정렬 후 양쪽 끝에서 투 포인터를 이동하며 사람을 태움
    */
    public int solution(int[] people, int limit) {      
        Arrays.sort(people); // 무게 오름차순 정렬
        
        int left = 0; // 가장 가벼운 사람 index
        int right = people.length -1; // 가장 무거운 사람 index
        int boat = 0; // 보트 개수
        
        while(left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람 태울 수 있을 경우, left 이동
            if(people[left] + people[right] <= limit) {
                left++;
            }
            
            right--; // 무거운 사람은 혼자서도 타게 됨
            boat++; // 보트 사용
        }
        
        return boat;
    }
}