/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Maikel
 */
@ManagedBean
@SessionScoped
public class CampingController {

   DataModel campings;
   campingHelper helper;
   
   
    public CampingController() {
        helper = new campingHelper();
    }
    
    public DataModel getCampings(){
        if(campings == null){
            campings = new ListDataModel(helper.getCampings());
        }
        return campings;
        
    }

    void recreateModel(){
        campings = null;
    }








}
