import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int width = park[0].length();
        int height = park.length;
        
        // 방향별 이동값
        Map<String, int[]> move = new HashMap<>();
        move.put("N", new int[]{-1, 0});
        move.put("S", new int[]{1, 0});
        move.put("W", new int[]{0, -1});
        move.put("E", new int[]{0, 1});
        
        // 시작 위치 찾기
        int x = 0, y = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        //명령에 맞춰 이동
        for (String route : routes) {
            String[] parts = route.split(" ");
            String direct = parts[0]; // 주어진 방향
            int moveCount = Integer.parseInt(parts[1]); // 주어진 이동거리
            
            int nx = x; // 이동 후 좌표 x
            int ny = y; // 이동 후 좌표 y
            boolean canMove = true; // 이동할 수 있는지 체크

            for (int i = 0; i < moveCount; i++) {
                nx += move.get(direct)[0];
                ny += move.get(direct)[1];

                // 공원을 벗어나거나 장애물 발견 시
                if (nx < 0 || nx >= height || ny < 0 || ny >= width || park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }
            
            // 현 명령을 다 수행했다면, 현 위치 갱신
            if (canMove) {
                x = nx;
                y = ny;
            }
        }
        
        // 명령 완료 후, 마지막 위치 반환
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}