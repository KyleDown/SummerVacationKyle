import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.*;

import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SummerVacationDALTest {
   private Connection connection;
     private SummerVacationDAL summerVacationDAL;
     private CallableStatement callableStatement;

    @Before
    public void setUp() {
        summerVacationDAL = new SummerVacationDAL("SummerVacation", "", "");
        connection = mock(Connection.class);
        summerVacationDAL.setConnection(connection);
        callableStatement = mock(CallableStatement.class);
    }

   
    private Connection mock(Class<Connection> class1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mock'");
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
    @Test 
    public void testAddParkAndActivities() throws SQLException{
String parkName = "TestPark";
        String parkLocation = "TestLocation";
        List<String> activities = Arrays.asList("Hiking", "Swimming");

        when(connection.prepareCall(toString())).thenReturn(callableStatement);

        // Call the method
        summerVacationDAL.AddParkAndActivities(parkName, parkLocation, activities);

        // Verify that prepareCall was called with the correct SQL
        verify(connection).prepareCall("{call AddParkAndActivities(?, ?, ?)}");
        // Verify that setString was called 3 times (for parkName, parkLocation, and activitiesList)
        verify(callableStatement, times(3)).setString(anyInt(), toString());
        // Verify that execute was called
        verify(callableStatement).execute();
    }
}
