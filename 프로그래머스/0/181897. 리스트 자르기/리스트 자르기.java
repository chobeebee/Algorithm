import java.util.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> answer = new ArrayList<Integer>();
        
        
        if(n==1){
            for(int i=0; i<=slicer[1]; i++){
                answer.add(num_list[i]);
            }
        }else if(n==2){
            for(int i=slicer[0]; i<num_list.length; i++){
                answer.add(num_list[i]);
            }
        }else if(n==3){
            for(int i=slicer[0]; i<=slicer[1]; i++){
                answer.add(num_list[i]);
            }
        }else if(n==4){
            for(int i=slicer[0]; i<=slicer[1]; i+=slicer[2]){
                answer.add(num_list[i]);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}