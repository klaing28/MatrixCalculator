import java.util.Random;
public class MatrixGenerator { // class for generating a random matrix of given size

    public static int[][] generateMatrix(int rowNumber, int columnNumber) // parameters are size of the matrix
    {
        int[][] output = new int[rowNumber][columnNumber]; // 2d array object for storing the matrix
        Random random = new Random(); // Random class object for creating random parameters
        for (int row=0;row<rowNumber;row++){
            for(int column=0;column<columnNumber;column++){
                output[row][column] = random.nextInt(255); // assigning random parameters
            }
        }
        return output;
    }
}
