package coco.coconutreserve.assets.core;

import android.location.Location;

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
                                        Utils.randomWithRange(4.0,9.0), R.drawable.hotel,Locations.locations[Utils.randomWithRange(0,4)]);
                hotel.setExcursions("Private Tour: "+ hotel.getLocation().getLocationName() +"Sightseeing\n"+
                "Big Bus"+hotel.getLocation().getLocationName() +" Hop-On Hop-Off Tour");

                int isDiscount = Utils.randomWithRange(0,1);
                if (isDiscount == 1)
                {
                    hotel.setDiscount(Utils.randomWithRange(5,10));
                }

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

                int isDiscount = Utils.randomWithRange(0,1);
                if (isDiscount == 1)
                {
                    cinema.setDiscount(Utils.randomWithRange(5,10));
                }


                data[i] = cinema;
            }
        }
        else if(type.equals(Constants.TRANSPORTION))
        {

            data = new Transportion[Constants.NUM_OF_TRANSPORTIONS];
            for (int i = 0; i < Constants.NUM_OF_TRANSPORTIONS; i++)
            {
                ArrayList<Locations.Location> locations = new ArrayList<>();
                for (int j = 0; j < Locations.locations.length; j++)
                {
                    locations.add(Locations.locations[j]);
                }

                int random1 = Utils.randomWithRange(0,locations.size()-1);
                int random2 = Utils.randomWithRange(0,locations.size()-2);
                int type1 = Utils.randomWithRange(0,2);
                String trans_type;
                int pic;
                if (type1 == 0)
                {
                    trans_type = Constants.BUS;
                    pic = R.drawable.bus;
                }
                else if( type1 == 1)
                {
                    trans_type = Constants.PLANE;
                    pic = R.drawable.plane;
                }
                else
                {
                    trans_type = Constants.TRAIN;
                    pic = R.drawable.train;
                }
                Transportion transportion = new Transportion(i,"Cool Transportion Name #"+i,
                        "Cool Transportion Description#"+i,Utils.randomWithRange(2.0,9),
                        Utils.randomWithRange(5,10)*4,trans_type,pic,locations.remove(random1),locations.remove(random2));


                int isDiscount = Utils.randomWithRange(0,1);
                if (isDiscount == 1)
                {
                    transportion.setDiscount(Utils.randomWithRange(5,10));
                }

                data[i] = transportion;
            }
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



