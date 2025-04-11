class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        //파일 한번에 지우기
        //top, left 최소 지점 / bottom, right 최대 지점
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        
        //바탕화면 탐색
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    //최소, 최대 갱신
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    bottom = Math.max(bottom, i+1);
                    right = Math.max(right, j+1);
                }
            }
        }
        
        answer = new int[]{top, left, bottom, right};
        
        return answer;
    }
}