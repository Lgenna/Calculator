import java.util.Arrays;

public class Matrix {

	private int rows, columns, determinant;
	private int numbers[][];

	public Matrix() {

	}

	public Matrix(int size) {
		this(size, size);
	}

	public Matrix(int rows, int columns) {
		if(rows > 4 || columns > 4) {
			throw new RuntimeException("Matrix dimensions too large");
		}
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
		
		if(n.length > 4 || n[0].length > 4) {
			throw new RuntimeException("Matrix dimensions too large");
		}
		
		this.rows = n.length;
		this.columns = n[0].length;
		numbers = new int[rows][columns];
		numbers = Arrays.stream(n)
				.map((int[] row) -> row.clone())
				.toArray((int length) -> new int[length][]);
		determinant();
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int getDeterminant() {
		return determinant;
	}

	public void determinant() {
		determinant = determinant(numbers);
	}

	public int determinant(int[][] num) {
		int det = 0;
		if (num.length != num[0].length) {
			return det;
		}
		if (num.length == 2) {
			det = (num[0][0] * num[1][1]) - (num[1][0] * num[0][1]);
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
				det += ((int) Math.pow(-1, i)) * (num[i][0] * determinant(temp2));
			}
		}
		return det;
	}

	public int getNumber(int r, int c) {
		return numbers[r][c];
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columns;
		result = prime * result + determinant;
		result = prime * result + Arrays.deepHashCode(numbers);
		result = prime * result + rows;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (columns != other.columns)
			return false;
		if (determinant != other.determinant)
			return false;
		if (!Arrays.deepEquals(numbers, other.numbers))
			return false;
		if (rows != other.rows)
			return false;
		return true;
	}

}
