public class Calculate extends Matrix {

    public Calculate() {
        super();
    }

    /**
     *
     * @param n
     * @param m
     * @return
     */
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

    /**
     *
     * @param n
     * @param m
     * @return
     */
    public int add(int n, int m){
        return n + m;
    }

    /**
     *
     * @param n
     * @param m
     * @return
     */
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

    /**
     *
     * @param n
     * @param m
     * @return
     */
    public int subtract(int n, int m){
        return n - m;
    }

    /**
     *
     * @param n
     * @param m
     * @return
     */
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

    /**
     *
     * @param n
     * @param m
     * @return
     */
    public int multiply(int n, int m){
        return n * m;
    }

    /**
     *
     * @param c
     * @param m
     * @return
     */
    public Matrix scalarMatrix(int c, Matrix m){
        int[][] resultArray = new int[m.getRows()][m.getColumns()];
        for(int row=0; row<m.getRows(); row++){
            for(int col=0; col<m.getColumns(); col++){
                resultArray[row][col] = c * m.getNumber(row, col);
            }
        }
        return new Matrix(resultArray);
    }

    /**
     *
     * @param m
     * @return
     */
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

    /**
     *
     * @param m
     * @param a
     * @return
     */
    public Matrix power(Matrix m, int a){
        if(a == 1){
            return m;
        }
        else{
            return (multiply(m, power(m, a-1)));

            //m = multiply(m, m);
            //return power(m, a-1);
        }
    }

    /**
     *
     * @param a
     * @param n
     * @return
     */
    public int power(int a, int n) {
        if (n == 0) {
            return 1;
        }
        else{
            return (a * (power(a, n-1)));
        }
    }

    /**
     *
     * @param m
     * @return
     */
    public int determinant(Matrix m) {
        return m.getDeterminant();
    }

    /**
     *
     * @param n
     * @param m
     * @return
     */
    public int dotProduct(Matrix n, Matrix m){
        int numColumnsN = n.getColumns();
        int numColumnsM = m.getColumns();
        int numRowsN = n.getRows();
        int numRowsM = m.getRows();
        int dotProduct = 0;

        if((numColumnsN > 1)|| (numColumnsM > 1)){
            throw new RuntimeException("Illegal matrix dimensions; columns need to be of dimension 1");
        }
        if(numRowsM != numRowsN){
            throw new RuntimeException("Illegal matrix dimensions; vectors must have same amount of rows");
        }

        for(int i=0; i<m.getRows(); i++){
            dotProduct += (n.getNumber(i, 0) * m.getNumber(i, 0));
        }
        return dotProduct;
    }

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public Matrix crossProduct(Matrix m, Matrix n){
        int numColumnsN = n.getColumns();
        int numColumnsM = m.getColumns();
        int numRowsN = n.getRows();
        int numRowsM = m.getRows();

        int[][] crossArr = new int[n.getRows()][n.getColumns()];

        if((numColumnsN > 1)|| (numColumnsM > 1)){
            throw new RuntimeException("Illegal matrix dimensions; columns need to be of dimension 1");
        }
        if(numRowsM != numRowsN){
            throw new RuntimeException("Illegal matrix dimensions; vectors must have same amount of rows");
        }
        if(numRowsM != 3 || numRowsN != 3){
            throw new RuntimeException("Illegal matrix dimensions; vector must be of dimension 3");
        }

        crossArr[0][0] = -(n.getNumber(1,0) * m.getNumber(2, 0)
                - n.getNumber(2,0) * m.getNumber(1,0));
        crossArr[1][0] = n.getNumber(0,0) * m.getNumber(2,0)
                - n.getNumber(2,0) * m.getNumber(0, 0) ;
        crossArr[2][0] = -(n.getNumber(0, 0) * m.getNumber(1,0)
                - n.getNumber(1,0) * m.getNumber(0,0));

        return new Matrix(crossArr);
    }
}

