import java.util.Arrays;

public class Practical06 {
    public static void main(String[] args) {
        int[] message = {1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,1,0,1,0,1};
        int[] corruptMessage = {1,0,1,1,1,0,1,1,0,1,0,1,1,0,0,1,0,1,0,1};
        int[] parity = generateParityRow(message);

        checkParity(message, parity);
        checkParity(corruptMessage, parity);
    }

    static int[] generateParityRow(int[] data){

        //20 bits
        int rows = 4;
        int columns = 5;

        int[][] matrix = new int[rows][columns];
        int[] parityRow = new int[columns];
        int index=0;

        for(int i=0;i<rows;i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = data[index++];
            }
        }

        for(int j=0;j<columns;j++){
            int count =0;
            for(int i=0; i< rows;i++){
                if(matrix[i][j] == 1){
                    count++;
                }
            }
            parityRow[j] = count%2==0 ? 0:1;
        }
        return parityRow;
    }

    static void checkParity(int[] data, int[] givenParity){
        int[] generatedParity = generateParityRow(data);

        if(Arrays.equals(givenParity, generatedParity)){
            System.out.println("No error");
        } else{
            System.out.println("Corrupted bits");
        }
    }
}
