class Solution {
    public String[] solution(String[] picture, int k) {
        
        String[] answer = new String[picture.length * k];
        int idx = 0;
        
        for(int i=0; i<picture.length; i++){
            StringBuilder sb = new StringBuilder();
            for(char c : picture[i].toCharArray()){
                sb.append(Character.toString(c).repeat(k));
            }
            
            String result = sb.toString();
            
            for(int j=0; j<k; j++){
                answer[idx++] = result;
            }
        }
        
        return answer;
    }
}