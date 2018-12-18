package assets.core;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Films {
    public static class Film
    {
        private String filmName;
        private LocalDateTime filmTime;
        private LocalTime duration;

        public Film(String filmName, LocalDateTime filmTime, LocalTime duration) {

            if ( filmName == null || filmTime == null || duration == null)
            {
                throw new NullPointerException("Film parameters are null");
            }

            this.filmName = filmName;
            this.filmTime = filmTime;
            this.duration = duration;
        }


        public String getFilmName() {
            return filmName;
        }

        public LocalDateTime getFilmTime() {
            return filmTime;
        }

        public String toString(){
            return filmName; }

    }

    static Film[] films = {
            new Film("Cool film", LocalDateTime.now().minusHours(3),LocalTime.parse("01:30:00")),
            new Film("Cool film2", LocalDateTime.now(),LocalTime.parse("02:30:00")),
            new Film("Cool film3", LocalDateTime.now().plusHours(4),LocalTime.parse("01:20:00")),
            new Film("Cool film4", LocalDateTime.now().plusHours(2),LocalTime.parse("02:10:00")),
            new Film("Cool film5", LocalDateTime.now().minusHours(1),LocalTime.parse("02:00:00")),
    };


}
