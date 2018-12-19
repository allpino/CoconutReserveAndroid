package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public class HotelReservation implements Reservation {

    private Hotel hotel;
    private HotelRoom hotelRoom;
    private LocalDateTime reservation_date;
    private String reserver_name;
    private boolean isPaid;

    public HotelReservation(Hotel hotel, HotelRoom hotelRoom, LocalDateTime reservation_date, String reserver_name){

        if (hotel == null || hotelRoom == null || reservation_date == null || reserver_name == null)
        {
            throw new NullPointerException("HotelReservation parameters are null!");
        }

        this.hotel = hotel;
        this.hotelRoom = hotelRoom;
        this.reservation_date = reservation_date;
        this.reserver_name = reserver_name;
        this.isPaid = false;
    }


    @Override
    public String getReservationInfo() {
        return "Hotel Reservation for person: " + reserver_name +"\n for hotel: " + hotel + "\n for room: "
                + hotelRoom + "\n for time: " + reservation_date + " \n for price: " + getPrice();
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
        return hotelRoom.getPrice();
    }

    @Override
    public Place getPlace() {
        return hotel;
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void setAsPaid() {
        this.isPaid = true;
    }

    @Override
    public SeatAndRoom getSeatAndRoom() {
        return hotelRoom;
    }
}
