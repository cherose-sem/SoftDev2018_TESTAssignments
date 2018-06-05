package main;

import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cherry Rose Semeña
 */
@Controller
public class GameControllerImpl implements IGameController {
    List<IPlayer> players = new ArrayList<>();

    IPlayer currentTurn;

    @Inject
    IGame game;

    @Override
    public void move(IPlayer player) throws Exception {
        if (!currentTurn.equals(player)) {
            throw new Exception();
        }
        game.takeTurn(player);
    }

    @Override
    public IGameController connect(IPlayer player, IPiece piece) {
        piece.addPlayer(player);
        game.addPiece(piece);
        players.add(player);
        return this;
    }

    @Override
    public void startGame() {
        currentTurn = players.get(0);
        game.init();
    }
}
