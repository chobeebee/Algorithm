class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int gop = 1;
        int hap = 0;
        
        for(int i=0; i<num_list.length; i++){
            gop *= num_list[i];
            hap += num_list[i];
        }
           
        if(gop < (hap*hap)){
            answer=1;
        }else{
            answer=0;
        }
        
        return answer;
    }
}