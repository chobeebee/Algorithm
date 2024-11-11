class Solution {
    public int[] solution(int[] num_list) {
        int hol = 0;
        int zzak = 0;
        
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2 == 0){
                zzak++;
            }else{
                hol++;
            }
        }
        
        int[] answer = {zzak, hol};
        
        return answer;
    }
}