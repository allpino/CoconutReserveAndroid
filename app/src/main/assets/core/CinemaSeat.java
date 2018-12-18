package assets.core;

public class CinemaSeat implements SeatAndRoom {

    private String name;
    private int capacity;
    private int price;
    private boolean isTaken;
    private int rowCount;
    private int columnCount;

    public CinemaSeat(String name, int price, int rowCount, int columnCount) {
        this.name = name;
        this.price = price;
        isTaken = false;
        capacity = 1;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
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

    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }
}
