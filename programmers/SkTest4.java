import java.util.*;
//".F.FFFFF.F", ".########.", ".########F", "...######F", "##.######F", "...######F", ".########F", ".########.", ".#...####F", "...#......"
public class SkTest4 {
    public static void main(String[] args) {
        int result = solution(new String[]{".F.FFFFF.F", ".########.", ".########F", "...######F", "##.######F", "...######F", ".########F", ".########.", ".#...####F", "...#......"}, 6);
        System.out.println(result);
    }

    //가려던 길에 연속된 숲이 이동가능횟수보다 많을 경우 야영(최대보다 많을 경우 return)
    static ArrayList<String> wents = new ArrayList<>();

    static int solution(String[] grid, int k) {
        int answer = 0;

        String[][] newGrid = new String[grid.length][grid[0].length()];
        int index = 0;
        for (String g : grid) {
            int col = 0;
            for (Character c : g.toCharArray()) {
                newGrid[index][col++] = String.valueOf(c);
            }
            index++;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length()];

        Go(newGrid, k, visited, new int[]{0,0}, "");

        int min = grid.length+grid[0].length();
        for(String went : wents){
            int hp = k;
            int count = 0;
            int location = 0;
            List<String> map = Arrays.asList(went.split(""));
            while (location < map.size()){
                if(location+hp>= map.size()-1){
                    answer = Math.min(min,count);
                    break;
                }
                if(hp>1){
                    if(map.get(location).equals(".")){
                        hp--;
                        location++;
                    }else{
                        int F = 0;
                        while (map.get(location+F).equals("F")){
                            F++;
                        }
                        if(hp>F){ //건널수 있음
                            hp-=F;
                            location+=F;
                        }
                        else{
                            count++;
                            hp = k;
                        }
                    }
                }else{
                    count++;
                    hp = k;
                }
            }
            answer = Math.min(min,count);
        }

        return answer;
    }

    static void Go(String[][] grid, int k, boolean[][] visited, int[] location, String went) {
        if (location[0] == grid.length - 1 && location[1] == grid[0].length - 1) {
            String f = "F".repeat(k);
            if (!went.matches(f)) wents.add(went+".");
            return;
        }
        for (int i = 0; i < 4; i++) {
            int mx = location[0] + Move[i][0];
            int my = location[1] + Move[i][1];
            if (!(0 <= mx && mx < grid.length && 0 <= my && my < grid[0].length)) continue;
            if (!visited[mx][my] && !grid[mx][my].equals("#")) {
                visited[location[0]][location[1]] = true;
                Go(grid, k, visited,new int[]{mx, my}, went + grid[location[0]][location[1]]);
                visited[location[0]][location[1]] = false;
            }
        }
    }
    // 상 하 좌 우
    static int[][] Move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}