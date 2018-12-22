package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;
import java.time.LocalTime;

import coco.coconutreserve.R;

public class Films {
    public static class Film
    {
        private int filmId;
        private String filmName;
        private LocalTime duration;
        private int pictureId;

        public Film(int id, String filmName, LocalTime duration, int pictureId) {

            if ( filmName == null  || duration == null)
            {
                throw new NullPointerException("Film parameters are null");
            }

            this.filmId = id;
            this.filmName = filmName;
            this.duration = duration;
            this.pictureId = pictureId;
        }


        public String getFilmName() {
            return filmName;
        }

        public int getPicture() {
            return pictureId;
        }


        public LocalTime getDuration() {
            return duration;
        }

        public String toString(){
            return filmName; }


        public int getId() {
            return filmId;
        }
    }

    public static Film[] films = {
            new Film(1,"Cool film",LocalTime.parse("01:30:00"), R.drawable.film_pic),
            new Film(2,"Cool film2",LocalTime.parse("02:30:00"), R.drawable.film_pic),
            new Film(3,"Cool film3",LocalTime.parse("01:20:00"), R.drawable.film_pic),
            new Film(4,"Cool film4",LocalTime.parse("02:10:00"), R.drawable.film_pic),
            new Film(5,"Cool film5",LocalTime.parse("02:00:00"), R.drawable.film_pic),
    };


}
