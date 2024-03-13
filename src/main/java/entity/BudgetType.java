package entity;

import jakarta.persistence.*;
import java.util.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A class to represent a budget type.
 *
 * @author bhesselbacher
 */
@Entity
@Table(name = "budgetType")
public class BudgetType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column
    private String type;

    /**
     * Instantiates a new BudgetType
     */
    public BudgetType() {
    }

    /**
     * Instantiates a new BudgetType
     *
     * @param type the type
     */
    public BudgetType(String type) {
        this.type = type;
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
     * Gets the type
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }
}
