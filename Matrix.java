import java.util.Arrays;

public class Matrix {

	int rows, columns, determinant;
	int numbers[][];

	public Matrix(int size) {
		this(size, size);
	}

	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		numbers = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				numbers[i][j] = 0;
			}
		}
	}

	public Matrix(int[][] n) {
		this.rows = n.length;
		this.columns = n[0].length;
		numbers = new int[rows][columns];
		numbers = Arrays.stream(n).map((int[] row) -> row.clone()).toArray((int length) -> new int[length][]);
		determinant();
	}

	public void determinant() {
		if (rows != columns) {
			determinant = 0;
		}
		if (rows == 2) {
			determinant = (numbers[0][0] * numbers[1][1]) - (numbers[1][0] * numbers[0][1]);
		} else {
			for (int i = 0; i < rows; i++) {
				int[][] temp = new int[rows - 1][];
				int k = 0;
				for (int j = 0; j < rows; j++) {
					if (j != i) {
						temp[k] = Arrays.copyOfRange(numbers[j], 1, rows);
						k++;
					}
				}
				System.out.println(Arrays.deepToString(temp));
				int tempdet2 = determinant(temp);
				determinant += ((int) Math.pow(-1, i)) * (numbers[i][0] * tempdet2);
				System.out.println(Math.pow(-1, i) + " * " + numbers[i][0] + " * " + tempdet2 + "\n");
			}
		}
	}

	private int determinant(int[][] num) {
		int det = 0;
		if (num.length == 2) {
			det = (num[0][0] * num[1][1]) - (num[1][0] * num[0][1]);
			System.out.println(det);
		} else {
			for (int i = 0; i < num.length; i++) {
				int[][] temp2 = new int[num.length - 1][];
				int k = 0;
				for (int j = 0; j < num.length; j++) {
					if (j != i) {
						temp2[k] = Arrays.copyOfRange(num[j], 1, num.length);
						k++;
					}
				}
				System.out.println(Arrays.deepToString(temp2));
				int tempdet = determinant(temp2);
				det += ((int) Math.pow(-1, i)) * (num[i][0] * tempdet);
				System.out.println(Math.pow(-1, i) + " * " + num[i][0] + " * " + tempdet + "\n");
			}
		}
		return det;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < rows; i++) {
			s += "| ";
			for (int j = 0; j < columns; j++) {
				s += numbers[i][j] + " ";
			}
			s += "|\n";
		}
		return s;
	}

}
