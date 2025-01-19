class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        
        while(coupon>=10){
            
            int service = coupon / 10;
            
            answer += service;
            coupon = coupon % 10 + service;
        }
        
        return answer;
    }
}