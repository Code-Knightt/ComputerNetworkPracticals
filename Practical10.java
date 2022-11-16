import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Practical10 {

    static Integer inf = Integer.MAX_VALUE/2;
    static int root = 0;

    static int[] calculateNearest(int[][] nodes,int[] shortest, int perm){
        for(int i=0; i< shortest.length; i++) {
            if (shortest[perm] + nodes[perm][i] < shortest[i]) {
                shortest[i] = shortest[perm] + nodes[perm][i];
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        int [][] nodes = {
                {0,2,5,1,inf,inf},
                {2,0,3,2,inf,inf},
                {5,3,0,3,1,5},
                {1,2,3,0,1,inf},
                {inf,inf,1,1,0,2},
                {inf,inf,5,inf,2,0}
        };

        int[] shortest = new int[nodes.length];
        for(int i=0;i< nodes.length;i++){
            shortest[i] = nodes[root][i];
        }

        ArrayList<Integer> tent = new ArrayList<>();
        ArrayList<Integer> perm = new ArrayList<>();

        tent.add(root);
        while(!tent.isEmpty()){
            int minIndex = 0;
            int minDist = inf;

            for(int i=0; i< nodes.length;i++){
                if(!perm.contains(i) && shortest[i] < minDist){
                    minDist = shortest[i];
                    minIndex = i;
                }
            }
            calculateNearest(nodes, shortest, minIndex);

            perm.add(minIndex);
            tent.remove(Integer.valueOf(minIndex));

            for(int i=0; i< nodes.length; i++){
                if(!perm.contains(i) && !tent.contains(i) && nodes[minIndex][i] != inf){
                    tent.add(i);
                }
            }
        }
        System.out.println(Arrays.toString(shortest));
    }
}
