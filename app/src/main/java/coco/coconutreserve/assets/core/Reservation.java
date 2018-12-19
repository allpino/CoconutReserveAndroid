package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public interface Reservation {
    String toString();
    String getReservationInfo();
    Place getPlace();
    SeatAndRoom getSeatAndRoom();
    String getReserverName();
    LocalDateTime getReservation_date();
    int getPrice();
    boolean isPaid();
    void setAsPaid();

}
