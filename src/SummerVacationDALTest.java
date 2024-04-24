import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testInitializeConnection() {
        try {
            summerVacationDAL.InitializeConnection(DATABASE_NAME, USERNAME, PASSWORD);
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

    @Test 
    public void testAddParkAndActivities() throws SQLException{
    String parkName = "TestPark";
        String parkLocation = "TestLocation";
        List<String> activities = Arrays.asList("Hiking", "Swimming");

        when(connection.prepareCall(toString())).thenReturn(callableStatement);

        summerVacationDAL.AddParkAndActivities(parkName, parkLocation, activities);

        verify(connection).prepareCall("{call AddParkAndActivities(?, ?, ?)}");
        verify(callableStatement, times(3)).setString(anyInt(), toString());
        verify(callableStatement).execute();
    }
}
