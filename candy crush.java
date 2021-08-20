class Solution {
    public int[][] candyCrush(int[][] board) {
		// find candies that need to be crushed
		// update board
		while (update(board)) {
            //update(board);
        }
		return board;

	}

	boolean update(int[][] board) {
        //System.out.println("called");
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] shouldDelete = new boolean[rows][cols];
		boolean hasDelete = false;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
                
				if (board[i][j] == 0) continue;
                
				if (j >= 2 && board[i][j] == board[i][j-1] && board[i][j] == board[i][j-2]) {
                    
					shouldDelete[i][j-2] = shouldDelete[i][j-1] = shouldDelete[i][j] = true;
					hasDelete = true;
                    
				}

				if (i >= 2 && board[i][j] == board[i-1][j] && board[i][j] == board[i-2][j]) {
                    
					shouldDelete[i-2][j] = shouldDelete[i-1][j] = shouldDelete[i][j] = true;
					hasDelete = true;
                    
				}
			}
            
		}

		if (!hasDelete) {
			return false;
		}

		// collapse columns
		for (int col = 0; col < cols; col++) {
			int writeIndex = rows-1;
			for (int row = rows-1; row >= 0; row--) {
				if (!shouldDelete[row][col]) board[writeIndex--][col] = board[row][col];
			}
			for (; writeIndex >= 0; writeIndex--) {
				board[writeIndex][col] = 0;
			}
		}
		return hasDelete;
	}
}