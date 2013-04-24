<%-- 
    Document   : index
    Created on : Mar 21, 2013, 3:52:33 PM
    Author     : Maikel Vanmuysen, Tim Telen, Sven Haenen, Ruben Thonissen, Robin Verdingh
               : Project Groep 19
--%>


<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset=utf-8>
<title>FestivalSite Group 19</title>
<meta name="keywords" content="keywords, here" />
<meta name="description" content="your description here" />

<script src="js/modernizr-1.1.min.js"></script><!-- this is the javascript allowing html5 to run in older browsers -->


<link rel="stylesheet" type="text/css" href="css/css3.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/general.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/grid.css" media="screen" />
<!-- @font-face provided by google, works on 97% of browsers -->
<link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz' rel='stylesheet' type='text/css'>

<style>
/* Feel free to remove these styles, they are for demo page */
.logo, h1, h2, h3, h4, h5, header { font-family: 'Yanone Kaffeesatz', arial, serif; font-size: large; }


header {height:175px; position:relative; margin-bottom:10px; border-bottom:#4B88BE; border-bottom-style: solid; border-bottom-width: 8px;}
	header .logo {font-size:5em; height:100px; padding-top:22px; font-weight:700; text-shadow:5px 5px 10px #4B88BE; color:#EB5A1E; filter: Shadow(Color=#4B88BE, Direction=135, Strength=13);}
	header .statement {width:20%; text-align:right; padding-top:100px;}
header nav { background-color:#EB5A1E; color:#fff; height:28px;   }
	nav ul {list-style:none;}
	nav ul li {float:left; margin-left:5px;}
	nav ul li a {display:block; color:#fff; text-decoration:none; padding:2px 8px; margin-top:3px;  
					-moz-border-radius-topleft: 5px; -webkit-border-top-left-radius: 5px; -moz-border-radius-topright: 5px; -webkit-border-top-right-radius: 5px;}
	nav ul li a:hover, nav ul li.active a {background-color:#4B88BE; color:#000;}
        logonknop {float: right; margin-right: 5px;}        

aside {min-height:400px;}	

footer { font-size:.8em; } 
</style>

<script language="JavaScript1.1">
<!--
var image1=new Image()
image1.src="Afbeeldingen/festival1.jpg"
var image2=new Image()
image2.src="Afbeeldingen/festival2.jpg"
var image3=new Image()
image3.src="Afbeeldingen/festival3.jpg"
//-->
</script>


</head>
<body>
    
<div class="row">
    <header>
        <div class="logo left"><img src="Afbeeldingen/logo2b.PNG" align="left">
             Festivals
        </div>
      
        
        <div class="clear"></div>
        
        <%-- Dit is de menubalk waartussen de gebruiker kan kiezen --%>
        <nav>
        	<ul>
            	<li class="active"><a href="./ENindex.jsp">Home</a></li>
                <li><a href="./ENfestivals.jsp">Festival</a></li>
                <li><a href="./ENbands.jsp">Bands</a></li>
                <li><a href="./ENlocatie.jsp">Location</a></li>
                <li><a href="./ENprijzen.xhtml">Campings</a></li>
                <logonknop><li><a href="./ENindex.jsp">Uitloggen</a></li></logonknop>
                <logonknop><li><a href="./ENadmin.jsp"><img src="./Afbeeldingen/EN.jpg" border="0"  /></a></li></logonknop>
                <logonknop><li><a href="./admin.jsp"><img src="./Afbeeldingen/NL.jpg" border="0" /></a></li></logonknop>
            </ul>
            
        </nav>
    </header>
    <div class="clear"></div>
    <aside class="col_4 col box_shadow shadow">
        <p style="padding:5px;">
            <img src="Afbeeldingen/festival1.jpg" name="slide" width=210 height=400>
                    <script>
                    <!--
                    //variabele die per image stijgt met 1
                    var step=1
                    function slideit(){
                    //Als de browser de afbeelding niet ondersteund =>
                    if (!document.images)
                    return
                    document.images.slide.src=eval("image"+step+".src")
                    if (step<3)
                    step++
                    else
                    step=1
                    //roept de functie slideit elke 2,5 seconde op
                    setTimeout("slideit()",5000)
                    }
                    slideit()
                    //-->
                    </script>
            
            
            
        </p> <%-- Hiertussen komt de tekst voor in de box links in het scherm te zetten. --%>
    </aside>
    
    <div class="content col_12 col">
        <article>
            <%@page import="java.util.List"%>
                          <%@page import="connectie.Connectie"%>
                          <%@page import="connectie.Bands"%>
        <%
            //indien er op de knop "toevoegen" geklikt wordt ==> onderstaande code uitvoeren
            if (request.getParameter("toevoegen")!=null){
                //object van de klasse "Connectie" aanmaken
              Connectie b = new Connectie();
              //uitvoeren methode "ToevoegenBand" van de klasse "Connectie"
              int result = b.ToevoegenBand(request.getParameter("naam"), request.getParameter("genre"), request.getParameter("website"));
              if (result == 1){
                  out.println("<p>Insert succeeded.</p>");
              }else{
                  out.println("<p>There is a error.</p>");
              }
              //Sluiten van de connectie
              b.close();
            }
            //Indien er op de knop "wijzigen" geklikt wordt ==> onderstaande code uitvoeren
            if (request.getParameter("wijzigen")!=null){
               
                Connectie wijzigen = new Connectie();
                int id = Integer.parseInt(request.getParameter("hidden")) + 1;
                int result = wijzigen.WijzigenBand(request.getParameter("naam"), request.getParameter("genre"), request.getParameter("website"),id);
                if (result == 1){
                  out.println("<p>update succeeded.</p>");
              }else{
                  out.println("<p>There is a error.</p>");
              }
                wijzigen.close();
            }
            //Indien er op de knop "verwijderen" geklikt wordt ==> onderstaande code uitvoeren
             if (request.getParameter("verwijderen")!=null){
                int id = Integer.parseInt(request.getParameter("hidden")) + 1;
                 //object van de klasse "Connectie" aanmaken
                Connectie verwijderen = new Connectie();
                //uitvoeren methode "VerwijderBand" van de klasse "Connectie"
                int result = verwijderen.VerwijderBand(id);
                 if (result == 1){
                  out.println("<p>Delete succeeded</p>");
              }else{
                  out.println("<p>There is a error.</p>");
              }
                 //Sluiten van de connectie
                verwijderen.close();
            }
         int current = 0;
         int max= 0;
         
            if(request.getParameter("hidden") != null) {
                current = Integer.parseInt(request.getParameter("hidden"));
            }
            if(current < 0){
                current = 0;
            }
            
         Bands b = new Bands();
       List < Bands> bands;
    //object van de klasse "Connectie" aanmaken
       Connectie connectie = new Connectie();
       //methode "OphalenAlleBands" uitvoeren ==> haalt alle records op uit de tabel bands van de database.
        bands = connectie.OphalenAlleBands();
         max = bands.size();
         if (current == bands.size()){
             current = 0;
         }
       try{
        
       bands = connectie.OphalenAlleBands();
             
             }
       catch(Exception e){
       StackTraceElement [] a = e.getStackTrace();
       for(int i =0;i<a.length; i++){
       out.print(a[i]);
       
       }
       
       }
        
        %>
            <h1>Manage bands</h1>
            <form name="form1" action="ENadmin.jsp">
                
                    Name
                    <input type="text" name="naam" value="<%=bands.get(current).getBand_naam()%>" /><br/>
                    Genre:
                    <input type="text" name="genre" value="<%=bands.get(current).getBand_soortMuziek()%>" /><br/>
               
                    Website:
                   <input type="text" name="website" value="<%=bands.get(current).getBand_url()%>" /><br/>
                  <INPUT TYPE="HIDDEN" NAME="hidden" VALUE="<%= current %>">
                   <input type="submit" value="<" name="vorige" ONCLICK="movePrevious()"  />
                  <input type="submit" value=">" name="volgende" ONCLICK="moveNext()"  /><br/>
                 <input type="submit" value="Insert" name="toevoegen" />
                <input type="submit" value="Update" name="wijzigen" />
                <input type="submit" value="Delete" name="verwijderen" />
            </form>
            
            
                  </article>  
    </div><!-- end content -->
    <SCRIPT LANGUAGE="JavaScript">
            <!--
            function moveNext()
            {
                var counter = 0;
                counter = parseInt(document.form1.hidden.value) + 1;
                document.form1.hidden.value = counter;
                form1.submit();
            }    
            function movePrevious()
            {
                var counter = 0;
                counter = parseInt(document.form1.hidden.value) - 1;
                document.form1.hidden.value = counter;
                form1.submit();
            }    
            // --> 
        </SCRIPT>
    
  <div class="clear" style="height:10px; border-bottom:1px solid #ccc;"></div>
</div><!-- end wrap -->
<footer class="row">
    <section class="col_8 col align_left">
   
    </section>
    <section class="col_8 col align_right">
    Group 19 : Maikel Vanmuysen, Tim Telen, Sven Haenen, Ruben Thonissen, Robin Verdingh
    </section>
</footer>
</body>
</html>
