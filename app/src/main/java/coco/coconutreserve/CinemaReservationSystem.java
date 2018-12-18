package coco.coconutreserve;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Init;

public class CinemaReservationSystem {

    public static void main(String[] args) {

        Init init = new Init(Constants.CINEMA);

        Cinema[] cinemas = (Cinema[]) init.getData();

        for (int i = 0; i <  Constants.NUM_OF_CINEMAS; i++)
        {
            System.out.println("Cinema Name: " + cinemas[i].getName());
            for (int j = 0; j < cinemas[i].getNumOfSaloons(); j++)
            {
                System.out.println("Cinema Saloon: " + cinemas[i].getCinemaSaloons()[j].getName());
                System.out.println("Cinema Saloon Capacity: " + cinemas[i].getCinemaSaloons()[j].getCapacity());
            }

        }



    }
}
