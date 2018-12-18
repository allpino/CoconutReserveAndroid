package assets.core;

import java.time.LocalDateTime;

public class HotelReservation implements Reservation {

    Hotel hotel;
    HotelRoom hotelRoom;
    LocalDateTime reservation_date;
    String reserver_name;

    public HotelReservation(Hotel hotel, HotelRoom hotelRoom, LocalDateTime reservation_date, String reserver_name){

        if (hotel == null || hotelRoom == null || reservation_date == null || reserver_name == null)
        {
            throw new NullPointerException("HotelReservation parameters are null!");
        }

        this.hotel = hotel;
        this.hotelRoom = hotelRoom;
        this.reservation_date = reservation_date;
        this.reserver_name = reserver_name;
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
}
