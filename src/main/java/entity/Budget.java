package entity;

import jakarta.persistence.*;
import java.util.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A class to represent a budget.
 *
 * @author bhesselbacher
 */
@Entity
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Month> months = new ArrayList<>();

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<BudgetType> budgetTypes = new ArrayList<>();

    @Column
    private double amount;

    /**
     * Instantiates a new Budget
     */
    public Budget() {
    }

    /**
     * Instantiates a new Budget
     *
     * @param amount the amount
     */
    public Budget(double amount) {
        this.amount = amount;
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
     * Gets the id
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the months
     *
     * @return the months
     */
    public List<Month> getMonths() {
        return months;
    }

    /**
     * Sets the months
     *
     * @param months the months
     */
    public void setMonths(List<Month> months) {
        this.months = months;
    }

    /**
     * Gets the budget types
     *
     * @return the budget types
     */
    public List<BudgetType> getBudgetTypes() {
        return budgetTypes;
    }

    /**
     * Sets the budget types
     *
     * @param budgetTypes the budget types
     */
    public void setBudgetTypes(List<BudgetType> budgetTypes) {
        this.budgetTypes = budgetTypes;
    }

    /**
     * Gets the amount
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     *
     * @param amount the amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Converts Budget to a String
     *
     * @return the Budget
     */
    @Override
    public String toString() {
        return "Budget{" +
                "months=" + months +
                ", budgetTypes=" + budgetTypes +
                ", amount=" + amount +
                '}';
    }
}
