public class Swim extends Entry {
    private String location;
    public Swim(String n, int d, int m, int y, int h, int min, int s, float dist, String location2) {
        super(n, d, m, y, h, min, s, dist);
        location = location2;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getEntry () {
        String result = getName()+" swam " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " " + getLocation() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } 
}