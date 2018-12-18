package assets.core;
public class Init {

    private Place[] data;


    public Init(int type)
    {
        if (type == Constants.HOTEL)
        {
            data = new Hotel[Constants.NUM_OF_HOTELS];
            for (int i = 0; i < Constants.NUM_OF_HOTELS; i++)
            {
                Hotel hotel = new Hotel("Cool Hotel Name #"+i,
                                        "Cool Hotel Description#"+i,
                                        Utils.randomWithRange(10,30),
                                        Utils.randomWithRange(4.0,9.8));
                data[i] = hotel;

            }
        }
        else if(type == Constants.CINEMA)
        {
            data = new Cinema[Constants.NUM_OF_CINEMAS];
            for (int i = 0; i < Constants.NUM_OF_CINEMAS; i++)
            {
                Cinema cinema = new Cinema("Cool Cinema Name #"+i,
                        "Cool Cinema Description#"+i,
                        Utils.randomWithRange(4,9),
                        Utils.randomWithRange(2.0,9));
                data[i] = cinema;
            }
        }
        else if(type == Constants.TRANSPORTION)
        {
            //Fill this later
        }


        if(data == null)
        {
            throw new NullPointerException("Something went wrong in Init");
        }

    }

    public Place[] getData() {
        return data;
    }
}



