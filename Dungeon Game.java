class Solution {
        public int calculateMinimumHP(int[][] dungeon) {

        int row = dungeon.length;
        int column = dungeon[0].length;

        int[][] tem = new int[row][];
        for (int i = 0; i < tem.length; i++) {
            tem[i] = new int[column];
        }

        if (dungeon[row - 1][column - 1] >= 0) {
            tem[row - 1][column - 1] = 1;
        } else {
            tem[row - 1][column - 1] = 1 - dungeon[row - 1][column - 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            tem[i][column - 1] = c(dungeon[i][column - 1], tem[i + 1][column - 1]);
        }

        for (int j = column - 2; j >= 0; j--) {
            tem[row - 1][j] = c(dungeon[row - 1][j], tem[row - 1][j + 1]);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                tem[i][j] = Math.min(c(dungeon[i][j], tem[i + 1][j]),
                        c(dungeon[i][j], tem[i][j + 1]));
            }
        }

        return tem[0][0];
    }

    private int c(int value, int preResult) {
        if (value == 0)
            return preResult;

        if (value > 0) {
            if (value >= preResult)
                return 1;
            return preResult - value;
        }

        return preResult - value;
    }
}
}