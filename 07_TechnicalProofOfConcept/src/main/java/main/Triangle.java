
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author ansty
 */
public class Triangle {

    private int side_a;
    private int side_b;
    private int side_c;
    private TriangleType triangleType;

    public Triangle(int a, int b, int c) {
        try{
        this.side_a = a;
        this.side_b = b;
        this.side_c = c;
        }catch(Exception e){
            this.triangleType = TriangleType.UNKNOWN;
        }
    }

    public Triangle(int arg1, int arg2) {
        this.side_a = arg1;
        this.side_b = arg2;
    }

    Triangle() {}

    public TriangleType getType() throws Exception{
        try {
            if (!isValid(side_a, side_b, side_c)) {
                this.triangleType = TriangleType.UNKNOWN;
            } else if (side_a == side_b && side_b == side_c) {
                this.triangleType = TriangleType.EQUILATERAL_TRIANGLE;
            } else if (side_a == side_b || side_a == side_c || side_b == side_c) {
                this.triangleType = TriangleType.ISOSCELES_TRIANGLE;
            } else if (side_a != side_b && side_a != side_c && side_b != side_c) {
                this.triangleType = TriangleType.SCALENE_TRIANGLE;
            } else {
                this.triangleType = TriangleType.UNKNOWN;
            }

        } catch (Exception e) {
            this.triangleType = TriangleType.UNKNOWN;
        }

        return this.triangleType;

    }

    public boolean isValid(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

    public void setType(TriangleType triangleType) {
        this.triangleType = triangleType;
    }

}
