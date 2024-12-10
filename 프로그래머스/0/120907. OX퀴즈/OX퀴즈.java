class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++){
            String[] tmp = quiz[i].split(" ");
            int sum = Integer.parseInt(tmp[0]);
            
            if(tmp[1].equals("-")){
                sum -= Integer.parseInt(tmp[2]);
            }else{
                sum += Integer.parseInt(tmp[2]);
            }
            
            answer[i] = (sum == Integer.parseInt(tmp[4])) ? "O": "X";
        }
        
        return answer;
    }
}