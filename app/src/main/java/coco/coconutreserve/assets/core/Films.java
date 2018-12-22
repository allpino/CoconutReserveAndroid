package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;
import java.time.LocalTime;

import coco.coconutreserve.R;

public class Films {
    public static class Film
    {
        private int filmId;
        private String filmName;
        private LocalDateTime filmTime;
        private LocalTime duration;
        private int pictureId;

        public Film(int id, String filmName, LocalDateTime filmTime, LocalTime duration, int pictureId) {

            if ( filmName == null || filmTime == null || duration == null)
            {
                throw new NullPointerException("Film parameters are null");
            }

            this.filmId = id;
            this.filmName = filmName;
            this.filmTime = filmTime;
            this.duration = duration;
            this.pictureId = pictureId;
        }


        public String getFilmName() {
            return filmName;
        }

        public int getPicture() {
            return pictureId;
        }

        public LocalDateTime getFilmTime() {
            return filmTime;
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
            new Film(1,"Cool film", LocalDateTime.now().minusHours(3),LocalTime.parse("01:30:00"), R.drawable.film_pic),
            new Film(2,"Cool film2", LocalDateTime.now(),LocalTime.parse("02:30:00"), R.drawable.film_pic),
            new Film(3,"Cool film3", LocalDateTime.now().plusHours(4),LocalTime.parse("01:20:00"), R.drawable.film_pic),
            new Film(4,"Cool film4", LocalDateTime.now().plusHours(2),LocalTime.parse("02:10:00"), R.drawable.film_pic),
            new Film(5,"Cool film5", LocalDateTime.now().minusHours(1),LocalTime.parse("02:00:00"), R.drawable.film_pic),
    };


}
