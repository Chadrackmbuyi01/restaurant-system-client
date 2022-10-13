package za.ac.cput.factory;

import za.ac.cput.domain.Reservation;

public class ReservationFactory {
    //creating objects
    public static Reservation createReservation(int reserveId, String reserveName){

        return new Reservation.Builder().setReserveId(reserveId)
                .setReserveName(reserveName)
                .build();

    }
}
