package main;

/**
 *
 * @author Cherry Rose Semeña
 */
public interface IPiece {
    int getLocation();
    void setLocation(int newLocation);
    IPlayer getPlayer();
    void addPlayer(IPlayer player);
}
