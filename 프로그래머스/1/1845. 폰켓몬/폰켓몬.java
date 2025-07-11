import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            int getMon = nums.length/2;
            if(set.size() < getMon) {
                set.add(num);
            }
        }
        
        return set.size();
    }
}