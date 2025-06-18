class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i < food.length; i++) {
            int count = food[i] / 2;
            sb.append(String.valueOf(i).repeat(count));
        }
        
        String right = sb.reverse().toString();
        sb.reverse();
                      
        return sb.append("0").append(right).toString();
    }
}