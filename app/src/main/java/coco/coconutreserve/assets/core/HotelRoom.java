package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class HotelRoom implements SeatAndRoom{

    //IMPORTANT: If new variable is added, change Init as well
    private String roomName;
    private int roomCapacity;
    private boolean isTaken;
    private int price;
    private int rowCount;
    private int columnCount;
    private int pictureId;

    public HotelRoom(String roomName, int roomCapacity, int price, int rowCount, int columnCount,
                     int pictureId)
    {
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.isTaken = false;
        this.price = price;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.pictureId = pictureId;
    }

    @Override
    public int getCapacity() {
        return roomCapacity;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isTaken() {
        return isTaken;
    }

    @Override
    public void setAsTaken() {
        isTaken = true;
        pictureId = R.drawable.bed_full;
    }

    @Override
    public String toString(){
        return roomName;
    }

    @Override
    public String getName() {
        return roomName;
    }

    @Override
    public int getRowCount(){
        return rowCount;
    }

    @Override
    public int getColumnCount(){
        return columnCount;
    }

    @Override
    public int getPicture() {
        return pictureId;
    }
}
