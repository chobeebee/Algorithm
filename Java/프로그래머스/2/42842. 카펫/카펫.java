class Solution {
    /*
    * yellow == (가로 - 2) * (세로 - 2)
    * total == brown + yellow == 가로 * 세로
    */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow; // 전체 카펫 수
        
        // 가로, 세로가 3이상이어야 함
        for(int height=3; height<=total; height++) {
            // 가로 길이가 딱 떨어지지 않으면 넘김
            if(total % height != 0 ) continue;
            int width = total / height; // 가로
            
            // 가로가 세로보다 같거나 길어야 함
            if(width >= height) {
                int brownNum = (width * 2) + (height * 2) - 4; // 테두리 갈색 수
                
                // 현 길이의 brown 개수 와 주어진 brown 개수가 같다면 출력
                if(brownNum == brown) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }
        
        return answer;
    }
}