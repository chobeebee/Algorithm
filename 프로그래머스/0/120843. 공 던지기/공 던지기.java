import java.util.*;

class Solution {
    public int solution(int[] numbers, int k) {
        int n = numbers.length;
        return numbers[((k-1) * 2) % n];
    }
}