package coco.coconutreserve.assets.core;

public interface SeatAndRoom {

    String getName();
    int getCapacity();
    int getPrice();
    boolean isTaken();
    void setAsTaken();
    int getColumnCount();
    int getPicture();
    int getId();

}
