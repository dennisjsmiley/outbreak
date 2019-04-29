package tech.aircastle.outbreak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

public class Outbreak {

    private static final Logger logger = LoggerFactory.getLogger(Outbreak.class);

    private static final int OUTBREAK_THRESHOLD = 5;

    public static boolean isOutbreak(Room[][] floor) {
        int height = floor.length;
        if (height == 0) {
            return false;
        }

        int width = floor[0].length;
        if (width == 0) {
            return false;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (floor[y][x].isInfected && !floor[y][x].visited) {
                    if (getInfectionSize(x, y, floor) >= OUTBREAK_THRESHOLD) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int getInfectionSize(int x, int y, Room[][] floor) {
        int height = floor.length;
        if (height == 0) {
            return 0;
        }

        int width = floor[0].length;

        if (x < 0 || y < 0 || x >= width || y >= height) {
            throw new IllegalArgumentException("x or y is outside of floor dimensions");
        }

        int infectionSize = 0;

        Deque<Tuple2> roomsToVisit = new LinkedList<>();

        if (floor[y][x].isInfected && !floor[y][x].visited) {
            roomsToVisit.add(new Tuple2(x, y));
        }

        while (roomsToVisit.size() > 0) {
            Tuple2 room = roomsToVisit.removeFirst();
            infectionSize ++;

            if (room.x - 1 >= 0) {
                if (floor[room.y][room.x - 1].isInfected && !floor[room.y][room.x - 1].visited) {
                    roomsToVisit.add(new Tuple2(room.x - 1, room.y));
                }
            }
            if (room.x + 1 < width) {
                if (floor[room.y][room.x + 1].isInfected && !floor[room.y][room.x + 1].visited) {
                    roomsToVisit.add(new Tuple2(room.x + 1, room.y));
                }
            }

            if (room.y - 1 >= 0) {
                if (floor[room.y - 1][room.x].isInfected && !floor[room.y - 1][room.x].visited) {
                    roomsToVisit.add(new Tuple2(room.x, room.y - 1));
                }
            }
            if (room.y + 1 < height) {
                if (floor[room.y + 1][room.x].isInfected && !floor[room.y + 1][room.x].visited) {
                    roomsToVisit.add(new Tuple2(room.x, room.y + 1));
                }
            }

            floor[room.y][room.x].visited = true;
        }

        return infectionSize;
    }

}
