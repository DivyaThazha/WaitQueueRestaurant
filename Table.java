
/**
 * Write a description of class Table here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Table
{
    // instance variables - replace the example below with your own
    private int id;
    private int capacityofTable;
    private boolean available;

    public Table(int id, int capacity, boolean available)
    {
       this.id = id;
       this.capacityofTable = capacity;
       this.available = available;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getCapacity() {
        return this.capacityofTable;
    }
    
    public void setCapacity(int capacity) {
        this.capacityofTable = capacityofTable;
    }
    
    public boolean getAvail(){
        return this.available;
    }
    
    public void setAvailable(boolean available){
        this.available = available;
    }
}
