package persistence;

import entity.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BudgetDAOTest {
    BudgetDAO budgetDAO;

    @BeforeEach
    void setUp() {
        // Instantiate the BudgetDAO
        budgetDAO = new BudgetDAO();

        // Connect to the Database and set it to the base settings
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getByIdSuccess() {
        // Retrieve a Budget and verify
        Budget retrievedBudget = budgetDAO.getById(1);
        assertNotNull(retrievedBudget);
        assertEquals(34.50, retrievedBudget.getAmount());
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}