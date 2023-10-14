public class Cycle extends Entry {
    private String terrain;
    public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain2) {
        super(n, d, m, y, h, min, s, dist);
        terrain = terrain2;
    }
    
    public String getTerrain() {
        return terrain;
    }
    
    public String getEntry () {
        String result = getName()+" cycled " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " in " + getTerrain() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } 
}