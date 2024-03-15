package persistence;

import org.junit.jupiter.api.*;

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
    void getById() {
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