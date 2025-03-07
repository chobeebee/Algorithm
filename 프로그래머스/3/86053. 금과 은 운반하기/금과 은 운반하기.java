class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
                
        long left = 0;
        long right = 400000000000000L;
        
        //이진탐색
        while(left < right){
            
            long mid = (left+right)/2;
            
            if(isPossible(mid, a, b, g, s, w, t)){
                right = mid;
            }else{
                left = mid + 1;
            }
            
        }
        
        return left;
    }

    public boolean isPossible(long mid, int a, int b, int[] g, int[] s, int[] w, int[] t){
        
        int len = g.length; //도시 수
        
        //금, 은, 총 운반량 기록 변수
        long totalG = 0L;
        long totalS = 0L;
        long total = 0L;

        //각 도시 별 운반량 탐색
        for(int i=0; i<len; i++){

            long roundTrip = mid / (2 * t[i]); //왕복 횟수
            if (mid % (2 * t[i]) >= t[i]) roundTrip++; //편도

            //운반할 수 있는 양
            long transAmount = Math.min(roundTrip * w[i], g[i] + s[i]);

            totalG += Math.min(transAmount, g[i]); //최대 g[i]까지
            totalS += Math.min(transAmount, s[i]); //최대 s[i]까지
            total += transAmount; //금은 총 운반량
        }

        //목표량(a, b)을 만족하는지 체크
        if(totalG >= a && totalS >= b && total >= (a+b)){
            return true;
        }else{
            return false;
        }
    }
}