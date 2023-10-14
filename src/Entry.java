
import java.util.Calendar;
public class Entry {
  private String name;
  private Calendar dateAndTime;
  private float distance;
  
  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
  } 
  public String getName () {
    return name;
  } 
  
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } 
  
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } 
  
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } 

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  }

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } 

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } 
  
  public float getDistance() {
    return distance;
  }
  
  public String getEntry () {
    String result = this.getEntry();
    return result;
  } //getEntry
  
} // Entry