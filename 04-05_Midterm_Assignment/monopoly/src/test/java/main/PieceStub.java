package main;

/**
 *
 * @author Cherry Rose Semeña
 */

public class PieceStub implements IPiece {
    private IPlayer player;
    private int location;

    @Override
    public int getLocation() {
        return location;
    }

    @Override
    public void setLocation(int newLocation) {
        this.location = newLocation;
    }

    @Override
    public IPlayer getPlayer() {
        return this.player;
    }

    @Override
    public void addPlayer(IPlayer player) {
        this.player = player;
    }
}
