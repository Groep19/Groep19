<%-- 
    Document   : index
    Created on : Mar 21, 2013, 3:52:33 PM
    Author     : Maikel Vanmuysen, Tim Telen, Sven Haenen, Ruben Thonissen, Robin Verdingh
               : Project Groep 19
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            	<li><a href="./ENindex.jsp">Home</a></li>
                <li class="active"><a href="./ENfestivals.jsp">Festival</a></li>
                <li><a href="./ENbands.jsp">Bands</a></li>
                <li><a href="./ENlocatie.jsp">Location</a></li>
                <li><a href="./ENprijzen.xhtml">Campings</a></li>
                <logonknop><li><a href="./ENlogin.jsp">Login</a></li></logonknop>
                <logonknop><li><a href="./ENfestivals.jsp"><img src="./Afbeeldingen/EN.jpg" border="0"  /></a></li></logonknop>
                <logonknop><li><a href="./festivals.jsp"><img src="./Afbeeldingen/NL.jpg" border="0" /></a></li></logonknop>
            </ul>
            
        </nav>
    </header>
    <div class="clear"></div>
    <aside class="col_4 col box_shadow shadow">
        <p style="padding:5px;">
            <img src="Afbeeldingen/festival1.jpg" name="slide" width=210 height=400>
                    <script>
                    <!--
                    //variable that will increment through the images
                    var step=1
                    function slideit(){
                    //if browser does not support the image object, exit.
                    if (!document.images)
                    return
                    document.images.slide.src=eval("image"+step+".src")
                    if (step<3)
                    step++
                    else
                    step=1
                    //call function "slideit()" every 2.5 seconds
                    setTimeout("slideit()",5000)
                    }
                    slideit()
                    //-->
                    </script>
            
            
            
        </p> <%-- Hiertussen komt de tekst voor in de box links in het scherm te zetten. --%>
    </aside>
    
    <div class="content col_12 col">
        <article>
            <h1>Welcome to the page of festivals</h1>
            
             <%@page import="java.util.List"%>
             <%@page import="connectie.Connectie"%>
             <%@page import="connectie.Festivals"%>
             <table>
                 <tr>
                     <td width=20><b><u>ID</u></b></td>
                     <td width=200><b><u>Name</u></b></td>
                     <td width=200><b><u>Location</u></b></td>
                     <td width=100><b><u>Date</u></b></td>
                     <td width=20><b><u>Duration</u></b></td>          
                 </tr>
            <%
            List < Festivals > resultaat;
            
            //object van de klasse "Connectie" aanmaken
            Connectie connectie = new Connectie();
            
      //uitvoeren methode "OphalenAlleFestivals" van de klasse "Connectie"
            
            try{
                resultaat = connectie.OphalenAlleFestivals();
                for (int i=0;i<resultaat.size();i++){
                %><tr> <%
                %><td><%out.println(resultaat.get(i).getFest_id());%></td><%
                %><td><a href="./ENfestinfo.jsp?fest_naam=<%=resultaat.get(i).getFest_naam()%>"><%out.println(resultaat.get(i).getFest_naam());%></a></td><%
                %><td><%out.println(resultaat.get(i).getFest_locatie());%></td><%
                %><td><%out.println(resultaat.get(i).getFest_datum());%></td><%
                %><td><%out.println(resultaat.get(i).getFest_duur());%></td><%
                %></tr><%
                
                               }
               
                //Sluiten van de connectie
                connectie.close();
            } catch (Exception e){
       StackTraceElement [] a = e.getStackTrace();
       for(int i =0;i<a.length; i++){
       out.print(a[i]);
       
       }
              }
                    
           
            
            
            
            
            
            
            
            %>
             </table>
        </article>  
    </div><!-- end content -->
    
    
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

