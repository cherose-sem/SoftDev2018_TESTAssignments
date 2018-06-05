package main;

/**
 *
 * @author Cherry Rose Semeña
 */
public interface IGameController {
    void move(IPlayer player) throws Exception;
    IGameController connect(IPlayer player, IPiece piece);
    void startGame();
}
