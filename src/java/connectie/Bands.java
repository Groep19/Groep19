/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectie;

/**
 *
 * @author Ruben Thonissen
 */

/**klasse Bands
 * 
 * @author Sven
 */
public class Bands {
    
    private int band_id;
    private String band_naam;
    private String band_soortMuziek;
    private String band_url;
/**
 * default constructor klasse Bands
 */
    public Bands() {
    }
/**
 * Constructor klasse Bands
 * @param band_id
 * @param band_naam
 * @param band_soortMuziek
 * @param band_url 
 */
    public Bands(int band_id, String band_naam, String band_soortMuziek, String band_url) {
        this.band_id = band_id;
        this.band_naam = band_naam;
        this.band_soortMuziek = band_soortMuziek;
        this.band_url = band_url;
    }
/**
 * getter band_id
 * @return band_id
 */
    public int getBand_id() {
        return band_id;
    }
/**
 * setter band_id
 * @param band_id 
 */
    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }
/**
 * getter band_naam
 * @return band_naam
 */
    public String getBand_naam() {
        return band_naam;
    }
/**
 * setter band_naam
 * @param band_naam 
 */
    public void setBand_naam(String band_naam) {
        this.band_naam = band_naam;
    }
/**
 * getter band_soortMuziek
 * @return band_soortMuziek
 */
    public String getBand_soortMuziek() {
        return band_soortMuziek;
    }
/**
 * setter band_soortMuziek
 * @param band_soortMuziek 
 */
    public void setBand_soortMuziek(String band_soortMuziek) {
        this.band_soortMuziek = band_soortMuziek;
    }
/**
 * getter band_url
 * @return band_url
 */
    public String getBand_url() {
        return band_url;
    }
/**
 * setter band_url
 * @param band_url 
 */
    public void setBand_url(String band_url) {
        this.band_url = band_url;
    }
    
    
}
