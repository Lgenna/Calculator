
import java.util.Arrays;

/**
 * 
 * CSCI 338.001, 5/4/2019, Dr. Sheaffer
 * 
 * Matrix class object
 * 
 * @author Zachary Boone, Jonas Frankemölle
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
	 * Matrix constructor that takes only a size value and creates a empty square
	 * matrix
	 * 
	 * @param size - The size of the matrix (creates a size * size square matrix)
	 */
	public Matrix(int size) {
		this(size, size);
	}

	/**
	 * Matrix constructor that takes rows and columns values and an empty matrix of
	 * that size
	 * 
	 * @param rows    - The number of rows the matrix has
	 * @param columns - The number of the columns that the matrix has
	 */
	public Matrix(int rows, int columns) {
		if (rows > 4 || columns > 4) {
			throw new RuntimeException("Matrix dimensions too large");
		}
		this.rows = rows;
		this.columns = columns;
		numbers = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			Arrays.fill(numbers[i], 0);
		}
	}

	/**
	 * Matrix constructor that takes an 2-D array and converts it into a matrix
	 * object
	 * 
	 * @param n - An 2-D array of numbers representing the matrix object
	 */
	public Matrix(int[][] n) {

		if (n.length > 4 || n[0].length > 4) {
			throw new RuntimeException("Matrix dimensions too large");
		}

		this.rows = n.length;
		this.columns = n[0].length;
		numbers = new int[rows][columns];
		numbers = Arrays.stream(n).map((int[] row) -> row.clone()).toArray((int length) -> new int[length][]);
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

	// method that calculates the determinant for the numbers 2-D array
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

	/**
	 * Adds two Matrices of the same dimension
	 *
	 * @param n - first Matrix
	 * @param m - second Matrix
	 * @return - resulting Matrix
	 */
	public static Matrix add(Matrix n, Matrix m) {
		// can only be added if same dimension!
		int[][] resultArray = new int[m.getRows()][m.getColumns()];
		int nData;
		int mData;
		int sum;
		for (int row = 0; row < m.getRows(); row++) {
			for (int col = 0; col < m.getColumns(); col++) {
				nData = n.getNumber(row, col);
				mData = m.getNumber(row, col);
				sum = nData + mData;
				resultArray[row][col] = sum;
			}
		}
		return new Matrix(resultArray);
	}

	/**
	 * Subtracts two Matrices of the same dimension
	 *
	 * @param n - first matrix
	 * @param m - second matrix
	 * @return - the resulting matrix
	 */
	public static Matrix subtract(Matrix n, Matrix m) {
		// can only be added if same dimension!
		int[][] resultArray = new int[m.getRows()][m.getColumns()];
		int nData;
		int mData;
		int sum;
		for (int row = 0; row < m.getRows(); row++) {
			for (int col = 0; col < m.getColumns(); col++) {
				nData = n.getNumber(row, col);
				mData = m.getNumber(row, col);
				sum = nData - mData;
				resultArray[row][col] = sum;
			}
		}
		return new Matrix(resultArray);
	}

	/**
	 * multiplies two matrices
	 *
	 * @param n - first matrix
	 * @param m - second matrix
	 * @return - resulting matrix
	 */
	public static Matrix multiply(Matrix n, Matrix m) {
		// If A is an n × m matrix and B is an m × p matrix
		int r1 = n.getRows();
		int r2 = m.getRows();
		int c1 = n.getColumns();
		int c2 = m.getColumns();
		// exception when dimensions are wrong
		if (c1 != r2) {
			throw new RuntimeException("Illegal matrix dimensions.");
		}

		int[][] resultArray = new int[r1][c2];

		// calculate
		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c2; j++) {
				for (int k = 0; k < c1; k++) {
					resultArray[i][j] += n.getNumber(i, k) * m.getNumber(k, j);
				}
			}
		}
		return new Matrix(resultArray);
	}

	/**
	 * scale a Matrix
	 *
	 * @param c - scalar (as an integer)
	 * @param m - matrix to be scaled
	 * @return - resulting matrix
	 */
	public static Matrix scalarMatrix(int c, Matrix m) {
		int[][] resultArray = new int[m.getRows()][m.getColumns()];
		for (int row = 0; row < m.getRows(); row++) {
			for (int col = 0; col < m.getColumns(); col++) {
				resultArray[row][col] = c * m.getNumber(row, col);
			}
		}
		return new Matrix(resultArray);
	}
	
	/**
	 * scale a Matrix
	 *
	 * @param m - matrix to be scaled
	 * @param c - scalar (as an integer)
	 * @return - resulting matrix
	 */
	public static Matrix scalarMatrix(Matrix m, int c) {
		int[][] resultArray = new int[m.getRows()][m.getColumns()];
		for (int row = 0; row < m.getRows(); row++) {
			for (int col = 0; col < m.getColumns(); col++) {
				resultArray[row][col] = c * m.getNumber(row, col);
			}
		}
		return new Matrix(resultArray);
	}



	/**
	 * transposes a matrix
	 *
	 * @param m - matrix to be transposed
	 * @return - resulting matrix
	 */
	public static Matrix transposeMatrix(Matrix m) {
		int newRows = m.getColumns();
		int newCols = m.getRows();
		int[][] resultArray = new int[newRows][newCols];

		for (int row = 0; row < m.getRows(); row++) {
			for (int col = 0; col < m.getColumns(); col++) {
				resultArray[col][row] = m.getNumber(row, col);
			}
		}
		return new Matrix(resultArray);
	}

	/**
	 * calculates the power of a matrix
	 *
	 * @param m - matrix
	 * @param a - the amount of the power
	 * @return - resulting matrix
	 */
	public static Matrix power(Matrix m, int a) {
		if (a == 1) {
			return m;
		} else {
			return (multiply(m, power(m, a - 1)));
		}
	}

	/**
	 * calculates the determinant of a matrix
	 *
	 * @param m - matrix
	 * @return - the resulting determinant
	 */
	public static int determinant(Matrix m) {
		return m.getDeterminant();
	}

	/**
	 * calculates the dot product of two three dimensional vectors
	 *
	 * @param n - first vector
	 * @param m - second vector
	 * @return - resulting dot product
	 */
	public static int dotProduct(Matrix n, Matrix m) {
		int numColumnsN = n.getColumns();
		int numColumnsM = m.getColumns();
		int numRowsN = n.getRows();
		int numRowsM = m.getRows();
		int dotProduct = 0;

		if ((numColumnsN > 1) || (numColumnsM > 1)) {
			throw new RuntimeException("Illegal matrix dimensions; columns need to be of dimension 1");
		}
		if (numRowsM != numRowsN) {
			throw new RuntimeException("Illegal matrix dimensions; vectors must have same amount of rows");
		}

		for (int i = 0; i < m.getRows(); i++) {
			dotProduct += (n.getNumber(i, 0) * m.getNumber(i, 0));
		}
		return dotProduct;
	}

	/**
	 * calculates the cross product of two vectors
	 *
	 * @param m - first vector
	 * @param n - second vector
	 * @return - resulting cross product
	 */
	public static Matrix crossProduct(Matrix m, Matrix n) {
		
		int numColumnsN = n.getColumns();
		int numColumnsM = m.getColumns();
		int numRowsN = n.getRows();
		int numRowsM = m.getRows();

		int[][] crossArr = new int[n.getRows()][n.getColumns()];

		if ((numColumnsN > 1) || (numColumnsM > 1)) {
			throw new RuntimeException("Illegal matrix dimensions; columns need to be of dimension 1");
		}
		if (numRowsM != numRowsN) {
			throw new RuntimeException("Illegal matrix dimensions; vectors must have same amount of rows");
		}
		if (numRowsM != 3 || numRowsN != 3) {
			throw new RuntimeException("Illegal matrix dimensions; vector must be of dimension 3");
		}

		crossArr[0][0] = -(n.getNumber(1, 0) * m.getNumber(2, 0) - n.getNumber(2, 0) * m.getNumber(1, 0));
		crossArr[1][0] = n.getNumber(0, 0) * m.getNumber(2, 0) - n.getNumber(2, 0) * m.getNumber(0, 0);
		crossArr[2][0] = -(n.getNumber(0, 0) * m.getNumber(1, 0) - n.getNumber(1, 0) * m.getNumber(0, 0));

		return new Matrix(crossArr);
	}
}