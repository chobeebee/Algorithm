class Solution {
    public String solution(String polynomial) {
        int constSum = 0;
        int xSum = 0;
        String[] polyArr = polynomial.split(" ");
        
        for(String poly : polyArr){
            
            if(poly.contains("x")){
                
                String tmp = poly.replace("x", "");
                
                if (tmp.isEmpty()) {
                    xSum += 1;                    
                }else {
                    xSum += Integer.parseInt(tmp);
                }
                
            }else if(!poly.equals("+")){
                constSum += Integer.parseInt(poly);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        if(xSum != 0){
            if(xSum == 1){
                answer.append("x");
            }else{
                answer.append(xSum).append("x");
            }
        }
        
        if(constSum != 0){
            if(xSum != 0){
                answer.append(" + ").append(constSum);
            }else{
                answer.append(constSum);
            }
        }
        
        return answer.toString();
    }
}