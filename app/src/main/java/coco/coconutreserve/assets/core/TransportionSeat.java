package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class TransportionSeat implements SeatAndRoom{

    private int id;
    private String name;
    private int capacity;
    private int price;
    private boolean isTaken;
    private int rowCount;
    private int columnCount;
    private int pictureId;

    public TransportionSeat(int id, String name, int price, int rowCount, int columnCount, int pictureId) {
        this.name = name;
        this.price = price;
        isTaken = false;
        capacity = 1;
        this.id = id;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.pictureId = pictureId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int getCapacity() {
        return capacity;
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
        pictureId = R.drawable.seat_full;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public int getPicture() {
        return pictureId;
    }

    @Override
    public int getId() {
        return id;
    }
}
