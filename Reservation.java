import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Reservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Reservation
{
    // instance variables - replace the example below with your own
    List<User> userlist = new ArrayList<User>();
    List<Table> tables =  new ArrayList<Table>();
    List<Reservation> reservations =  new ArrayList<Reservation>();
    
    private int id;
    private String user;
    private int tableId;
    public int userIndexIdForConf;
    
    public Reservation()
    {
        setUpTables();
    }
    
    public Reservation(String user, int tableId){
        this.user = user;
        this.tableId = tableId;
    }
    
    public int getId() {return this.id;}
    
    public void setId(int id) {this.id = id;}
    
    public String getUser() {return this.user;}
    
    public void setUser(String user) {this.user = user;}
    
    public int getTableId(){return this.tableId;}
    
    public void setTableId(int tableId){this.tableId = tableId;}
    
    public void setUpTables(){
        Table t1 = new Table(0, 2, true);
        Table t2 = new Table(1, 2, true);
        Table t3 = new Table(2, 4, true);
        Table t4 = new Table(3, 4, true);
        Table t5 = new Table(4, 6, true);
        Table t6 = new Table(5, 6, true);
        
        tables.add(t1);
        tables.add(t2);
        tables.add(t3);
        tables.add(t4);
        tables.add(t5);
        tables.add(t6);
    }
    
    public void addUser(User user){
        int size = userlist.size();
        int id = 0;
        if(size == 0)
            id = 0;
        else
            id = userlist.get(size - 1).getId();
        user.setId(id + 1);
        userlist.add(user);
        assignTabletoUserifAvailable();
    }
    //new
    boolean checkIfUserisAssignedTable(User user)
    {     
          //check if user is assigned to table by checking tableid of user
       int capacityReq = user.getNoOfPeople();
            int foundTableId = getTableIdifTableAvailable(capacityReq);
            if(foundTableId == -1 ){
                System.out.println("Please wait! Table is not available");
                return false;
            }
            else{
            System.out.println("Table "+ foundTableId + " is successfully assigned to user "+ user.getName());
            return true;
            }
        
    }

    
    public void assignTabletoUserifAvailable(){
        int size = userlist.size();
            User user = userlist.get(size - 1);
            int capacityReq = user.getNoOfPeople();
            int foundTable = getTableIdifTableAvailable(capacityReq);
            if(foundTable == -1 ){
                System.out.println("Please wait! Table is not available");
            }else
            {
                System.out.println("Table "+ foundTable + " assigned to user "+user.getName());
                tables.get(foundTable).setAvailable(false);
                int resid = reservations.size();
                Reservation res = new Reservation(user.getName(),foundTable);
            
                int id = 0;
                if(resid == 0)
                    id = 0;
                else
                    id = reservations.get(resid - 1).getId();
                    
                res.setId(id + 1);
                reservations.add(res);
                    userlist.remove(size - 1);
            }
    }
    
    public void assignTable(int type){
        for (int i = 0; i < userlist.size(); i++) {
            User user = userlist.get(i);
            int capacityReq = user.getNoOfPeople();
            int foundTable = getTableIdifTableAvailable(capacityReq);
            if(foundTable == -1 && type == 1){
                System.out.println("Please wait! Table is not available");
            }else
            {
                System.out.println("Table "+ foundTable + " assigned to user "+user.getName());
                tables.get(foundTable).setAvailable(false);
                int resid = reservations.size();
                Reservation res = new Reservation(user.getName(),foundTable);
            
                int id = 0;
                if(resid == 0)
                    id = 0;
                else
                    id = reservations.get(resid - 1).getId();
                res.setId(id + 1);
                reservations.add(res);
                userlist.remove(i);
                break;
            }
        }       
    }
    
    
    public int getTableIdifTableAvailable(int capacity){
        
        for (int i = 0; i < tables.size(); i++) {
          if(tables.get(i).getAvail() == true && capacity <= tables.get(i).getCapacity())
                return tables.get(i).getId();
        }
        return -1;
    }
    
    //new
    public boolean checktableAvailability(int capacity){
        for (int i = 0; i < tables.size(); i++) {
          if(tables.get(i).getAvail() == true && capacity <= tables.get(i).getCapacity())
                return true;
        }
        return false;
    }
        
    public void usersLeft(int table){
       int index = - 1;
       for (int i = 0; i < reservations.size(); i++) {
          if(table == reservations.get(i).getTableId()){
              index = i;
              break;
          }
       }
       if(index != -1)
       {
          tables.get(table).setAvailable(true);
          reservations.remove(index);
          askConfirmation(tables.get(table).getCapacity());
       }
       else{
          System.out.println("Reservation not found");
       } 
    }
    
    /*new
    public boolean checkIfConfirmationSent(User user){
        for (int i = 0; i < userlist.size(); i++) {
          if(  userlist.get(i).getNoOfPeople() <= capacity){
              userIndexIdForConf = i;
        
    }
}
}*/
    public void askConfirmation(int capacity){
       
       for (int i = 0; i < userlist.size(); i++) {
          if(  userlist.get(i).getNoOfPeople() <= capacity){
              userIndexIdForConf = i;
              System.out.println(""); 
              System.out.println("Hi "+userlist.get(i).getName() + ", Your table is ready. Check in with our host right away with your entire party.");
              System.out.println("Confirm if you are on the way or text 'Leave' to leave.");
              break;
          }
       }
    }    
    
    public void sendConfirmation(String command){
        if(command == "Confirm"){
            assignTable(0);
        }
        else if(command == "Leave"){
            userlist.remove(userIndexIdForConf);
        }
    }    
    
    public void displayTables (){ 
       System.out.println("");  
       System.out.println("************* USERS ************"); 
       for (int i = 0; i < userlist.size(); i++) {
           
          System.out.println("User "+ userlist.get(i).getId() + " name "+ 
          userlist.get(i).getName() + ", capacity: " + userlist.get(i).getNoOfPeople());
       }
       
       System.out.println("************* TABLES ************"); 
       for (int i = 0; i < tables.size(); i++) {
           
          System.out.println("Table "+ tables.get(i).getId() + " with capacity "+ 
          tables.get(i).getCapacity() + ", available: " + tables.get(i).getAvail());
       } 
       
       System.out.println("************* RESERVATIONS ************");
       for (int i = 0; i < reservations.size(); i++) {
           
          System.out.println("Resrvation "+ reservations.get(i).getId() + " with user "+ 
          reservations.get(i).getUser() + ", table: " + reservations.get(i).getTableId());
       } 
    }
    

}
