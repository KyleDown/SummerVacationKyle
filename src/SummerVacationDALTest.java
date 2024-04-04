import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummerVacationDALTest {
   private Connection connection;
     private SummerVacationDAL summerVacationDAL;

    @Before
    public void setUp() {
        summerVacationDAL = new SummerVacationDAL("SummerVacation", "", "");
    }

   
    @Test
    public void testInitializeConnection() {
        try {
            // Call the method to initialize the connection
            summerVacationDAL.InitializeConnection(DATABASE_NAME, USERNAME, PASSWORD);
            // Check if connection is not null after initialization
            assertNotNull(summerVacationDAL.getConnection());
        } catch (Exception e) {
            fail("Exception thrown during connection initialization: " + e.getMessage());
        }
        @Test
        public void testTryGetDestinationForActivity() {
        try {
            
            String testActivityName = "TestActivity";
            
            List<String> destinations = summerVacationDAL.TryGetDestinationForActivity(testActivityName);
            
            assertNotNull(destinations);
            assertFalse(destinations.isEmpty());
        } catch (Exception e) {
            fail("Exception thrown during TryGetDestinationForActivity method: " + e.getMessage());
        }
    }
}
