public class Math extends Matrix {

    public Matrix add(Matrix n, Matrix m) {
        // Note: can only be added if same dimension!
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

    public int add(int n, int m){
        return n + m;
    }

    public Matrix subtract(Matrix n, Matrix m) {
        // Note: can only be added if same dimension!
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

    public int subtract(int n, int m){
        return n - m;
    }

    public Matrix multiply(Matrix n, Matrix m) {
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

    public int multiply(int n, int m){
        return n * m;
    }

    public Matrix scalarMatrix(int c, Matrix m){
        int[][] resultArray = new int[m.getRows()][m.getColumns()];
        for(int row=0; row<m.getRows(); row++){
            for(int col=0; col<m.getColumns(); col++){
                resultArray[row][col] = c * m.getNumber(row, col);
            }
        }
        return new Matrix(resultArray);
    }

    public Matrix transposeMatrix(Matrix m){
        int newRows = m.getColumns();
        int newCols = m.getRows();
        int[][] resultArray = new int[newRows][newCols];

        for(int row=0; row<m.getRows(); row++){
            for(int col=0; col<m.getColumns(); col++){
                resultArray[col][row] = m.getNumber(row, col);
            }
        }
        return new Matrix(resultArray);
    }

}
