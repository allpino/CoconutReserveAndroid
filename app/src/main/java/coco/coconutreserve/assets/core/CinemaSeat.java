package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class CinemaSeat implements SeatAndRoom {

    private String name;
    private int capacity;
    private int price;
    private boolean isTaken;
    private int columnCount;
    private int pictureId;
    private int seatId;

    public CinemaSeat(int id, String name, int price, int columnCount, int pictureId) {
        this.seatId = id;
        this.name = name;
        this.price = price;
        isTaken = false;
        capacity = 1;
        this.columnCount = columnCount;
        this.pictureId = pictureId;
    }


    @Override
    public String getName() {
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
    public int getPicture() {
        return pictureId;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public int getId() {
        return seatId;
    }
}
