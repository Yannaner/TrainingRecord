public class Sprint extends Entry {
    private int numberOfSprints;
    private int recoveryTime;
    public Sprint(String n, int d, int m, int y, int h, int min, int s, float dist, int r, int nOs) {
        super(n, d, m, y, h, min, s, dist);
        recoveryTime = r;
        numberOfSprints = nOs;
    }
    
    public int getRecoveryTime() {
        return recoveryTime;
    }
    
    public int getNumberOfSprints() {
        return numberOfSprints;
    }
    
    public String getEntry () {
    String result = getName()+ " sprint " + getNumberOfSprints() + " times" + " with " + getRecoveryTime() + " minutes of recovery time" + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+ " with a total distance of " + getDistance() + " kilometers" + "\n";
    return result;
   } 
}