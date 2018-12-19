package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public class CinemaReservation implements Reservation {

    private Cinema cinema;
    private LocalDateTime reserve_date;
    private CinemaSaloon cinemaSaloon;
    private CinemaSeat cinemaSeat;
    private String reserver_name;
    private boolean isPaid;

    public CinemaReservation(Cinema cinema, CinemaSaloon cinemaSaloon, LocalDateTime reserve_date, String reserver_name) {
        this.cinema = cinema;
        this.reserve_date = reserve_date;
        this.cinemaSaloon = cinemaSaloon;
        this.cinemaSeat = cinemaSeat;
        this.reserver_name = reserver_name;
        this.isPaid = false;
    }

    @Override
    public String getReservationInfo() {
        return "Fill this I'm lazy";
    }

    @Override
    public String getReserverName() {
        return reserver_name;
    }

    @Override
    public LocalDateTime getReservation_date() {
        return reserve_date;
    }

    @Override
    public int getPrice() {
        return cinemaSeat.getPrice();
    }

    public Films.Film getFilm(){
        return cinemaSaloon.getFilm();
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
    }
}
