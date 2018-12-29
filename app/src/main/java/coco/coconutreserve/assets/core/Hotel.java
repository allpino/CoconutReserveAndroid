package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class Hotel implements Place{

    //IMPORTANT: If new variable is added, change Init as well
    private int hotelId;
    private String name;
    private String description;
    private int capacity;
    private HotelRoom[] hotelRooms;
    private int numOfRooms;
    private double score;
    private int pictureId;
    private Locations.Location location;
    private String excursions;
    private Discount discount;
    public Hotel(int id, String name, String description, int numOfRooms, double score, int pictureId, Locations.Location location)
    {
        if (name == null || description == null || numOfRooms == 0 || score == 0 || location == null)
        {
            throw new NullPointerException("Parameters of hotel is empty");
        }
        else if (score > 10.0)
        {
            throw new ArithmeticException("Score can not be higher than 10");
        }

        this.hotelId = id;
        this.name = name;
        this.description = description;
        this.numOfRooms = numOfRooms;
        this.score = score;
        this.pictureId = pictureId;
        this.location = location;
        capacity = 0;

        hotelRooms = new HotelRoom[numOfRooms];

        for (int j = 0; j <  numOfRooms; j++)
        {
            int room_cap = Utils.randomWithRange(1,5);
            HotelRoom room = new HotelRoom(j,(char)(65 +j/2) + "-" + j%2, room_cap,
                    room_cap*10,2, R.drawable.bed_empty); // add pics
            hotelRooms[j] = room;
            this.capacity += room_cap;
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
    public SeatAndRoom[] getSeats() {
        return hotelRooms;
    }

    @Override
    public SeatAndRoom[] getSeats(int indexOfMid) {
        return hotelRooms;
    }

    @Override
    public double getScore() {
        return score;
    }

    public HotelRoom[] getHotelRooms() {
        return hotelRooms;
    }

    @Override
    public int getPicture() {
        return pictureId;
    }

    @Override
    public int getId() {
        return hotelId;
    }

    public Locations.Location getLocation() {
        return location;
    }

    public String getExcursions() {
        return excursions;
    }

    public void setExcursions(String excursions) {
        this.excursions = excursions;
    }


}
