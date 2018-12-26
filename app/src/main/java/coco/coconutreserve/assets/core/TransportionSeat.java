package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class TransportionSeat implements SeatAndRoom{

    private int id;
    private String name;
    private int capacity;
    private int price;
    private boolean isTaken;
    private int columnCount;
    private int pictureId;
    private String type;

    public TransportionSeat(int id, String name, int price, int columnCount,  String type) {
        this.name = name;
        this.price = price;
        isTaken = false;
        capacity = 1;
        this.id = id;
        this.columnCount = columnCount;
        this.type = type;

        if (type.equals(Constants.BUS))
        {
            this.pictureId = R.drawable.bus_seat_empty;
        }
        else if (type.equals(Constants.PLANE))
        {
            this.pictureId = R.drawable.air_seat_empty;
        }
        else if (type.equals(Constants.TRAIN))
        {
            this.pictureId = R.drawable.train_seat_empty;
        }
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
        if (type.equals(Constants.BUS))
        {
            this.pictureId = R.drawable.bus_seat_full;
        }
        else if (type.equals(Constants.PLANE))
        {
            this.pictureId = R.drawable.air_seat_full;
        }
        else if (type.equals(Constants.TRAIN))
        {
            this.pictureId = R.drawable.train_seat_full;
        }
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
