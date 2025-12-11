class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int r = buildings.length;
        int cnt = 0;

        for (int i = 0; i < r; i++) {
            int a = buildings[i][0];
            int b = buildings[i][1];

            if (a > n || b > n) continue;

            boolean TopN = false;
            boolean BottomN = false;
            boolean LeftN = false;
            boolean RightN = false;

            for (int[] p : buildings) {
                int x = p[0];
                int y = p[1];

                if (x == a && y < b)   TopN = true;
                if (x == a && y > b)   BottomN = true;
                if (x < a && y == b)   LeftN = true;
                if (x > a && y == b)   RightN = true;
            }

            if (TopN && BottomN && LeftN && RightN) {
                cnt++;
            }
        }

        return cnt;
    }
}