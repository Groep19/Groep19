package campings;
// Generated Apr 23, 2013 11:10:33 PM by Hibernate Tools 3.2.1.GA



/**
 * Campings generated by hbm2java
 */
public class Campings  implements java.io.Serializable {


     private Integer campId;
     private String campAdres;
     private int campCap;

    public Campings() {
    }

    public Campings(String campAdres, int campCap) {
       this.campAdres = campAdres;
       this.campCap = campCap;
    }
   
    public Integer getCampId() {
        return this.campId;
    }
    
    public void setCampId(Integer campId) {
        this.campId = campId;
    }
    public String getCampAdres() {
        return this.campAdres;
    }
    
    public void setCampAdres(String campAdres) {
        this.campAdres = campAdres;
    }
    public int getCampCap() {
        return this.campCap;
    }
    
    public void setCampCap(int campCap) {
        this.campCap = campCap;
    }




}


