package matrix;

public class IsValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// 初始化数据
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];

		// 遍历数独
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				// 如果单元格未被填写，跳过
				if(board[i][j] == '.') {
					continue;
				}
				// 获取数字并将其转换为数组索引
				int num = board[i][j] - '1';
				// 计算当前单元格所在的宫格索引
				int boxIndex = i / 3 * 3 + j / 3;

				// 检查当前数字是否已经在当前行、列、宫格中出现过
				if(row[i][num] || col[j][num] || box[boxIndex][num]) {
					return false;
				} else {
					row[i][num] = true;
					col[j][num] = true;
					box[boxIndex][num] = true;
				}
			}
		}

		return true;
	}

	public boolean isValidSudoku1(char[][] board) {
		boolean[][] col = new boolean[][]{};
		return false;
	}

	public static void main(String[] args) {
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		IsValidSudoku isValidSudoku = new IsValidSudoku();
		boolean validSudoku = isValidSudoku.isValidSudoku(board);
	};
}
