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

    public Budget() {
    }

    public Budget(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Month> getMonths() {
        return months;
    }

    public void setMonths(List<Month> months) {
        this.months = months;
    }

    public List<BudgetType> getBudgetTypes() {
        return budgetTypes;
    }

    public void setBudgetTypes(List<BudgetType> budgetTypes) {
        this.budgetTypes = budgetTypes;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
