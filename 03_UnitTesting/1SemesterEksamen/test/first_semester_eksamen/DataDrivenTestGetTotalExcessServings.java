package first_semester_eksamen;

import impl.ServingHandlerImpl;
import impl.ServingImpl;
import impl.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.assertEquals;

/** @author Cherry Rose Semeña & Emmely Lundberg*/
@RunWith(Parameterized.class)
public class DataDrivenTestGetTotalExcessServings {


    private int amount1;
    private int amount2;
    private int amount3;
    private int expResult;

    @Parameterized.Parameters
    public static Collection spreadsheetData() throws IOException {
        InputStream spreadsheet = new FileInputStream("gettotalexcessservings.xls");
        return new SpreadsheetData(spreadsheet).getData();
    }
    /** Inspiration: https://dzone.com/articles/data-driven-tests-junit-4-and */
    public DataDrivenTestGetTotalExcessServings(double amount1, double amount2, double amount3,  double expResult) {
        super();
        this.amount1 = (int) amount1;
        this.amount2 = (int) amount2;
        this.amount3 = (int) amount3;
        this.expResult = (int) expResult;
    }

    @Test
    public void getExcess() {
        ServingHandler instance = new ServingHandlerImpl();
        ArrayList<Serving> servings = new ArrayList<Serving>();
        Time t = new Time("10:01");
        servings.add(new ServingImpl("24-12-2017", t, this.amount1, "André"));
        servings.add(new ServingImpl("24-12-2017", t, this.amount2, "Sofia"));
        servings.add(new ServingImpl("24-12-2017", t, this.amount3, "Paula"));

        int result = instance.getTotalExcessServings(servings);
        assertEquals(this.expResult, result);
    }
}