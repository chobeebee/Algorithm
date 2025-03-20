class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0, maxHeight = 0;
        
        for(int i=0; i<sizes.length; i++){
            int[] size = sizes[i];
            //큰 값이 가로, 작은 값이 세로
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            
            //가로, 세로를 최대값을 갱신
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        
        int answer = maxWidth * maxHeight;
        
        return answer;
    }
}