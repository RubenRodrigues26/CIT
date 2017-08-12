import java.util.*;
import java.text.*;

/**
 * @author Ruben Rodrigues
 */
public class Patient {

    private int id;
    private String name;
    private String address;
    private String phoneNo;

    public Patient(int id, String name, String address, String phoneNo) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;

    }
    //Getters
    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the member record
     */
    @Override
    public String toString() {

        String info = String.format("%s%s%s%s\n", id, name, address, phoneNo);

        return info;
    }
}
