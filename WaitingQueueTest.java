

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WaitingQueueTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WaitingQueueTest
{
    /**
     * Default constructor for test class WaitingQueueTest
     */
    
    private Reservation res;
    
    public WaitingQueueTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Reservation res =  new Reservation();
    }

    
    
    @Test
    public void testtoCheckTableAvailabilityWithNoTablesoccupied()
    {
        System.out.println("\n***Test 1: test to check Table availability for first user With No Tables Occupied***");
        // when no tables are occupied check if user with required table capacity is assigned properly
        User user1 = new User("mary",123456789, 4);
        res.addUser(user1);            
        assertEquals(true, res.checktableAvailability(4));
    }
    
    @Test
    public voit testTocheckIftableAssignedtoUserWhenTableisAvailable(){
        System.out.println("\n***Test 2: test To check If user is properly Assigned table When required Table is available ***");
        User user1 = new User("mary",123456789, 4);
        res.addUser(user1);
        assertEquals(true,res.checkIfUserisAssignedTable(user1));
    }
    
     
    @Test
    public void testWithAllTablesoccupiedAndCheckingAvailability()
    {
        System.out.println("\n***Test 3: test With All TAbles Occupied and checking Table Availability***");
        // when all tables are occupied check table availability for new user coming in
        User user1 = new User("mary",123456789, 4);
        res.addUser(user1);
        User user2 = new User("alex",123456789, 2);
        res.addUser(user2);        
        User user3 = new User("jay",123456789, 4);
        res.addUser(user3);        
        User user4 = new User("kat",123456789, 6);
        res.addUser(user4);        
        User user5 = new User("john",123456789, 6);
        res.addUser(user5);        
        User user6 = new User("tim",123456789, 2);
        res.addUser(user6);
        User user7 = new User("lucy",123456789, 6);
        res.addUser(user7);
        assertEquals(false, res.checktableAvailability(6));
    }
    
    @Test
    public voit testTocheckIftableAssignedtoUserWhenAllTablesAreOccupied(){
        System.out.println("\n***Test 4: test To check If table Assigned to New User When All Tables Are Occupied***");
         User user1 = new User("mary",123456789, 4);
        res.addUser(user1);
        User user2 = new User("alex",123456789, 2);
        res.addUser(user2);        
        User user3 = new User("jay",123456789, 4);
        res.addUser(user3);        
        User user4 = new User("kat",123456789, 2);
        res.addUser(user4);        
        User user5 = new User("john",123456789, 6);
        res.addUser(user5);        
        User user6 = new User("tim",123456789, 6);
        res.addUser(user6);
        User user7 = new User("lucy",123456789, 4);
        res.addUser(user7);
        assertEquals(false,res.checkIfUserisAssignedTable(user7));
    }
    
    @Test
    public voit testTocheckIfUsersAreAddedToQueueOnFCFSBasis(){
        System.out.println("\n***Test 5: test To check If Users Are Added To Queue On FCFS Basis***");
        User user1 = new User("mary",123456789, 4);
        res.addUser(user1);
        User user2 = new User("alex",123456789, 2);
        res.addUser(user2);        
        User user3 = new User("jay",123456789, 4);
        res.addUser(user3);        
        User user4 = new User("kat",123456789, 4);
        res.addUser(user4);        
        User user5 = new User("john",123456789, 6);
        res.addUser(user5);        
        User user6 = new User("tim",123456789, 2);
        res.addUser(user6);
        User user7 = new User("lucy",123456789, 6);
        res.addUser(user7);
    }
    
    //check when user leaves if first user in the list gets message for confirmation
    
    //check if user is assigned table when he confirms
    @Test
    public voit testTocheckIfUserIsRemovedFromListAfterRejecting(){
        System.out.println("\n***Test 6: test To check if user is removed from list when he replies with 'leave' ***");
    // check if user is removed from list when he replies with "leave"
        User user1 = new User("mary",123456789, 4);
        res.addUser(user1);
        User user2 = new User("alex",123456789, 2);
        res.addUser(user2);        
        User user3 = new User("jay",123456789, 4);
        res.addUser(user3);        
        User user4 = new User("kat",123456789, 4);
        res.addUser(user4);        
        User user5 = new User("john",123456789, 6);
        res.addUser(user5);        
        User user6 = new User("tim",123456789, 2);
        res.addUser(user6);
        User user7 = new User("lucy",123456789, 6);
        res.addUser(user7);
    
}
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
