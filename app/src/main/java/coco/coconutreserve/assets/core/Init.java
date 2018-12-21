package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class Init {

    private Place[] data;
    private User[] users;


    public Init(String type)
    {
        if (type.equals(Constants.HOTEL))
        {
            data = new Hotel[Constants.NUM_OF_HOTELS];
            for (int i = 0; i < Constants.NUM_OF_HOTELS; i++)
            {
                Hotel hotel = new Hotel("Cool Hotel Name #"+i,
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
                Cinema cinema = new Cinema("Cool Cinema Name #"+i,
                        "Cool Cinema Description#"+i,
                        Utils.randomWithRange(4,9),
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

        users = new User[Constants.NUM_OF_USERS];
        for (int i = 0; i < Constants.NUM_OF_USERS ; i++)
        {
            if (i % 3 == 0)
            {
                users[i] = new User("Cool User name"+ i,Constants.CINEMA,i/2 == 0 ? Constants.PREMIUM: Constants.FREE);
            }
            else if ( i % 3 == 1)
            {
                users[i] = new User("Cool User Name"+i, Constants.HOTEL);
            }
            else if( i % 3 == 2)
            {
                users[i] = new User("Cool User Name"+i,Constants.TRANSPORTION);
            }
        }

    }

    public Place[] getData() {
        return data;
    }
    public User[] getUsers(){return users;}

}



