package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public class TransportionReservation implements Reservation {

    private Transportion transportion;
    private TransportionSeat transportionSeat;
    private LocalDateTime reservation_date;
    private String reserver_name;

    public TransportionReservation(Transportion transportion, TransportionSeat transportionSeat,
                                   LocalDateTime reservation_date, String reserver_name) {


        if (transportion == null || transportionSeat == null || reservation_date == null || reserver_name == null)
        {
            throw new NullPointerException("HotelReservation parameters are null!");
        }

        this.transportion = transportion;
        this.transportionSeat = transportionSeat;
        this.reservation_date = reservation_date;
        this.reserver_name = reserver_name;
    }


    @Override
    public String getReservationInfo() {
        return "Transportion Reservation for person: " + reserver_name +"\n for transportion: " + transportion + "\n for seat: "
                + transportionSeat + "\n for time: " + reservation_date + " \n for price: " + getPrice();
    }

    @Override
    public String getReserverName() {
        return reserver_name;
    }

    @Override
    public LocalDateTime getReservation_date() {
        return reservation_date;
    }

    @Override
    public int getPrice() {
        return getPrice();
    }
}
