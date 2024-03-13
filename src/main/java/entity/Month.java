package entity;

import jakarta.persistence.*;
import java.util.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A class to represent a month.
 *
 * @author bhesselbacher
 */
@Entity
@Table(name = "month")
public class Month {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column
    private String monthName;

    /**
     * Instantiates a new Month
     */
    public Month() {
    }

    /**
     * Instantiates a new Month
     *
     * @param monthName the name of the month
     */
    public Month(String monthName) {
        this.monthName = monthName;
    }

    /**
     * Gets the id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the month
     *
     * @return the name of the month
     */
    public String getMonthName() {
        return monthName;
    }

    /**
     * Sets the name of the month
     *
     * @param monthName the name of the month
     */
    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
}
