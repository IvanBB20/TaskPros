package MainPackage;

import subtaskOne.NormalGraph;
import subtaskThree.WeightGraph;
import utils.Triplet;

import java.util.List;

public class Main {

    public static int taskOne(List<String> flights , String from , String to){
        NormalGraph ng = new NormalGraph(flights);
        return ng.returnMinDistance(from,to);
    }

    public static int taskThree(List<Triplet> flights, String from, String to, int groupSize){
        WeightGraph weightGraph = new WeightGraph(flights,groupSize);
        return weightGraph.returnMinDistance(from,to);
    }

    public static void main(String[] args) {

    }
}
