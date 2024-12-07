class Solution {
    public int solution(int order) {
        
        String str = Integer.toString(order);        
        String answer = str.replaceAll("[^369]", "");
        
        return answer.length();
    }
}