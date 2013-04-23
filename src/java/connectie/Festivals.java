/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectie;

import java.sql.Date;
import java.sql.Time;





/**klasse Festivals
 *
 * @author Ruben Thonissen
 */
public class Festivals {
    private int fest_id, fest_duur;
    private String fest_naam, fest_locatie;
    private Date fest_datum, datum;
    private String band_naam, pod_omschr, camp_adres;
    private Time uur;
    /**
     * default constructor Festivals
     */
    public Festivals() {
    
    }
/**
 * constructor klasse Festivals
 * @param fest_naam
 * @param datum
 * @param band_naam
 * @param pod_omschr
 * @param uur 
 */
    public Festivals(String fest_naam, Date datum, String band_naam, String pod_omschr, Time uur) {
        this.fest_naam = fest_naam;
        this.datum = datum;
        this.band_naam = band_naam;
        this.pod_omschr = pod_omschr;
        this.uur = uur;
       
    }

    
    /**
     * constructor klasse Festivals
     * @param fest_id
     * @param fest_naam
     * @param fest_locatie
     * @param fest_datum
     * @param fest_duur 
     */
    public Festivals(int fest_id,  String fest_naam, String fest_locatie, Date fest_datum, int fest_duur) {
        this.fest_id = fest_id;
        this.fest_naam = fest_naam;
         this.fest_locatie = fest_locatie;
          this.fest_datum = fest_datum;
        this.fest_duur = fest_duur;
        
        
       
    }
/**
 * getter uur
 * @return uur
 */
    public Time getUur() {
        return uur;
    }
/**setter uur
 * 
 * @param uur 
 */
    public void setUur(Time uur) {
        this.uur = uur;
    }

    
/**
 * getter fest_id
 * @return het festival_id
 */
    public int getFest_id() {
        return fest_id;
    }
/**
 * setter fest_id
 * @param fest_id 
 */
    public void setFest_id(int fest_id) {
        this.fest_id = fest_id;
    }
/**
 * getter fest_duur
 * @return de duur van het festival
 */
    public int getFest_duur() {
        return fest_duur;
    }
/**
 * setter fest_duur
 * @param fest_duur 
 */
    public void setFest_duur(int fest_duur) {
        this.fest_duur = fest_duur;
    }
/**
 * getter fest_naam
 * @return de naam van het festival
 */
    public String getFest_naam() {
        return fest_naam;
    }
/**
 * setter fest_naam
 * @param fest_naam 
 */
    public void setFest_naam(String fest_naam) {
        this.fest_naam = fest_naam;
    }
/**
 * getter fest_locatie
 * @return de locatie van het festival
 */
    public String getFest_locatie() {
        return fest_locatie;
    }
/**
 * setter fest_locatie
 * @param fest_locatie 
 */
    public void setFest_locatie(String fest_locatie) {
        this.fest_locatie = fest_locatie;
    }
/**
 * getter fest_datum
 * @return  de datum van het festival
 */
    public Date getFest_datum() {
        return fest_datum;
    }
/**
 * setter fest_datum
 * @param fest_datum 
 */
    public void setFest_datum(Date fest_datum) {
        this.fest_datum = fest_datum;
    }
/**
 * getter datum
 * @return de datum
 */
    public Date getDatum() {
        return datum;
    }
/**
 * setter datum
 * @param datum 
 */
    public void setDatum(Date datum) {
        this.datum = datum;
    }
/**
 * getter band_naam
 * @return de naam van de band
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
 * getter pod_omschr
 * @return de omschrijving van het podium
 */
    public String getPod_omschr() {
        return pod_omschr;
    }
/**
 * setter pod_omschr
 * @param pod_omschr 
 */
    public void setPod_omschr(String pod_omschr) {
        this.pod_omschr = pod_omschr;
    }
/**
 * getter camp_adres
 * @return het adres van de camping
 */
    public String getCamp_adres() {
        return camp_adres;
    }
/**
 * setter camp_adres
 * @param camp_adres 
 */
    public void setCamp_adres(String camp_adres) {
        this.camp_adres = camp_adres;
    }

   
    
    
}
