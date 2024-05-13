import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] result;
        int minRow, maxRow, minCol, maxCol;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    list.add(new int[]{i, j});
                }
            }
        }
        
        int lastIndex = list.size() - 1;
        
        list.sort((x, y) -> x[0] - y[0]);
        minRow = list.get(0)[0];
        maxRow = list.get(lastIndex)[0];
        
        list.sort((x, y) -> x[1] - y[1]);
        minCol = list.get(0)[1];
        maxCol = list.get(lastIndex)[1];
        
        result = new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
        
        return result;
    }
}