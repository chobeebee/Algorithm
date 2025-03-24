import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(n != 0){
            
            //순간이동 최대로
            if(n % 2 == 0){
                n /= 2;
            }else{
                n--; //한 칸 점프
                ans++; //배터리 소모
            }
            
        }

        return ans;
    }
}