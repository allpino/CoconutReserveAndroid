package coco.coconutreserve.assets.core;

import java.util.ArrayList;

import coco.coconutreserve.R;

public class Init {


    private Place[] data;
    private static Init instance = null;
    private User user;
    private ArrayList<Reservation> reservations;


    private Init(String type)
    {
        if (type.equals(Constants.HOTEL))
        {
            data = new Hotel[Constants.NUM_OF_HOTELS];
            for (int i = 0; i < Constants.NUM_OF_HOTELS; i++)
            {
                Hotel hotel = new Hotel(i,"Cool Hotel Name #"+i,
                                        "Cool Hotel Description#"+i,
                                        Utils.randomWithRange(10,30),
                                        Utils.randomWithRange(4.0,9.0), R.drawable.hotel);
                data[i] = hotel;

            }

        }
        else if(type.equals(Constants.CINEMA))
        {
            data = new Cinema[Constants.NUM_OF_CINEMAS];
            for (int i = 0; i < Constants.NUM_OF_CINEMAS; i++)
            {
                Cinema cinema = new Cinema(i,"Cool Cinema Name #"+i,
                        "Cool Cinema Description#"+i,
                        Utils.randomWithRange(1,3),
                        Utils.randomWithRange(2.0,9),R.drawable.cinema);
                data[i] = cinema;
            }
        }
        else if(type.equals(Constants.TRANSPORTION))
        {
            //Fill this later
        }


        if(data == null)
        {
            throw new NullPointerException("Something went wrong in Init");
        }

        if (type.equals(Constants.CINEMA))
        {
            user = new User("Nursolu Kedi",type,Constants.PREMIUM);
        }
        else
        {
            user = new User("Nursolu Kedi",type);
        }

        reservations = new ArrayList<>();

    }

    public static Init getInstance(String type){
        if (instance == null)
        {
            instance = new Init(type);
        }
        return  instance;
    }

    public Place[] getData() {
        return data;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}



