package tech.aircastle.outbreak;

public class Room
{
    public final boolean isInfected;

    public boolean visited = false;

    public Room(boolean infected) {
        isInfected = infected;
    }
}