package utils;

public class Triplet{
    private String from;
    private String to;
    private int capacity;

    public Triplet(String from, String to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
    }

    public static Triplet of(String from_,String to_,int capacity_){
        return new Triplet(from_,to_,capacity_);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
