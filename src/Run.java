public class Run extends Entry {
    public Run(String n, int d, int m, int y, int h, int min, int s, float dist) {
        super(n, d, m, y, h, min, s, dist);
    }
        
    public String getEntry () {
    String result = getName()+" ran " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
    return result;
   } 
}