package com.hotel.services;

import com.hotel.models.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<Room> rooms;

    public RoomService() {
        rooms = new ArrayList<>();
        // Initialize with some rooms
        rooms.add(new Room(1, "Single", 100.0, true));
        rooms.add(new Room(2, "Double", 150.0, true));
        rooms.add(new Room(3, "Suite", 250.0, true));
    }

    public List<Room> searchRooms(String category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory().equals(category) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void updateRoomAvailability(int roomId, boolean isAvailable) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                room.setAvailable(isAvailable);
                break;
            }
        }
    }
}
