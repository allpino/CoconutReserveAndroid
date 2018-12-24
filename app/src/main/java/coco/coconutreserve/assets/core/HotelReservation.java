package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public class HotelReservation implements Reservation {

    private Hotel hotel;
    private int id;
    private HotelRoom hotelRoom;
    private LocalDateTime reservationDate;
    private String reserverName;
    private boolean isPaid;

    public HotelReservation(int id, Hotel hotel, HotelRoom hotelRoom, LocalDateTime reservationDate, String reserverName){

        if (hotel == null || hotelRoom == null || reservationDate == null )
        {
            throw new NullPointerException("HotelReservation parameters are null!");
        }
        this.id = id;
        this.hotel = hotel;
        this.hotelRoom = hotelRoom;
        this.reservationDate = reservationDate;
        this.reserverName = reserverName;
        this.isPaid = false;
    }


    @Override
    public String getReservationInfo() {
        String ret = "Location: " + hotel.getLocation().getLocationName()+ "\n"+
                "Hotel: " + hotel.getName() + "\n";
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
    public int getId() {
        return id;
    }

    @Override
    public LocalDateTime getReservationDate() {
        return reservationDate;
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
        hotelRoom.setAsTaken();
    }

    @Override
    public void setReserverName(String name) {
        this.reserverName = name;
    }

    @Override
    public SeatAndRoom getSeatAndRoom() {
        return hotelRoom;
    }


}
