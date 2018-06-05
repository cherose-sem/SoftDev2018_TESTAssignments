package impl;

import first_semester_eksamen.Serving;
import first_semester_eksamen.ServingHandler;
import first_semester_eksamen.TimeFormatException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class ServingHandlerImpl implements ServingHandler {
    
     //max The maximum servings allowed - 165ml
     //min The minimum servings allowed - 155ml
    private final int min= 155;
    private final int max = 165;
    
    /**
     * @author Cherry Rose Semeña
     * @throws java.io.IOException
     */
    @Override
    public String readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        String contents = sb.toString();
        return contents;
    }

    /**
     * @author Cherry Rose Semeña
     */
    @Override
    public ArrayList<Serving> getServings(String data) throws TimeFormatException {
        ArrayList<Serving> servings = new ArrayList();
        String[] lines = data.split("\n");
        
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].length() > 0) {
                System.out.println("THE LINE IS " + lines[i]);
                String[] arr = lines[i].split(",");
                String date = arr[0];
                Time time = new Time(arr[1]);
//                System.out.println("Amt" + arr[2] + ".");
                boolean isNumber = Pattern.matches("[0-9]+", arr[2]);
                int amt;
                if (isNumber) {
                    amt = Integer.parseInt(arr[2]);
//                    System.out.println("HERE: " + number);
                }else{
                    amt = 0;
                }
//                int amp = Integer.parseInt(arr[2]);
                String waiter = arr[3];
                Serving serving = new ServingImpl(date, time, amt, waiter);
                servings.add(serving);
            }
        }
        
        return servings;
    }

    /**
     * @author Emmely Lundberg
     */
    @Override
    public Serving getHighestServing(ArrayList<Serving> servings) {
        Serving highest = null;
        int size = servings.size();
        int highestValue = -10;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                highestValue = servings.get(i).getAmount();
                highest = servings.get(i);
            }
            if (servings.get(i).getAmount() > highestValue) {
                highest = servings.get(i);
                highestValue = servings.get(i).getAmount();
            }
        }
        return highest;
    }

    /**
     * @author Emmely Lundberg
     */
    @Override
    public Serving getLessServing(ArrayList<Serving> servings){
        if(servings == null){
            return null;
        }
        Serving lowest = null;
        int size = servings.size();
        int lowestValue = -1;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                lowestValue = servings.get(i).getAmount();
                lowest = servings.get(i);
            }
            if (servings.get(i).getAmount() < lowestValue) {
                lowest = servings.get(i);
                lowestValue = servings.get(i).getAmount();
            }
        }

        return lowest;
    }

    /**
     * @author Cherry Rose Semeña
     */
    @Override
    public ArrayList<Serving> getValidServings(ArrayList<Serving> servings) {
        ArrayList<Serving> validServings = new ArrayList();
        for(int i = 0; i < servings.size(); i++){
            Serving s = servings.get(i);
            if(s.getAmount() >= min && s.getAmount() <= max){
                validServings.add(s);
            }
        }
        
        return validServings;
    }

    /**
     * @author Emmely Lundberg
     */
    @Override
    public boolean isTooMuch(Serving serving) {

        return serving.getAmount() > max;
    }

    /**
     * @author Cherry Rose Semeña
     * @return 
     */
    @Override
    public ArrayList<Serving> sortByAmount(ArrayList<Serving> servings) {
        Collections.sort(servings, new ServingImpl.ServingByAmount());
        return servings;
    }

    /**
     * @author Cherry Rose Semeña
     */
    @Override
    public ArrayList<Serving> getTooHighServings(ArrayList<Serving> servings) {
        ArrayList<Serving> tooHigh = new ArrayList();
        for(int i = 0; i < servings.size(); i++){
            if(isTooMuch(servings.get(i))){
                tooHigh.add(servings.get(i));
            }
        }
        return tooHigh;
    }

    /**
     * @author Cherry Rose Semeña
     */
    @Override
    public ArrayList<Serving> getLessServings(ArrayList<Serving> servings) {
        ArrayList<Serving> tooLess = new ArrayList();
        for(int i = 0; i < servings.size(); i++){
            if(servings.get(i).getAmount() < min){
                tooLess.add(servings.get(i));
            }
        }
        return tooLess;
    }

    /**
     * @author Emmely Lundberg
     */
    @Override
    public int getTotalExcessServings(ArrayList<Serving> servings) {
        int size = servings.size();
        int amount = 0;

        for (int i = 0; i < size; i++) {
            if (servings.get(i).getAmount() > max) {
                amount +=  servings.get(i).getAmount() - max;
            }
        }
        return amount;
    }

    /**
     * @author Emmely Lundberg
     */
    @Override
    public int getTotalMissingServings(ArrayList<Serving> servings) {
        int size = servings.size();
        int amount = 0;

        for (int i = 0; i < size; i++) {
            if (servings.get(i).getAmount() < min && servings.get(i).getAmount() > 0) {
                amount += min - servings.get(i).getAmount();
            }
        }
        return amount;
    }

//    public static void main(String[] args) throws IOException, TimeFormatException {
//        System.out.println("------------ STARTING -----------");
//        ServingHandler hndl = new ServingHandlerImpl();
//        String res = hndl.readFile("Servings.csv");
//        ArrayList<Serving> servings = hndl.getServings(res);
//        ArrayList<Serving> valids = hndl.getValidServings(servings);
//        ArrayList<Serving> sorted = hndl.sortByAmount(servings);
//        ArrayList<Serving> tooHigh = hndl.getTooHighServings(servings);
//        ArrayList<Serving> tooLess = hndl.getLessServings(servings);
//        
//        print(tooLess);
//    }
//    
//    private static void print(ArrayList<Serving> servings){
//        for (int i = 0; i < servings.size(); i++) {
//            String s = servings.get(i).toString();
//            System.out.println(s);
//        }
//    }
    
}
