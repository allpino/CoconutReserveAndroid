package coco.coconutreserve.assets.core;

import java.time.LocalDateTime;

public interface Reservation {
    int getId();
    String toString();
    String getReservationInfo();
    Place getPlace();
    void setReserverName(String name);
    SeatAndRoom getSeatAndRoom();
    String getReserverName();
    LocalDateTime getReservationDate();
    int getPrice();
    boolean isPaid();
    void setAsPaid();

}
