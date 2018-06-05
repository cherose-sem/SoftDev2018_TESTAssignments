package impl;

import first_semester_eksamen.Handler;
import first_semester_eksamen.Sample;
import first_semester_eksamen.SlowSample;
import first_semester_eksamen.TimeFormatException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class HandlerImpl implements Handler {

    public static final String FILENAME = "Samples.csv";

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
     * Converts file content to proper objects
     *
     * @param data The file content as a String
     * @return a list of Sample objects
     * @throws TimeFormatException if time is formated badly
     */
    @Override
    public ArrayList<Sample> getSamples(String data) throws TimeFormatException {

        ArrayList<Sample> samples = new ArrayList();
        String[] lines = data.split("\n");

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].length() > 0) {
//                System.out.println("THE LINE IS " + lines[i]);
                String[] arr = lines[i].split(",");
                String date = arr[0];
                String[] tm = arr[1].split(":");
                int hr = Integer.parseInt(tm[0]);
                int min = Integer.parseInt(tm[1]);
                Time time = new Time(hr, min);
//                System.out.println("AMP" + arr[2] + ".");
                boolean isNumber = Pattern.matches("[0-9]+", arr[2]);
                int amp;
                if (isNumber) {
                    amp = Integer.parseInt(arr[2]);
//                    System.out.println("HERE: " + number);
                }else{
                    amp = 0;
                }
//                int amp = Integer.parseInt(arr[2]);
                Sample sample = new SampleImpl(date, time, amp);
                samples.add(sample);
            }
        }
        return samples;

    }

    @Override
    public Sample getHighestAmplitude(ArrayList<Sample> samples) {
        Sample highestAmp = null;

        return highestAmp;
    }
    /**
     * Identifies the sample which have increased the most in amplitude
     * compared to its predecessor.
     * The compared values are signed - It is NOT the numerical difference
     * that counts.
     * @param samples The list of Samples based on file content - At least
     * 2 values are required
     * @return the identified Sample object
     */
    @Override
    public Sample getBiggestRise(ArrayList<Sample> samples) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int higestDiff=0;
        int indexCurrent=1;
        for (int i = 1; i <samples.size() ; i++) {
            Sample predecessor = samples.get(i-1);
            Sample current = samples.get(i);

            if(higestDiff < (current.getAmplitude() - predecessor.getAmplitude()) ){
                higestDiff = current.getAmplitude() - predecessor.getAmplitude();
                indexCurrent = i;
            }
        }
        return samples.get(indexCurrent);
    }

    @Override
    public boolean isTooLoud(int limit, ArrayList<Sample> samples) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sortByTime(ArrayList<Sample> samples) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sortByAmplitude(ArrayList<Sample> samples) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Sample> getLoudSamples(int limit, ArrayList<Sample> samples) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Sample> getSamplesBefore(Time limit, ArrayList<Sample> samples) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws IOException, TimeFormatException {
        System.out.println("------------ STARTING -----------");
        Handler hndl = new HandlerImpl();
        String res = hndl.readFile("Samples.csv");
//        System.out.println(res);
        ArrayList<Sample> samples = hndl.getSamples(res);
        for (int i = 0; i < samples.size(); i++) {
            System.out.println("SAMPLE " + i + samples.get(i).toString());
        }
    }

}
