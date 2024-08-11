class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int max = 2147483647;
        
        if(num_list.length >= 11){
            for(int num : num_list){
                answer+=num;
            }
        }else{
            int tmp = 1;
            for(int num : num_list){
                tmp *= num;
            }
            if(tmp < max){
                answer = tmp;
            }
        }
        
        return answer;
    }
}