package assets.core;

public interface Place {

    public String getName();

    public String getDescription();

    public int getCapacity();

    public double getScore();

    public String toString();

    default SeatAndRoom[][] getSeats(int saloonNum)
    {
        if (this instanceof Cinema)
        {

        }
    }
}
