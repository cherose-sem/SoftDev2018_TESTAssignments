package dk.cphbusiness.monopolywithmocking;

class Player {

    private Piece piece;
    private Board board;
    private Die[] dice;
    private Cup cup;

    Player(Die[] dice, Piece p, Board b) {
        this.dice = dice;
        this.piece = p;
        this.board = b;
    }
    
      Player(Cup c, Piece p, Board b) {
        this.cup = c;
        this.piece = p;
        this.board = b;
    }

    public void takeTurn() {

  //      int rollTotal = rollDice();
        int rollTotal = 0;
        cup.roll();
        rollTotal = cup.getTotal();
//
//        for (int i = 0; i < dice.length; i++) {
//            dice[i].roll();
//            rollTotal += dice[i].getFaceValue();
//        }

        Square newLocation = board.getSquare(piece.getLocation(), rollTotal);
        piece.setLocation(newLocation);
    }

    private int rollDice() {
        int rollTotal = 0;

        for (int i = 0; i < dice.length; i++) {
            dice[i].roll();
            rollTotal += dice[i].getFaceValue();
        }
        return rollTotal;
    }

}
