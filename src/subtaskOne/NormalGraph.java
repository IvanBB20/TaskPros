package subtaskOne;

import java.util.*;

public class NormalGraph {

    private HashMap<String, ArrayList<String>> g;


   public NormalGraph(){
            g=new HashMap<>();
    }

    public NormalGraph(List<String> flights){
            g=new HashMap<>();
            int n = flights.size();
            if(n%2==1){
                System.out.println("Cannot be made");
                return;
            }
            for(int i=0;i<n;i+=2){
                this.addEdge(flights.get(i),flights.get(i+1));
            }

    }

    public HashMap<String, ArrayList<String>> getG() {
        return g;
    }

    public void addEdge(String from , String to){
            if(!g.containsKey(from)){
                g.put(from,new ArrayList<String>());
            }
            g.get(from).add(to);
    }

    public int returnMinDistance(String from,String to){
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashMap<String,Integer> distance = new HashMap<String, Integer>();
        HashSet<String> visited = new HashSet<>();
        queue.addLast(from);
        visited.add(from);
        distance.put(from , 0);

        while (!queue.isEmpty()){
            String cur = queue.getFirst();
            queue.removeFirst();
            ArrayList<String> neighbours = g.getOrDefault(cur,new ArrayList<>());
            if(neighbours.isEmpty()){
                break;
            }
            int size = neighbours.size();
            for(int i = 0;i<size;i++){
                boolean isVisited = visited.contains(neighbours.get(i));
                if(!isVisited){
                    int newDistance = distance.get(cur) + 1;
                    visited.add(neighbours.get(i));
                    distance.put(neighbours.get(i) , newDistance);
                    queue.addLast(neighbours.get(i));
                }
            }
        }

        return distance.getOrDefault(to,0);
    }


    @Override
    public String toString() {
        return "NormalGraph{" +
                "g=" + g +
                '}';
    }
}
