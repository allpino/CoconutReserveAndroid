package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class Locations {
    public static class Location
    {
        private int locationId;
        private String locationName;
        private int pictureId;
        private String blog;

        public Location(int id, String locationName, int pictureId, String blog)
        {
            this.locationId = id;
            this.locationName = locationName;
            this.pictureId = pictureId;
            this.blog = blog;
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

        public String getBlog() {
            return blog;
        }
    }

    public static Locations.Location[] locations = {
           new Location(0,"Ankara",R.drawable.ankara,
                   "Ankara is the capital city of Turkey and the second largest city in the country after Istanbul. It is located at the heart of both Turkey and Central Anatolia. The population is around 4.5 million.\n" +
                           "\n" +
                           "Ankara is the administrative center of Turkey and a huge university town, so it has a large population of government workers and university students. As the national capital, Ankara is home to a large population of foreign diplomats and embassy staff, so it offers goods and services that might be more difficult to find in other Turkish cities.\n" +
                           "\n" +
                           "Ankara is a sprawling, modern city which can appear as little more than a dull, concrete jungle at first glance. As a result, many tourists tend to use it merely as a transit point for getting to places like Konya or Cappodocia. However Ankara does have a lot to offer for those prepared to look a bit deeper.\n" +
                           "\n" +
                           "Ankara has a symbolic significance for the secular Turks. It is the place where a new era for the Turkish people started. It is a symbol for independence, development and Western values."),
           new Location(1,"İstanbul",R.drawable.istanbul,
                   "Istanbul (Turkish: İstanbul) is Turkey's most populous city as well as its cultural and financial hub. Located on both sides of the Bosphorus, the narrow strait between the Black Sea and the Marmara Sea, Istanbul bridges Asia and Europe both physically and culturally. Istanbul's population is estimated to be between 12 and 19 million people, making it also one of the largest cities in Europe and the world"),
           new Location(2,"İzmir",R.drawable.izmir,
                   "Izmir is the third largest city in Turkey with a population of around 4 million, the second biggest port after Istanbul, and a very good transport hub. The fact that almost half of its population of 4 million are under the age of 30, makes İzmir a city full of life. The city hosts tens of thousands of university students, educates scientists, artists, business leaders and academics. It is a rapidly growing city on the Central Aegean coast of Turkey."),
           new Location(3,"Antalya",R.drawable.antalya,
                   "Having entered the scene in 150 BC as Attalia, named after its founder, Attalos II, king of Pergamon, Antalya has ever attracted a wide array of travellers, including Paul the Apostle, and Ibn Battuta among others. Antalya had replaced Phaselis—beautiful ruins of which now lie to south of the city, between Kemer and Olympos—as the main harbour of the surrounding region during the reign of Seljuks, in early 1200s, but the lack of a large hinterland (or, rather, lack of good connections with its mountainous hinterland) meant for much of its history eversince that it was a provincial coastal town, albeit with a multicultural community of Muslims, Christians, and Jews. As the centre of a region with beautiful beaches, verdant mountains, and a mindblowing number of ancient ruins, the tourism investments started in 1970s, which changed the fate of the city considerably. However, as most of the visitors (make no mistake—they are in the range of millions annually) to the region are actually on \"all-inclusive\" vacation packages nowadays, they are immediately taken from the airport to the huge resorts lining the coastline of hundreds of kilometres, where they stay until the end of their holidays except perhaps a raid or two to the nearest and the most popular attractions, so Antalya itself, especially the old town (Kaleiçi), is more of an independent traveller destination, where you will meet the other travellers of a similar mind, and the locals."),
           new Location(4,"Adana",R.drawable.adana,
                   "Adana is a very old city, founded way back in 6000 B.C. During the time it was part of a region called Cilicia and was, by turn, homeland to the Pheonicians, Chaldeans, Assyrians, Hittites, Persians, Macedonians, Romans, Byzantines, Abbasies, Seljuks, and finally the ottomans. Now in the centre of huge Cilician Plains and on the banks of Seyhan River, Adana is the fifth largest city in Turkey with a population of over 1.3 million. It's not much known as a tourism destination, though, especially when compared with its southern and western neighbours. However, that being said there are a number of sites of interest in the surrounding countryside.\n" +
                           "\n" +
                           "Modern Adana consists of two quite separate sections: cramped old city centre and newer, mostly high-rise suburbs overlooking the Seyhan dam to north of the old centre, usually called Kuzey Adana or Yeni Adana (i.e. \"North Adana\" or \"New Adana\", respectively)."),

    };


}
