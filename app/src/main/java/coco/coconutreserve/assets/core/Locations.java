package coco.coconutreserve.assets.core;

import java.time.LocalTime;

import coco.coconutreserve.R;

public class Locations {
    public static class Location
    {
        private int locationId;
        private String locationName;
        private int pictureId;

        public Location(int id, String locationName, int pictureId) {

            if ( locationName == null )
            {
                throw new NullPointerException("Film parameters are null");
            }

            this.locationId = id;
            this.locationName = locationName;
            this.pictureId = pictureId;
        }


        public String getLocationName() {
            return locationName;
        }

        public int getPicture() {
            return pictureId;
        }



        public String toString(){
            return locationName; }


        public int getId() {
            return locationId;
        }
    }

    public static Locations.Location[] locations = {
           new Location(0,"Ankara",R.drawable.ankara),
           new Location(1,"İstanbul",R.drawable.istanbul),
           new Location(2,"İzmir",R.drawable.izmir),
           new Location(3,"Antalya",R.drawable.antalya),
           new Location(4,"Adana",R.drawable.adana),


    };


}
