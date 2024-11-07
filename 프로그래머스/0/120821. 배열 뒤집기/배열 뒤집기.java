class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length - 1;
        int[] answer = new int[size + 1];
        
        for(int i = size; i >= 0; i--){
            answer[size-i] = num_list[i];
        }
        
        return answer;
    }
}