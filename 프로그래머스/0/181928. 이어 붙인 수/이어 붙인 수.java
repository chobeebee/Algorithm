class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String hol = "";
        String zzak = "";
        
        for(int i =0; i<num_list.length; i++){
            if(num_list[i]%2 == 0){
                zzak += Integer.toString(num_list[i]);
            }else{
                hol += Integer.toString(num_list[i]);
            }
        }
        answer = Integer.parseInt(hol) +Integer.parseInt(zzak);
        
        return answer;
    }
}