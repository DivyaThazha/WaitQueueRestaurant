
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private int phoneNo;
    private int noOfPeople;

    public User(String name, int phoneNo, int noOfPeople)
    {
        this.name = name;
        this.phoneNo = phoneNo;
        this.noOfPeople =  noOfPeople;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPhoneNo() {
        return this.phoneNo;
    }
    
    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public int getNoOfPeople() {
        return this.noOfPeople;
    }
    
    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }
    
}
