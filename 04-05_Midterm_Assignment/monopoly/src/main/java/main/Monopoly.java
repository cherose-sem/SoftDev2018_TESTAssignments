package main;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cherry Rose Semeña
 */
@Component
public class Monopoly implements IGame {

    List<IPiece> pieces = new ArrayList<>();
    List<Field> fields;

    @Inject
    IDice dice1;

    @Inject
    IDice dice2;

    @Override
    public void init() {
        this.fields = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            fields.add(new Field("Field"+i));
        }

        pieces.forEach(piece -> {
            piece.setLocation(0);
        });
    }

    @Override
    public void takeTurn(IPlayer player) {
        int roll = roll(); //a. Calculating a random number total between 2 and 12(the range of 22 dice)
        IPiece piece = getPiece(player);
        //b. calculating the new square location
        //c. moving the player's place from the old location to the new square location
        int oldLocation = piece.getLocation();
        getPiece(player).setLocation(calculatePosition(oldLocation, roll));
    }

    @Override
    public void addPiece(IPiece piece) {
        pieces.add(piece);
    }

    @Override
    public IPiece getPiece(IPlayer player) {
        for (IPiece piece : pieces) {
            if (piece.getPlayer().equals(player)) {
                return piece;
            }
        }
        return null;
    }

    @Override
    public void endGame() {
        this.fields = new ArrayList<>();
        this.pieces = new ArrayList<>();
    }

    private int roll() {
        return dice1.roll() + dice2.roll();
    }

    private int calculatePosition(int oldPosition, int roll) {
        int total = oldPosition + roll;
        if (total >= fields.size()) {
            return total - fields.size();
        } else {
            return total;
        }
    }

}
