import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practical04 {

    static List<Integer> flag = Arrays.asList(0,1,1,1,1,1,1,0);

    public static void main(String[] args) {
        Integer[] message = {1,1,1,1,1,1,1,1,1,1,1,0,0};
        Integer[] frame = framing(message);

        System.out.print("Message: ");
        printArray(message);
        System.out.println("Frame with flags and bit stuffing: ");
        printArray(frame);
    }

    static <T> void printArray(T[] array){
        for (T element: array){
            System.out.print(element);
        }
        System.out.println();
    }

    static Integer[] framing(Integer[] message){
        List<Integer> frame = new ArrayList<>();
        List<Integer> stuffedMessage = bitStuffing(message);

        frame.addAll(flag);
        frame.addAll(stuffedMessage);
        frame.addAll(flag);

        return frame.toArray(new Integer[0]);
    }

    static List<Integer> bitStuffing(Integer[] message){

        List<Integer> data = new ArrayList<>();

        data.addAll(Arrays.asList(message));

        int consecutiveCount = 1;

        for(int i=0; i< data.size()-1;i++){
            if(data.get(i).equals(data.get(i+1)) && data.get(i)==1){
                consecutiveCount++;
                if (consecutiveCount == 5){
                    data.add(i+2, 0);
                    consecutiveCount = 1;
                }
            }else {
                consecutiveCount = 1;
            }
        }
        return data;
    }
}
