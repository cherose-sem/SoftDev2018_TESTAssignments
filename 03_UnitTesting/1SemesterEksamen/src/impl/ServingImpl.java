/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import first_semester_eksamen.Serving;
import java.util.Comparator;

/**
 *
 * @author Cherry Rose Semeña, Emmely Lundberg
 */
public class ServingImpl implements Serving {
    private final String date;
    private final Time time;
    private final int amount;
    private final String waiter;

    public ServingImpl(String date, Time time, int amount, String waiter) {
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.waiter = waiter;
    }

    @Override public String getDate() { return this.date; }
    @Override public Time getTime() { return this.time; }
    @Override public int getAmount() { return this.amount; }
    @Override public String getWaiter() { return this.waiter; }

    @Override
    public String toString() {
        String res = "----------------------------------------------------------" 
                + "\n" + "date: " + this.date + ", time: " + this.time + ", amt: " 
                + this.amount + ", waiter: " + this.waiter;
//        System.out.println("THE RES IS " + res);
        return res;
    }
    
    public static class ServingByAmount implements Comparator<Serving> {

        @Override
        public int compare(Serving o1, Serving o2) {
            return o1.getAmount() > o2.getAmount() ? 1 : (o1.getAmount() < o2.getAmount() ? -1 : 0);
        }
    }

}
