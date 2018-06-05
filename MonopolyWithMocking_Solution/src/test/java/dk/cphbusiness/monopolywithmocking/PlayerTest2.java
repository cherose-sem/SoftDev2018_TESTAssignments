
package dk.cphbusiness.monopolywithmocking;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class PlayerTest2 {
    
    
    @Mock
    Board b;
    
    @Mock
    Die d1, d2;
    
    @Mock
    Piece p;
    
    @Mock
    Square s1, s2; 
    
    @Mock
    Cup c;

      
     @Test
     public void testTakingTurn() {
         Die[] dice = {d1, d2};
         //Player player = new Player(dice, p, b);
          Player player = new Player(c, p, b);
         int fv1 = 4;
         int fv2 = 2;
         int total = fv1 + fv2;
         when(c.getTotal()).thenReturn(total);
       //  when(d1.getFaceValue()).thenReturn(fv1);
         //when(d2.getFaceValue()).thenReturn(fv2);
         when(p.getLocation()).thenReturn(s1);
         when(b.getSquare(s1, total)).thenReturn(s2); 
         player.takeTurn();
         //verify(d1).roll();
         //verify(d2).roll();
         verify(c).roll();
         verify(c).getTotal();
         //verify(d1).getFaceValue();
         //verify(d2).getFaceValue();
         verify(p).getLocation();
         verify(b).getSquare(s1, total);
         verify(p).setLocation(s2);
         // no assert needed, but this would fail (put in right locaiton further up in test):
         //when(b.getSquare(s1, total)).thenReturn(s1); 
     }
}
