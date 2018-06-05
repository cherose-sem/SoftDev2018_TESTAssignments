/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjs.testfailproblem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Catalog {
    private List<Person> people = new ArrayList<>();
    
    public void addPerson (Person person){
        if(Calendar.getInstance().get(Calendar.YEAR)-person.getYearOfBirth()<18){
            throw new IllegalArgumentException("Only Adults Admitted.");
        }
        people.add(person);
    }
    
    public int getNrOfPeople(){
        return people.size();
    }
}
