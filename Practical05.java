public class Practical05 {
    public static void main(String[] args) {
        int[] bits = {1,1,0,1,1,0,1,0};
        int[] corruptBits = {1,1,0,1,1,0,0,0};
        int parityBit = generateEvenParityBit(bits);
        detectError(bits, parityBit);
        detectError(corruptBits, parityBit);
    }

    static int generateEvenParityBit(int[] bits){
        int count=0;
        int parityBit;

        for(int bit: bits){
            if(bit==1){
                count++;
            }
        }

        parityBit = count%2==0 ? 0 : 1;

        return parityBit;
    }

    static void detectError(int[] bits, int parityBit){
        int count=0;

        for(int bit: bits){
            if(bit==1){
                count++;
            }
        }

        if(count%2==parityBit){
            System.out.println("No error");
        } else {
            System.out.println("Bits corrupted");
        }
    }
}
