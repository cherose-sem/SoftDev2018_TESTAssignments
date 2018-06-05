package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import static org.junit.Assert.*;

/**
 *
 * @author Cherry Rose Semeña
 */
@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PlayerTest {

    @Inject
    IGame monopoly;

    @MockBean(name = "dice1")
    IDice dice1;

    @MockBean(name = "dice2")
    IDice dice2;

    IPiece piece;

    private IPlayer player;

    @Before
    public void setup() {
        this.piece = new PieceStub();
        player = mock(IPlayer.class);
        this.piece.addPlayer(this.player);
        this.monopoly.addPiece(this.piece);
        this.monopoly.init();
    }

    @After
    public void tearDown() {
        monopoly.endGame();
    }

    @Test
    public void takeTurnTest() throws Exception {
        int oldPosition = piece.getLocation();
        takeTurn();
        assertEquals(oldPosition + 10, piece.getLocation());
    }

    @Test
    public void takeTurnBoundaryTest() throws Exception {
        piece.setLocation(39);
        takeTurn();
        assertEquals(9, piece.getLocation());
    }

    @Test
    public void takeTurnBoundaryTest2() throws Exception {
        piece.setLocation(29);
        takeTurn();
        assertEquals(39, piece.getLocation());
    }

    @Test
    public void takeTurnBoundaryTest3() throws Exception {
        piece.setLocation(30);
        takeTurn();
        assertEquals(0, piece.getLocation());
    }

    @Test
    public void piecesTest() {
        IPiece piece = monopoly.getPiece(player);
        assertNotNull(piece);
        assertEquals(player, piece.getPlayer());
    }

    private void takeTurn() {
        when(dice1.roll()).thenReturn(5);
        when(dice2.roll()).thenReturn(5);
        monopoly.takeTurn(player);
    }
}
