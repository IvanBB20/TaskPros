package MainPackage;

import org.junit.jupiter.api.Test;
import utils.Triplet;

import java.util.List;

import static MainPackage.Main.taskOne;
import static MainPackage.Main.taskThree;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void ShortestPathDirectTaskOne(){
        List<String> flights = List.of("SOF","IST","IST","CMB","CMB","MLE");
        //SOF->IST;IST->CMB ;CMB->MLE;
        assertEquals(3,taskOne(flights,"SOF","MLE"));
    }

    @Test
    public void ShortestPathDoesNotExistTaskOne(){
        List<String> flights = List.of("SOF","IST","CMB","IST","IST","DIB");
        //SOF->IST ; CMB->IST ; IST->DIB;
        assertEquals(0,taskOne(flights,"SOF","CMB"));// No connection between the cities
        assertEquals(0,taskOne(flights,"RED","SOF"));//Non-existing source
        assertEquals(0,taskOne(flights,"SOF","RED"));//Non-existing destination
        assertEquals(0,taskOne(flights,"DIB","SOF"));//No path for the flight
    }

    @Test
    public void testShortestPathDirectTaskOne() {
        List<String> flight = List.of("SOF","IST");
        assertEquals(1,taskOne(flight,"SOF","IST"));
    }

    @Test
    public void testShortestPathMoreCitiesTaskOne() {
        List<String> flights = List.of("SOF","IST","IST","CMB","SOF","LHR","LHR","CMB","CMB","BPK","BPK","HKA","HKA","NRT");
        //SOF->IST ; IST->CMB ; SOF->LHR;LHR->CMB;CMB->BPK;BPK->HKA;HKA->NRT;
        assertEquals(5,taskOne(flights,"SOF","NRT"));
        assertEquals(2,taskOne(flights,"CMB","HKA"));
        assertEquals(3,taskOne(flights,"IST","HKA"));
    }

    @Test
    public void ShortestPathIndirectTaskThree(){
        List<Triplet> flights = List.of(
                Triplet.of("SOF","MLE",2) ,
                Triplet.of("LON","MLE",3),
                Triplet.of("SOF","LON",3)
        );
       assertEquals(2,taskThree(flights,"SOF","MLE",3));

    }

    @Test
    public void ShortestPathMoreCitiesAndCapacityIsAvailableTaskThree(){

        List<Triplet> flights = List.of(
                Triplet.of("SOF","IST",3) ,
                Triplet.of("SOF","LHR",1),
                Triplet.of("LHR","CMB",2),
                Triplet.of("IST","CMB",4),
                Triplet.of("CMB","BPK",5),
                Triplet.of("BPK","HKA",3),
                Triplet.of("HKA","NRT",2)
        );
        assertEquals(3,taskThree(flights,"SOF","BPK",3));
        assertEquals(3,taskThree(flights,"IST","HKA",3));
        assertEquals(2,taskThree(flights,"CMB","HKA",3));
        assertEquals(5,taskThree(flights,"SOF","NRT",2));
        assertEquals(4,taskThree(flights,"LHR","NRT",2));
    }

    @Test
    public void ShortestPathNoExistNoCapacityTaskThree(){

        List<Triplet> flights = List.of(
                Triplet.of("SOF","IST",3) ,
                Triplet.of("SOF","LHR",1),
                Triplet.of("LHR","CMB",2),
                Triplet.of("IST","CMB",4),
                Triplet.of("CMB","BPK",5),
                Triplet.of("BPK","HKA",3),
                Triplet.of("HKA","NRT",2)
        );
        assertEquals(0,taskThree(flights,"SOF","BPK",5));
        assertEquals(0,taskThree(flights,"IST","HKA",5));
        assertEquals(0,taskThree(flights,"CMB","HKA",5));
    }

    @Test
    public void ShortestPathNoExistButCapacityIsAvailableTaskThree(){
        List<Triplet> flights = List.of(
                Triplet.of("SOF","IST",3) ,
                Triplet.of("SOF","LHR",1),
                Triplet.of("LHR","CMB",2),
                Triplet.of("IST","CMB",4),
                Triplet.of("CMB","BPK",5),
                Triplet.of("BPK","HKA",3),
                Triplet.of("HKA","NRT",2)
        );
        assertEquals(0,taskThree(flights,"LHR","SOF",2));
        assertEquals(0,taskThree(flights,"CMB","SOF",2));
        assertEquals(0,taskThree(flights,"IST","LHR",2));
    }
}

