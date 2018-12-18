package assets.core;

public interface SeatAndRoom {

    String getName();
    int getCapacity();
    int getPrice();
    boolean isTaken();
    void setAsTaken();
    int getRowCount();
    int getColumnCount();

}
