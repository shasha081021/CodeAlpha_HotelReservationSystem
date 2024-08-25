package com.hotel.services;

import com.hotel.models.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        reservations = new ArrayList<>();
    }

    public Reservation makeReservation(int roomId, String userName, Date startDate, Date endDate, double pricePerNight) {
        double totalPrice = pricePerNight * (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
        Reservation reservation = new Reservation(reservations.size() + 1, roomId, userName, startDate, endDate, totalPrice);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservations(String userName) {
        List<Reservation> userReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getUserName().equals(userName)) {
                userReservations.add(reservation);
            }
        }
        return userReservations;
    }
}
