/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_semester_eksamen;

import impl.Time;

/**
 *
 * @author Cherry Rose Semeña, Emmely Lundberg
 */
public interface Serving {
    public String getDate();
    public Time getTime();
    public int getAmount();
    public String getWaiter();
}
