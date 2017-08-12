import java.util.*;
import java.text.*;

/**
 * @author Ruben Rodrigues
 */
public class Procedure {

    private String name;
    private double cost;

    public Procedure(String name, double cost) {

        this.name = name;
        this.cost = cost;

    }
    //Getters
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the member record
     */
    @Override
    public String toString() {

        String info = String.format("%s%s\n", name, cost);

        return info;
    }
}
