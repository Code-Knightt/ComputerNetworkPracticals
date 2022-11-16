import java.util.ArrayList;
import java.util.Arrays;

class Node{
    int name;
    int[] distance;
    static int inf = Integer.MAX_VALUE/2;

    Node(int name, int[] distance){
        this.name = name;
        this.distance = distance;
    }

    void updateDistance(ArrayList<Node> nodes){
        for(int i=0; i<this.distance.length; i++){
            if(distance[i] != 0 || distance[i] != inf){
                for(int j =0; j<this.distance.length; j++){
                    distance[j] = Math.min(nodes.get(this.name).distance[j],nodes.get(this.name).distance[i] + nodes.get(i).distance[j]);
                }
            }
        }
        System.out.println(Arrays.toString(this.distance));
    }
}

public class Practical11 {

    static int inf = Integer.MAX_VALUE/2;

    public static void main(String[] args) {
        Node A = new Node(0, new int[]{0, 3, 23, inf});
        Node B = new Node(1, new int[]{3, 0, 2, inf});
        Node C = new Node(2, new int[]{23, 2, 0, 5});
        Node D = new Node(3, new int[]{inf, inf, 5, 0});
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);

        for(Node node: nodes){
            node.updateDistance(nodes);
        }
    }
}
