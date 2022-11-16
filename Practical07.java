import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CRC{

    List<Integer> generateMessage(int[] message, Integer[] key){
        List<Integer> dividend = new ArrayList<>();

        for(int bit: message){
            dividend.add(bit);
        }

        for(int i=0;i< key.length-1;i++){
            dividend.add(0);
        }

        List<Integer> remainder = generateRemainder(dividend, key);

        for(int i=key.length-2;i>0;i--){
            dividend.set(dividend.size()-i, remainder.get(key.length-1-i));
        }

        return dividend;
    }
    List<Integer> generateRemainder(List<Integer> dividend, Integer[] key){
        List<Integer> keyList = new ArrayList<>(Arrays.asList(key));
        ArrayList<Integer> remainder = new ArrayList<>();

        for(int k=0;k<key.length;k++){
            remainder.add(dividend.get(k));
        }

        for(int i=key.length-1; i<dividend.size();i++){
            if(remainder.get(0) == 0){
                remainder.remove(0);
                if(i!= dividend.size()-1){
                remainder.add(dividend.get(i+1));
                }
                continue;
            }

            for(int index=0; index < key.length; index++){
                remainder.set(index,remainder.get(index) ^ keyList.get(index));
            }
            remainder.remove(0);
            if(i!= dividend.size()-1){
                remainder.add(dividend.get(i+1));
            }
        }
        return remainder;
    }

    void verifyMessage(List<Integer> code,  Integer[] key){
        List<Integer> obtainedRemainder = this.generateRemainder(code, key);
        List<Integer> zeros =  new ArrayList<>();
        for(int i=0; i<key.length-1;i++){
            zeros.add(0);
        }

        if(obtainedRemainder.equals(zeros)){
            System.out.println("No error");
        } else{
            System.out.println("Corrupted Bits");
        }
    }
}

public class Practical07 {
    public static void main(String[] args) {
        int[] message = {1,0,0,1,0,0};
        Integer[] key ={1,1,0,1};
        CRC check = new CRC();

        List<Integer> codeWord = check.generateMessage(message, key);
        check.verifyMessage(codeWord, key);
        codeWord.remove(0);
        codeWord.add(0,0);
        check.verifyMessage(codeWord, key);
    }
}
