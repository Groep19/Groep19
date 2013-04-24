/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campings;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Maikel
 */
public class campingHelper {
    
    Session session = null;
    
    public void CampingHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getCampings(int startId, int endId){
        List<Campings> campingList = null;
        try{
            
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Campings as Campings");
            campingList = (List<Campings>) q.list();
        
        } catch (Exception e) {
        e.printStackTrace();
    }
        return campingList;
    }

}
