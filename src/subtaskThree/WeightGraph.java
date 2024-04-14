package subtaskThree;

import subtaskOne.NormalGraph;
import subtaskThree.customPair.Edge;
import utils.Triplet;

import java.util.*;

public class WeightGraph {

    private HashMap<String,ArrayList<Edge>> g;
    private NormalGraph ng;
    private Integer groupSize;


    public WeightGraph(){
        this.g=new HashMap<>();
        this.ng = new NormalGraph();
    }

    public WeightGraph(List<Triplet> flights,Integer groupSize){
        int n = flights.size();
        this.groupSize=groupSize;
        this.g=new HashMap<>();
        this.ng=new NormalGraph();
        for(int i=0;i<n;i++){
            this.addEdge(flights.get(i).getFrom(),flights.get(i).getTo(),flights.get(i).getCapacity());
        }

    }
    /*
    * Here we remove the unnecessary edges
    * whose weight is smaller than capacity
    * because since we have to travel in the group together
    * we will not be able to take that flight.
    * We are making our graph into a NormalGraph
    * and finding the shortest distance from source to destination.
    * We are doing this because we know that in our NormalGraph
    * the group can travel together and this problem now translates to Subtask1
    */
    private void makeGraphNormal(){
        this.ng = new NormalGraph();
        int size = this.g.size();
        for(Map.Entry<String, ArrayList<Edge>> elem : g.entrySet()){
            String v = elem.getKey();
            ArrayList<Edge> e = elem.getValue();

            if(!this.ng.getG().containsKey(v)){
                this.ng.getG().put(v,new ArrayList<>());
            }

            for(Edge cur : e){
                if(cur.weight() >= groupSize){
                    this.ng.addEdge(v,cur.neighbour());
                }
            }

        }
    }
    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public void addEdge(String from,String to,Integer weight){
        Edge e = new Edge(weight,to);
        if(!g.containsKey(from)){
            g.put(from,new ArrayList<>());
        }

        g.get(from).add(e);
    }



    public int returnMinDistance(String from, String to){
        makeGraphNormal();
        return this.ng.returnMinDistance(from,to);
    }

}
