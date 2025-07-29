class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length-2; i++){ // 첫번째 숫자
            for(int j=i+1; j<nums.length-1; j++){ // 두번째 숫자
                for(int k=j+1; k<nums.length; k++){ // 세번째 숫자
                    int sum = nums[i]+nums[j]+nums[k]; // 뽑은 3개 수 합
                    
                    boolean isPrime = true; //소수 판별
                    
                    for(int p=2; p<=Math.sqrt(sum); p++){
                        // 나누어 떨어질 경우, 소수가 아니라서 false 후 반복문 종료
                        if(sum%p == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    
                    // 소수라면 카운트
                    if(isPrime) answer++;
                }
            }
        }

        return answer;
    }
}