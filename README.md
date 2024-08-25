# CodeAlpha_HotelReservationSystem
# Hotel Reservation System

## Overview

The Hotel Reservation System is a Java-based application designed to streamline the process of booking and managing hotel reservations. This system allows users to search for available rooms, make reservations, and view their reservation details. It features a modular architecture with distinct components for room management, reservation handling, and payment processing.

## Features

- **Search Rooms**: Users can search for available rooms based on the category (Single, Double, Suite). The system displays available rooms along with their prices.
- **Make Reservation**: Users can reserve a room by providing the room ID, their name, start date, and end date. The system processes the reservation and handles the payment using a simulated payment processor.
- **View Reservations**: Users can view their reservations by entering their name. The system retrieves and displays all reservations made under that name.
- **Payment Processing**: The system simulates payment processing for reservations using a credit card.

## Components

- **Room**: Represents a hotel room with properties such as room ID, category, price, and availability status.
- **Reservation**: Represents a reservation with details like reservation ID, room ID, user name, start and end dates, and total price.
- **RoomService**: Handles room-related operations such as searching for rooms and updating room availability.
- **ReservationService**: Manages reservation operations including making new reservations and retrieving existing reservations.
- **PaymentProcessor**: Simulates payment processing for reservations.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/hotel-reservation-system.git
