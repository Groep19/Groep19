package Hibernate;
// Generated Apr 22, 2013 6:36:57 PM by Hibernate Tools 3.2.1.GA



/**
 * Bands generated by hbm2java
 */
public class Bands  implements java.io.Serializable {


     private Integer bandId;
     private String bandNaam;
     private String bandSoortMuziek;
     private String bandUrl;

    public Bands() {
    }

	
    public Bands(String bandNaam, String bandSoortMuziek) {
        this.bandNaam = bandNaam;
        this.bandSoortMuziek = bandSoortMuziek;
    }
    public Bands(String bandNaam, String bandSoortMuziek, String bandUrl) {
       this.bandNaam = bandNaam;
       this.bandSoortMuziek = bandSoortMuziek;
       this.bandUrl = bandUrl;
    }
   
    public Integer getBandId() {
        return this.bandId;
    }
    
    public void setBandId(Integer bandId) {
        this.bandId = bandId;
    }
    public String getBandNaam() {
        return this.bandNaam;
    }
    
    public void setBandNaam(String bandNaam) {
        this.bandNaam = bandNaam;
    }
    public String getBandSoortMuziek() {
        return this.bandSoortMuziek;
    }
    
    public void setBandSoortMuziek(String bandSoortMuziek) {
        this.bandSoortMuziek = bandSoortMuziek;
    }
    public String getBandUrl() {
        return this.bandUrl;
    }
    
    public void setBandUrl(String bandUrl) {
        this.bandUrl = bandUrl;
    }




}

