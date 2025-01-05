class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String[] sArr = s.split("");
        int checkP = 0;
        int checkY = 0;
        
        for(String str : sArr){
            if(str.equals("p") || str.equals("P")) checkP++;
            else if(str.equals("y") || str.equals("Y")) checkY++;
        }
        
        if(checkP != checkY) answer = false;

        return answer;
    }
}