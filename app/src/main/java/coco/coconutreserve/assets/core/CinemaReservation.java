package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public class CinemaReservation implements Reservation {

    private int id;
    private Cinema cinema;
    private LocalDateTime reserveDate;
    private CinemaSaloon cinemaSaloon;
    private CinemaSeat cinemaSeat;
    private String reserverName;
    private boolean isPaid;

    public CinemaReservation(int id, Cinema cinema, CinemaSaloon saloon, CinemaSeat cinemaSeat, LocalDateTime reserveDate, String reserverName) {
        this.id = id;
        this.cinema = cinema;
        this.reserveDate = reserveDate;
        this.cinemaSaloon = saloon;
        this.cinemaSeat = cinemaSeat;
        this.reserverName = reserverName;
        this.isPaid = false;
    }

    @Override
    public String getReservationInfo() {
        String ret = "Film: " + getFilm().getFilmName() + "\n"+
                "Cinema: " + cinema.getName() + "\n"+
                "Saloon: " + cinemaSaloon.getName() + "\n";
        if (reserverName != null)
        {
            ret += "Reserver Name: " + reserverName;
        }
        return ret;
    }

    @Override
    public String getReserverName() {
        return reserverName;
    }

    @Override
    public LocalDateTime getReservationDate() {
        return reserveDate;
    }

    @Override
    public int getPrice() {
        return cinemaSeat.getPrice();
    }

    public Films.Film getFilm() {
        return cinemaSaloon.getFilm();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setReserverName(String name) {
        this.reserverName = name;
    }

    @Override
    public String toString() {
        String ret = "Film: " + getFilm().getFilmName() + "\n"+
                "Cinema: " + cinema.getName() + "\n"+
                "Saloon: " + cinemaSaloon.getName() + "\n";
        if (reserverName != null)
        {
            ret += "Reserver Name: " + reserverName;
        }
        return ret;
    }

    @Override
    public Place getPlace() {
        return cinema;
    }

    @Override
    public SeatAndRoom getSeatAndRoom() {
        return cinemaSeat;
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void setAsPaid() {
        this.isPaid = true;
        cinemaSeat.setAsTaken();
    }


}


