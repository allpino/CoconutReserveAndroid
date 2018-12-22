package coco.coconutreserve.assets.core;

public interface Place {

    public String getName();

    public String getDescription();

    public int getCapacity();

    public double getScore();

    public String toString();

    SeatAndRoom[][] getSeats();

    SeatAndRoom[][] getSeats(int indexOfMid);

    int getPicture();

    int getId();

}
