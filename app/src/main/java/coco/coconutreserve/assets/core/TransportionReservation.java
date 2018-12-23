package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public class TransportionReservation implements Reservation {

    private int id;
    private Transportion transportion;
    private TransportionSeat transportionSeat;
    private LocalDateTime reservationDate;
    private String reserverName;
    private boolean isPaid;

    public TransportionReservation(int id, Transportion transportion, TransportionSeat transportionSeat,
                                   LocalDateTime reservationDate, String reserverName) {


        if (transportion == null || transportionSeat == null || reservationDate == null )
        {
            throw new NullPointerException("HotelReservation parameters are null!");
        }

        this.id = id;
        this.transportion = transportion;
        this.transportionSeat = transportionSeat;
        this.reservationDate = reservationDate;
        this.reserverName = reserverName;
        this.isPaid = false;
    }


    @Override
    public String getReservationInfo() {
        return "Transportion Reservation for person: " + reserverName +"\n for transportion: " + transportion + "\n for seat: "
                + transportionSeat + "\n for time: " + reservationDate + " \n for price: " + getPrice();
    }

    @Override
    public String getReserverName() {
        return reserverName;
    }

    @Override
    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    @Override
    public int getPrice() {
        return transportionSeat.getPrice();
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
    public Place getPlace() {
        return transportion;
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void setAsPaid() {
        this.isPaid = true;
        transportionSeat.setAsTaken();
    }

    @Override
    public SeatAndRoom getSeatAndRoom() {
        return transportionSeat;
    }


}
