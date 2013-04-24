<%-- 
    Document   : index
    Created on : Mar 21, 2013, 3:52:33 PM
    Author     : Maikel Vanmuysen, Tim Telen, Sven Haenen, Ruben Thonissen, Robin Verdingh
               : Project Groep 19
--%>


<%@page import="connectie.Connectie"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset=utf-8>
<title> Festivalsite Group 19</title>
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
header nav { background-color:#EB5A1E; color:#fff; height:25px;   }
	nav ul {list-style:none;}
	nav ul li {float:left; margin-left:5px;}
	nav ul li a {display:block; color:#fff; text-decoration:none; padding:2px 8px; margin-top:3px;  
					-moz-border-radius-topleft: 5px; -webkit-border-top-left-radius: 5px; -moz-border-radius-topright: 5px; -webkit-border-top-right-radius: 5px;}
	nav ul li a:hover, nav ul li.active a {background-color:#4B88BE; color:#000;}


aside {min-height:525px;}	

footer { font-size:.8em; } 
</style>
</head>
<body>
<div class="row">
    <header>
        <div class="logo left"><img src="Afbeeldingen/logo2b.PNG" align="left">
           Festivals
        </div>
        
        <div class="statement right"><button type="button"><a href="#">Log In</a></button></div>
        
        <div class="clear"></div>
        
        <%-- Dit is de menubalk waartussen de gebruiker kan kiezen --%>
        <nav>
        	<ul>
            	<li class="active"><a href="/">Home</a></li>
                <li><a href="#">Festival</a></li>
                <li><a href="#">Bands</a></li>
                <li><a href="#">Location</a></li>
            </ul>
        </nav>
    </header>
    <div class="clear"></div>
    <aside class="col_4 col box_shadow shadow">
        <p style="padding:5px;"></p> <%-- Hiertussen komt de tekst voor in de box links in het scherm te zetten. --%>
    </aside>
    
    <div class="content col_12 col">
        <article>
              <%@page import="java.sql.*"%>
        <%
           String geb_naam = request.getParameter("geb_naam");
           String geb_paswoord = request.getParameter("pwd");
           int resultaat;
          Connectie f = new Connectie();
          resultaat = f.OphalenGebruikers(geb_naam, geb_paswoord);
          f.close();
          if (resultaat == 1){
              response.sendRedirect("ENadmin.jsp"); //redirect naar admin gedeelte. Tijdelijke verwijzing naar index pagina
          }else{
            response.sendRedirect("ENlogin.jsp");
          }
          
       %>
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







        
            

