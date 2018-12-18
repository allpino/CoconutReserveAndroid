package assets.core;

import java.time.LocalDateTime;

public interface Reservation {
    String toString();
    String getReservationInfo();
    String getReserverName();
    LocalDateTime getReservation_date();
    int getPrice();
}
