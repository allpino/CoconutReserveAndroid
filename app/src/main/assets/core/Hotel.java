package assets.core;

public class Hotel implements Place{

    //IMPORTANT: If new variable is added, change Init as well
    private String name;
    private String description;
    private int capacity;
    private HotelRoom[][] hotelRooms;
    private int numOfRooms;
    private double score;

    public Hotel(String name, String description, int numOfRooms, double score)
    {
        if (name == null || description == null || numOfRooms == 0 || score == 0)
        {
            throw new NullPointerException("Parameters of hotel is empty");
        }
        else if (score > 10.0)
        {
            throw new ArithmeticException("Score can not be higher than 10");
        }

        this.name = name;
        this.description = description;
        this.numOfRooms = numOfRooms;
        this.score = score;
        capacity = 0;

        hotelRooms = new HotelRoom[2][numOfRooms/2];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j <  numOfRooms/2; j++)
            {
                int room_cap = Utils.randomWithRange(1,5);
                HotelRoom room = new HotelRoom((char)(65 +i) + "-" + j, room_cap,
                        room_cap*10,numOfRooms/2,2);
                hotelRooms[i][j] = room;
                this.capacity += room_cap;
            }
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
    public String getDescription() {
        return description;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    @Override
    public double getScore() {
        return score;
    }

    public HotelRoom[][] getHotelRooms() {
        return hotelRooms;
    }
}
