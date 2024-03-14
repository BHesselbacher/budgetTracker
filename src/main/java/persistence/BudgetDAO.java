package persistence;

import entity.Budget;
import jakarta.persistence.criteria.*;
import org.apache.logging.log4j.*;
import org.hibernate.*;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import java.util.*;

public class BudgetDAO {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets a budget by id
     *
     * @param id the id
     * @return the budget
     */
    public Budget getById(int id) {
        Session session = sessionFactory.openSession();
        Budget budget = session.get(Budget.class, id);
        logger.info("\nBudget: {}", budget);
        session.close();
        return budget;
    }

    /**
     * Updates a budget
     *
     * @param budget Budget to be updated
     */
    public void update(Budget budget) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(budget);
        transaction.commit();
        logger.info("\nUpdated Budget: {}", budget);
        session.close();
    }

    /**
     * Inserts a new Budget
     *
     * @param budget Budget to be inserted
     * @return the id of inserted Budget
     */
    public int insert(Budget budget) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(budget);
        transaction.commit();
        id = budget.getId();
        logger.info("\nInserted Budget: {}\nInserted Budget Id: {}", budget, id);
        session.close();
        return id;
    }

    /**
     * Deletes a Budget
     *
     * @param budget Budget to be deleted
     */
    public void delete(Budget budget) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(budget);
        transaction.commit();
        logger.info("\nDeleted Budget: {}", budget);
        session.close();
    }

    /**
     * Returns a List of all Budgets
     *
     * @return All Budgets
     */
    public List<Budget> getAll() {
        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Budget> query = builder.createQuery(Budget.class);
        Root<Budget> root = query.from(Budget.class);
        List<Budget> budgets = session.createSelectionQuery(query).getResultList();
        logger.info("\nList of Budgets: {}", budgets);
        session.close();
        return budgets;
    }

    /**
     * Gets Budget by property (exact match)
     * sample usage: getByPropertyEqual("month", "January")
     *
     * @param propertyName the name of the property
     * @param value the search value
     * @return the List of budgets
     */
    public List<Budget> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        logger.debug("\nSearching for Budget with {} = {}", propertyName, value);
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Budget> query = builder.createQuery(Budget.class);
        Root<Budget> root = query.from(Budget.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Budget> budgets = session.createSelectionQuery(query).getResultList();
        logger.debug("\nList of Equal budgets: {}", budgets);
        session.close();
        return budgets;
    }

    /**
     * Gets Budget bby property (like)
     * sample usage: getByPropertyLike("month", "J")
     *
     * @param propertyName the name of the property
     * @param value the search value
     * @return the List of budgets
     */
    public List<Budget> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        logger.debug("\nSearching for Budget with {} == {}", propertyName, value);
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Budget> query = builder.createQuery(Budget.class);
        Root<Budget> root = query.from(Budget.class);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<Budget> budgets = session.createQuery(query).getResultList();
        logger.debug("\nList of Like budgets: {}", budgets);
        session.close();
        return budgets;
    }
}
