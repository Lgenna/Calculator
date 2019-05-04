import java.util.Arrays;

/**
 * 
 * CSCI 338.001, 5/4/2019, Dr. Sheaffer
 * 
 * Matrix class object
 * 
 * @author Zachary Boone
 *
 */
public class Matrix {

	private int rows, columns, determinant;
	private int numbers[][];

	/**
	 * The base constructor for the matrix (The IDE was complaining)
	 */
	public Matrix() {

	}

	/**
	 * Matrix constructor that takes only a size value and creates a empty square matrix
	 * 
	 * @param size - The size of the matrix (creates a size * size square matrix)
	 */
	public Matrix(int size) {
		this(size, size);
	}

	/**
	 * Matrix constructor that takes rows and columns values and  an empty
	 * matrix of that size 
	 * 
	 * @param rows - The number of rows the matrix has
	 * @param columns - The number of the columns that the matrix has
	 */
	public Matrix(int rows, int columns) {
		if(rows > 4 || columns > 4) {
			throw new RuntimeException("Matrix dimensions too large");
		}
		this.rows = rows;
		this.columns = columns;
		numbers = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			Arrays.fill(numbers[i], 0);
		}
	}

	/**
	 * Matrix constructor that takes an 2-D array and converts it into a matrix object
	 * 
	 * @param n - An 2-D array of numbers representing the matrix object
	 */
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

	/**
	 * Getter for the row value
	 * 
	 * @return - The amount of rows the matrix has
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Getter for the column value
	 * 
	 * @return - The amount of columns that the matrix has
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Getter for the determinant value
	 * 
	 * @return - The determinant of the matrix (if it exists)
	 */
	public int getDeterminant() {
		return determinant;
	}

	/**
	 * A method to set the determinant value of the matrix
	 */
	public void determinant() {
		determinant = determinant(numbers);
	}
	
	/**
	 * Method that gets the value of an cell in the matrix
	 * 
	 * @param r - The row of the value
	 * @param c - The column of the value
	 * @return - The value at RxC
	 */
	public int getNumber(int r, int c) {
		return numbers[r][c];
	}

	@Override
	public String toString() {
		return Arrays.deepToString(numbers);
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
	
	//method that caluclates the determinant for the numbers 2-D array
	private int determinant(int[][] num) {
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

}
