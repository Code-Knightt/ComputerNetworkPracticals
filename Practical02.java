class TranspositionCipher{
    String encrypt(String text, int width){
        StringBuilder tempText = new StringBuilder(text);
        while(tempText.length() % width != 0){
            tempText.append("_");
        }

        int rows = tempText.length()/width;
        char[][] matrix = new char[rows][width];
        int k=0;

        for(int j=0; j<rows;j++){
            for(int i=0;i<width;i++){
                matrix[j][i] = tempText.charAt(k++);
            }
        }
        tempText.setLength(0);
        for(int i=0; i<width;i++){
            for(int j=0;j<rows;j++){
                tempText.append(matrix[j][i]);
            }
        }
        return tempText.toString();
    }

    String decrypt(String text, int width){
        StringBuilder tempText = new StringBuilder(text);
        int rows = tempText.length()/width;
        char[][] matrix = new char[rows][width];
        int k=0;

        for(int i=0; i<width;i++){
            for(int j=0;j<rows;j++){
                matrix[j][i] = tempText.charAt(k++);
            }
        }
        tempText.setLength(0);
        for(int j=0; j<rows;j++){
            for(int i=0;i<width;i++){
                tempText.append(matrix[j][i]);
            }
        }
        return tempText.toString();
    }
}

public class Practical02 {
    public static void main(String[] args) {
        String s1 = "Hello World";
        int width = 4;

        TranspositionCipher cipher = new TranspositionCipher();
        System.out.println("Original: " + s1);
        String encryptedS1 = cipher.encrypt(s1, width);
        System.out.println("Encrypted: " + encryptedS1);
        String decryptedS1 = cipher.decrypt(encryptedS1, width);
        System.out.println("Decrypted: " + decryptedS1);
    }
}
