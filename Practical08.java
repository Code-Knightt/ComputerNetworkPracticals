import java.util.ArrayList;

public class Practical08 {
    public static void main(String[] args) {
        ArrayList<Integer> senderData = new ArrayList<>();

        senderData.add(32);
        senderData.add(43);
        senderData.add(12);
        senderData.add(90);

        int checksum = generateChecksum(senderData);
        senderData.add(checksum);
        verifyChecksum(senderData);

        // 43 changes to 47
        senderData.remove((Integer) 43);
        senderData.add(47);
        verifyChecksum(senderData);

    }

    static int generateChecksum(ArrayList<Integer> data){
        int[] complement = new int[data.size()];
        int nob;
        int checkSum = 0;

        for(int i =0; i<data.size();i++){
            nob = (int)(Math.floor(Math.log(data.get(i)) / Math.log(2))) + 1;
            complement[i] = ((1 << nob) - 1) ^ data.get(i);
            checkSum += complement[i];
        }
        return checkSum;
    }

    static void verifyChecksum(ArrayList<Integer> senderData){
        if(generateChecksum(senderData) == 127){
            System.out.println("Data is okay");
        } else{
            System.out.println("Data is corrupted");
        }
    }
}
