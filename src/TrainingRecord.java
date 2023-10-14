
import java.util.*;
public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } 
    
    //add a record to the list
   public void addEntry(Entry e) {
       tr.add(e);    
   } 
   
   public String removeEntry(Entry e) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "Nothing ";
       while (iter.hasNext()) {
          Entry current = iter.next();          
          if (current.getName().equals(e.getName()) && current.getDay()==e.getDay() && current.getMonth()==e.getMonth() && current.getYear()==e.getYear()) {
             tr.remove(current);
             result = current.getName();
             break;
          }
      }
      return result;
   }
      
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
       }
       return result;
   } 
   
   public String lookupAll (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
             result = result + current.getEntry();
          }
       }
       if (result.equals("")) {
           result = "No entries found";
       }
       return result;
   } 
}