/*Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.

version1: 01/04/2018*/



    public int countCornerRectangles(int[][] grid) {
        if (grid.length == 0 || grid.length == 0) {
            return 0;
        }
        int res = 0, cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = i+1; j < grid.length; j++) {
                cnt = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        cnt++;
                    }
                }
                res += cnt * (cnt-1) / 2;
            }
        }
        return res;
    }