class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        int lastNum=num_list.length;
        
        for(int i =0; i<lastNum; i++){
            answer[i]=num_list[i];
        }
        if(num_list[lastNum-2] < num_list[lastNum-1]) {
                answer[lastNum] = num_list[lastNum-1] - num_list[lastNum-2];
            }else{
                answer[lastNum] = num_list[lastNum-1] *2;
            }
        
        return answer;
    }
}