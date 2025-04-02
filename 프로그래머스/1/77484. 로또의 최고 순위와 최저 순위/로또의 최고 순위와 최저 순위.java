class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0; //0 개수
        int match = 0; //일치하는 숫자
        
        //번호 탐색
        for(int lott : lottos){
            if(lott == 0){
                zero++;
            }else{
                for(int win : win_nums){
                    if(lott == win){
                        match++;
                        break;
                    }
                }
            }
        }
        
        int maxRank = Math.min(7-(match+zero), 6); //최고 등수
        int minRank = Math.min(7-match, 6); //최저 등수
        int[] answer = {maxRank, minRank};
        
        return answer;
    }
}