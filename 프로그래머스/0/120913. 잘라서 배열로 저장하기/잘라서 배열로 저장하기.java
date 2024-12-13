class Solution {
    public String[] solution(String my_str, int n) {
        int leng = my_str.length();
        int size = (int)Math.ceil((double)leng/n);
        String[] answer = new String[size];
        
        for(int i=0; i<size; i++){
            
            int start = i * n;
            int end = Math.min(start + n, leng);
            
            answer[i] = my_str.substring(start, end);
        }
        
        return answer;
    }
}