import java.util.Arrays;

public class Matrix {
	
	int rows, columns;
	int numbers[][];
	
	public Matrix(int size) {
		this(size, size);
	}
	
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		numbers = new int[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				numbers[i][j] = 0;
			}
		}
	}
	
	public Matrix(int[][] n) {
		this.rows = n.length;
		this.columns = n[0].length;
		numbers = new int[rows][columns];
		numbers = Arrays.stream(n)
				.map((int[] row) -> row.clone())
				.toArray((int length)-> new int[length][]);
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < rows; i++) {
			s += "| ";
			for(int j = 0; j < columns; j++) {
				s += numbers[i][j] + " ";
			}
			s += "|\n";
		}
		return s;
	}
}
