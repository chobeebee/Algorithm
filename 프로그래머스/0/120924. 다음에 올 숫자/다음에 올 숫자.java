class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int length = common.length;
        
        if (common[1] - common[0] == common[2] - common[1]) {
            int value = common[1] - common[0];
            answer = common[length - 1] + value;
        } else {
            int ratio = common[1] / common[0];
            answer = common[length - 1] * ratio;
        }
        
        return answer;
    }
}