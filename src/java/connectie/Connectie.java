/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectie;

/**
 *
 * @author Sven
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

public class Connectie
{


   private static final String URL = "jdbc:mysql://localhost/groep19_festivals";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "";

   private Connection connection = null; // manages connection
   private PreparedStatement ophalenGebruikers = null; 
   private PreparedStatement ophalenBands = null;
   private PreparedStatement ophalenAlleBands = null;
   private PreparedStatement ophalenAlleFestivals = null; 
   private PreparedStatement ophalenInfoFestivals = null;
   private PreparedStatement toevoegenBand = null;
   private PreparedStatement wijzigenBand = null;
    private PreparedStatement verwijderBand = null;
   
   
   // constructor
   public Connectie()
   {
      try 
      {
         connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );

         // create query that selects all entries in the AddressBook
         ophalenGebruikers = 
            connection.prepareStatement( "SELECT gebr_naam, gebr_paswoord from geregistreerdegebruikers where gebr_naam = ? and gebr_paswoord = ?" );
         
         ophalenBands = 
            connection.prepareStatement ("SELECT * from bands where band_naam = ?");
                      		
         ophalenAlleFestivals = 
            connection.prepareStatement ( "SELECT fest_id, fest_naam, fest_locatie, fest_datum , fest_duur FROM festivals");
         
         ophalenAlleBands =
                 connection.prepareStatement("Select * from bands");
         
         ophalenInfoFestivals = 
                 connection.prepareStatement("SELECT festivals.fest_naam, bands.band_naam, podia.pod_omschr, b.datum, b.uur " +
"from festivals, bands, bandsperfestival b, podia " +
"where b.fest_id = festivals.fest_id AND " +
"b.band_id = bands.band_id AND " +
"b.pod_id = podia.pod_id AND " +
"festivals.fest_naam = ? " + 
                 "ORDER BY `datum` ASC, 'uur' ASC");
         toevoegenBand = connection.prepareStatement("Insert into bands (band_naam,band_soortMuziek,band_url) VALUES (?,?,?");
         wijzigenBand = connection.prepareStatement("UPDATE bands SET " +
            "band_naam = ?, band_soortMuziek = ?, band_url = ?" +
        	"WHERE band_id = ?");
          verwijderBand = connection.prepareStatement("DELETE FROM bands WHERE band_id = ? ");
         
         
      } // end try
      catch ( SQLException sqlException )
      {
         System.out.println(sqlException.getMessage());
         System.exit( 1 );
      } // end catch
   } // end PersonQueries constructor
   
   // select all of the addresses in the database   
   public int OphalenGebruikers(String geb_naam, String geb_paswoord)
   {
      
      ResultSet resultSet = null;
       int count = 0;  
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          ophalenGebruikers.setString(1, geb_naam);
          ophalenGebruikers.setString(2,geb_paswoord);
         resultSet = ophalenGebruikers.executeQuery(); 
           
         while ( resultSet.next() )
         {
            count ++;
               
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
    return count;
   } 
   
   public List < Bands > OphalenBands(String band_naam) throws Exception{
       
       List< Bands > results = null;
       ResultSet resultSet = null;
        
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          ophalenBands.setString(1, band_naam);
         resultSet = ophalenBands.executeQuery(); 
           
         results = new ArrayList< Bands >();
         
         while ( resultSet.next() )
         {
            results.add ( new Bands(
                    resultSet.getInt("band_id"),
                    resultSet.getString("band_naam"),
                    resultSet.getString("band_soortMuziek"),
                    resultSet.getString("band_url")));
               
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
         throw sqlException;
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
            throw sqlException;
         } // end catch
      } // end finally
      
    return results;
   }
   
   public List < Festivals > OphalenAlleFestivals() throws Exception{
        List < Festivals > results = null;
       ResultSet resultSet = null;
               
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         
         resultSet = ophalenAlleFestivals.executeQuery(); 
           
         results = new ArrayList< Festivals >();
         
         while ( resultSet.next() )
         {
            results.add ( new Festivals(
                   resultSet.getInt("fest_id"),
                    resultSet.getString("fest_naam"),
                   resultSet.getString("fest_locatie"),
                    resultSet.getDate("fest_datum"),
                   resultSet.getInt("fest_duur")));
                   
                   
               
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
         throw sqlException;
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
            throw sqlException;
         } // end catch
      } // end finally
      
    return results;
       
       
   } 
   public List < Bands > OphalenAlleBands() throws Exception{
       
       List< Bands > results = null;
       ResultSet resultSet = null;
        
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          
         resultSet = ophalenAlleBands.executeQuery(); 
           
         results = new ArrayList< Bands >();
         
         while ( resultSet.next() )
         {
            results.add ( new Bands(
                    resultSet.getInt("band_id"),
                    resultSet.getString("band_naam"),
                    resultSet.getString("band_soortMuziek"),
                    resultSet.getString("band_url")));
               
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
         throw sqlException;
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
            throw sqlException;
         } // end catch
      } // end finally
      
    return results;
   }
   // close the database connection
   public void close()
   {
      try 
      {
         connection.close();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
   } // end method close
   
   public List < Festivals > OphalenInfoFestivals(String fest_naam) throws Exception{
        List< Festivals > results = null;
       ResultSet resultSet = null;
        
      try 
      {
         // executeQuery returns ResultSet containing matching entries
          ophalenInfoFestivals.setString(1, fest_naam);
         resultSet = ophalenInfoFestivals.executeQuery(); 
           
         results = new ArrayList< Festivals >();
         
         while ( resultSet.next() )
         {
            results.add ( new Festivals(
                    resultSet.getString("fest_naam"),
                    resultSet.getDate("datum"),
                    
                    resultSet.getString("band_naam"),
                    resultSet.getString("pod_omschr"),
                    resultSet.getTime("uur")));
               
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
         throw sqlException;
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
            throw sqlException;
         } // end catch
      } // end finally
      
    return results;
       
       
   } 
   public int ToevoegenBand(String band_naam, String band_genre, String band_url){
       int result = 0;
      
      // set parameters, then execute insertNewPerson
      try 
      {
            toevoegenBand.setString( 1, band_naam );
         toevoegenBand.setString( 2, band_genre );
           toevoegenBand.setString( 3, band_url );
     

         // insert the new entry; returns # of rows updated
         result = toevoegenBand.executeUpdate();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         close();
      } // end catch
      
      return result;
   }
   public int WijzigenBand(  
		   String band_naam, String band_genre, String band_url, int band_id)
		   {
		      int result = 0;
		      
		      // set parameters, then execute insertNewPerson
		      try 
		      {
		        wijzigenBand.setString( 1, band_naam );
		         wijzigenBand.setString( 2, band_genre );
		         wijzigenBand.setString( 3, band_url );
		         wijzigenBand.setInt(4, band_id);
		         

		         // insert the new entry; returns # of rows updated
		         result = wijzigenBand.executeUpdate(); 
		      } // end try
		      catch ( SQLException sqlException )
		      {
		         sqlException.printStackTrace();
		         close();
		      } // end catch
		      
		      return result;
		   }
   public int VerwijderBand( int band_id )
   {
      int result = 0;
      
      // set parameters, then execute insertNewPerson
      try 
      {
         verwijderBand.setInt( 1, band_id);

         // update the entry; returns # of rows updated
         result = verwijderBand.executeUpdate();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         close();
      } // end catch
      
      return result;
   } // end method deletePerson 
} 
