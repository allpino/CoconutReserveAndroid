package coco.coconutreserve.assets.core;


import coco.coconutreserve.R;

public class Transportion implements Place {

    //IMPORTANT: If new variable is added, change Init as well
    private int id;
    private String name;
    private String description;
    private double score;
    private int numOfSeats;
    private int capacity;
    private String type;
    private TransportionSeat[] transportionSeats;
    private int pictureId;


    public Transportion(int id, String name, String description, double score, int numOfSeats, String type,
                        int pictureId) {

        if(name == null || description == null || score == 0 || score > 10.0 || numOfSeats == 0)
        {
            throw new NullPointerException("Transportion parameters are empty!");
        }
        else if( !type.equals(Constants.BUS ) || !type.equals(Constants.PLANE ) || !type.equals(Constants.TRAIN ) )
        {
            throw new NullPointerException("Type must be defined constant");
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.score = score;
        this.numOfSeats = numOfSeats;
        this.type = type;
        this.pictureId = pictureId;


        transportionSeats = new TransportionSeat[numOfSeats];

        for (int j = 0; j < numOfSeats ; j++)
        {
            TransportionSeat seat = new TransportionSeat(j,(char)(65 +j/4) + "-" + j%4,
                    Utils.randomWithRange(10,15),4, R.drawable.seat_empty);
            transportionSeats[j] = seat;
            capacity += seat.getCapacity();
        }


    }

    @Override
    public String getName() {
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

    @Override
    public double getScore() {
        return score;
    }


    @Override
    public String toString(){
        return "name: " + name + " Type: " + type;
    }

    @Override
    public SeatAndRoom[] getSeats() {
        return transportionSeats;
    }

    @Override
    public SeatAndRoom[] getSeats(int indexOfMid) {
        return transportionSeats;
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
