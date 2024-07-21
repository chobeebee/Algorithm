class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num-end_num+1];
        int size = start_num-end_num;
        
        for(int i=0; i<=size; i++){
            answer[i] = start_num;
            start_num--;
        }
        
        return answer;
    }
}