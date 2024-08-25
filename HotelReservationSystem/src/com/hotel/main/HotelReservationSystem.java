package com.hotel.main;

import com.hotel.models.Room;
import com.hotel.models.Reservation;
import com.hotel.services.RoomService;
import com.hotel.services.ReservationService;
import com.hotel.utils.PaymentProcessor;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomService roomService = new RoomService();
        ReservationService reservationService = new ReservationService();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("1. Search Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter room category (Single/Double/Suite): ");
                    String category = scanner.nextLine();
                    List<Room> availableRooms = roomService.searchRooms(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No rooms available in this category.");
                    } else {
                        System.out.println("Available Rooms: ");
                        for (Room room : availableRooms) {
                            System.out.println("Room ID: " + room.getRoomId() + ", Price: $" + room.getPrice());
                        }
                    }
                    break;

                case 2:
                System.out.println("Enter Room ID: ");
                int roomId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter your name: ");
                String userName = scanner.nextLine();
                System.out.println("Enter start date (yyyy-mm-dd): ");
                Date startDate = java.sql.Date.valueOf(scanner.nextLine());
                System.out.println("Enter end date (yyyy-mm-dd): ");
                Date endDate = java.sql.Date.valueOf(scanner.nextLine());
            
                // Find the room by roomId
                Room room = null;
                for (Room r : roomService.searchRooms("")) {  // Empty string to search all rooms
                    if (r.getRoomId() == roomId) {
                        room = r;
                        break;
                    }
                }
            
                if (room != null && room.isAvailable()) {
                    Reservation reservation = reservationService.makeReservation(roomId, userName, startDate, endDate, room.getPrice());
                    roomService.updateRoomAvailability(roomId, false);
                    System.out.println("Reservation made successfully! Reservation ID: " + reservation.getReservationId());
                    System.out.println("Processing payment...");
                    paymentProcessor.processPayment(reservation.getTotalPrice(), "Credit Card");
                } else {
                    System.out.println("Room not available.");
                }
                break;
            
                case 3:
                    System.out.println("Enter your name to view reservations: ");
                    String name = scanner.nextLine();
                    List<Reservation> reservations = reservationService.getReservations(name);
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        for (Reservation res : reservations) {
                            System.out.println("Reservation ID: " + res.getReservationId() +
                                    ", Room ID: " + res.getRoomId() +
                                    ", Total Price: $" + res.getTotalPrice());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
