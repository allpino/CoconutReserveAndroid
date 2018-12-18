package assets.core;

import assets.core.Reservation;

public class Transportion implements Place {

    //IMPORTANT: If new variable is added, change Init as well
    private String name;
    private String description;
    private double score;
    private int numOfSeats;
    private int capacity;
    private int type;
    private TransportionSeat[][] transportionSeats;


    public Transportion(String name, String description, double score, int numOfSeats, int type) {

        if(name == null || description == null || score == 0 || score > 10.0 || numOfSeats == 0)
        {
            throw new NullPointerException("Transportion parameters are empty!");
        }
        else if( type != Constants.BUS || type != Constants.PLANE || type != Constants.TRAIN)
        {
            throw new NullPointerException("Type must be defined constant");
        }

        this.name = name;
        this.description = description;
        this.score = score;
        this.numOfSeats = numOfSeats;
        this.type = type;


        transportionSeats = new TransportionSeat[4][numOfSeats/4];
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < numOfSeats/4 ; j++)
            {
                TransportionSeat seat = new TransportionSeat((char)(65 +i) + "-" + j,
                        Utils.randomWithRange(10,15),4,numOfSeats/4);
                transportionSeats[i][j] = seat;
                capacity += seat.getCapacity();

            }
        }


    }
}
