class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int zzak = 0;
        int hol = 0;
        
        for(int i=0; i<num_list.length; i++){
            if(i%2==0){
                zzak+=num_list[i];
            }
            if(i%2==1){
                hol+=num_list[i];
            }
        }
        
        if(hol != zzak){
            answer = Math.max(hol, zzak);
        }else{
            answer = hol;
        }
        
        return answer;
    }
}