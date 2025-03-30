import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d); //부서별 산정금액 정렬
        
        for(int i=0; i<d.length; i++){
            //현재 예산보다 산정금액이 작다면
            if(budget >= d[i]){
                //예산에서 차감
                budget -= d[i];
                //물품 지원 부서 추가
                answer++;
            }else{
                //예산보다 산정금액이 크다면 반복문 끝내기
                break;
            }
            
        }
        
        return answer;
    }
}