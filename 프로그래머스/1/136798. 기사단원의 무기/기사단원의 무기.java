class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            //약수 개수 찾기
            int attackNum = getAttackNum(i);
            //약수 개수가 제한 수치보다 크면 공격력 수치를 더함
            answer += attackNum > limit ? power : attackNum;
        }
        
        return answer;
    }
    
    public int getAttackNum(int n){
        
        int count = 0; //약수 개수
        
        //n의 제곱근까지 탐색
        for(int i=1; i*i <= n; i++){
            if(n % i == 0){
                //i는 약수
                count++;
                
                //n/i도 약수
                if(n/i != i) count++;
            }
        }
        
        return count;
    }
}