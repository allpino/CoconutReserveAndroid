package coco.coconutreserve;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Hotel;
import coco.coconutreserve.assets.core.HotelRoom;
import coco.coconutreserve.assets.core.Init;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Init init = Init.getInstance(Constants.CINEMA);

        Hotel[] hotels = (Hotel[]) init.getData();

        for (int i = 0; i < Constants.NUM_OF_HOTELS; i++)
        {
            HotelRoom[][] hotelRooms = hotels[i].getHotelRooms();

            for (int j = 0; j < hotelRooms.length; j++)
            {
                for (int k = 0; k < hotelRooms[j].length; k++) {

                    System.out.println("Hotel Room " + hotelRooms[j][k].getName());
                    System.out.println("Hotel Room Capacity: " + hotelRooms[j][k].getCapacity());

                }
            }
        }
    }
}
