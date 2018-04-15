
/**
 * Write a description of class TestClient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestClient
{
    public static void main(String [] args)
    {
        Reservation res =  new Reservation();
        
        User user = new User("bob",123456789, 2);
        res.addUser(user);
       
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
        
        User user8 = new User("rudy",123456789, 4);
        res.addUser(user8);
       
        res.displayTables();
        
        res.usersLeft(0);
        res.sendConfirmation("Confirm");
        res.displayTables();
        
        res.usersLeft(1);
        res.displayTables();
        
        User user9 = new User("sam",123456789, 2);
        res.addUser(user9);
        
        res.displayTables();
        res.usersLeft(5);
        
        
    }
}
