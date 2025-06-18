class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        
        for(int i=1; i < a; i++) {
            count += months[i];
        }
        
        count += b - 1;
        answer = days[count%7];
        
        return answer;
    }
}