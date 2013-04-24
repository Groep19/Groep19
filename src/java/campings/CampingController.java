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
@ManagedBean (name = "CampingController")
@SessionScoped
public class CampingController {

   DataModel campings;
   campingHelper helper;
   
   int startId;
   int endId;
   private int recordCount = 1000;
   private int pageSize = 10;
   private Campings current;
   private int selectedItemIndex;
   
    
    public CampingController() {
        helper = new campingHelper();
        startId = 1;
        endId = 10;
    }
    
    public CampingController(int startId, int endId){
        helper = new campingHelper();
        this.startId = startId;
        this.endId = endId;
    }

        public Campings getSelected() {
        if (current == null) {
            current = new Campings();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    
    public DataModel getCampings(){
        if(campings == null){
            campings = new ListDataModel(helper.getCampings(startId, endId));
        }
        return campings;
        
    }

    void recreateModel(){
        campings = null;
    }

public boolean isHasNextPage() {
        if (endId + pageSize <= recordCount) {
            return true;
        }
        return false;
    }

    public boolean isHasPreviousPage() {
        if (startId-pageSize > 0) {
            return true;
        }
        return false;
    }

    public String next() {
        startId = endId+1;
        endId = endId + pageSize;
        recreateModel();
        return "index";
    }
    
      public String previous() {
        startId = startId - pageSize;
        endId = endId - pageSize;
        recreateModel();
        return "index";
    }

      public int getPageSize() {
        return pageSize;
    }

    public String prepareView(){
        current = (Campings) getCampings().getRowData();
        return "prijzen";
    }
    
       public String prepareList(){
        recreateModel();
        return "index";
    }

}
