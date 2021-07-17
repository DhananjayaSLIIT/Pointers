<%@page import="package_Classes.Wedding"%>
<%@page import="package_Interfaces.InterfacesWedImpl"%>
<%@page import="package_Interfaces.InterfaceWedding"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="wedding.css">

<script>
    function myFunction() {
      var x = document.getElementById("myTopnav");
      if (x.className === "topnav") {
        x.className += " responsive";
      } else {
        x.className = "topnav";
      }
    }
</script>
<title>Summary</title>
</head>
<body>
<div class="container">
    <div class="topnav" id="myTopnav">
        <div>
            <a href="#l"><img class="mainlogo" src="/WEB-INF/img/blog-logo.png" alt=""></a>
        </div>
        <div class="topnavlist">
        <a href="#">Home</a>
        <a href="#">Services</a>
        <a href="#">Galler</a>
        <a href="#">Contact Us</a>
        <a href="#">Login / Register</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
          <i class="fa fa-bars"></i>
        </a>
    </div>
    </div>
    


<!----------------------------------------------------------------------------------------------------------------------------------------->
    <div class="middle">
      <form action="Getbooking" method="POST" class="full_wedding">
        <h3 class="h3">Planning summary</h3>

        
        <table class="table"  color="goldenrod">
        <tr>
        
        <td>Wedding date :</td>
        <td><%=request.getAttribute("date")%></td>
        </tr>
        
        <tr>
        <td>Venue :</td>
        <td><%=request.getAttribute("venue")%></td>
        </tr>
        
        <tr>
        <td>Time :</td>
        <td><%=request.getAttribute("time")%></td>
        </tr>
        
        <tr>
        <td>Pax count :</td>
        <td><%=request.getAttribute("pax_count")%></td>
        </tr>
        
        <tr>
        <td>Theme :</td>
        <td><%=request.getAttribute("theme")%></td>
        </tr>
        
        <tr>
        <td>Bride & Groom :</td>
        <td><%=request.getAttribute("dress")%></td>
        </tr>
        
        <tr>
        <td>Flower Decorations :</td>
        <td><%=request.getAttribute("decoration")%></td>
        </tr>
        
        <tr>
        <td>Photography & Videography :</td>
        <td><%=request.getAttribute("photo")%></td>
        </tr>
        
        <tr>
        <td>Wedding car rental :</td>
        <td><%=request.getAttribute("carrental")%></td>
        </tr>
        
        <tr>
        <td>Music & Entertainment :</td>
        <td><%=request.getAttribute("entertain")%></td>
        </tr>
        
        <tr>
        <td>Poruwa ceremony :</td>
        <td><%=request.getAttribute("poruwa")%></td>
        </tr>
        
        <tr>
        <td>Wedding Cake Designs :</td>
        <td><%=request.getAttribute("cake")%></td>
        </tr>
        
        
        <tr>
        <td>Wedding Card Designs :</td>
        <td><%=request.getAttribute("card")%></td>
        </tr>
        
        </table>
        
        <br><br>
         &nbsp;&emsp; &emsp; &emsp;<label>Budget  :</label><label><%=request.getAttribute("budget")%></label>
      	
        
      <button class="sumbtn" type="submit" name = "submit" value = "finish">Finish Planning</button>
      <br><br>
      <button class="sumbtn" type="submit" name = "submit" value = "update">Update</button>
      <br><br>
      <button class="sumbtn" type="submit" name = "submit" value = "cancel">Cancel Booking</button> 
	  <br><br><br>
        

      </form>
      
       


    </div>




<!----------------------------------------------------------------------------------------------------------------------------------------->
    <div class="foot">
        <footer>  <font class="copyright"> Copyright 2020 © POINTER FOR PLANNERS. All Rights Reserved. &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <br> <br><a href="about us.html" > About Us</a>	&nbsp &nbsp <a href="feedback.html" > Feedback</a>	&nbsp &nbsp <a href="contactus.html" > Contact Us</a>
                                            
                                                                                    
                                        <div class="social">
                                            
                                                <a href="www.fb.com"><img src="img/fb.png"> </a>
                                                <a href="www.instagram.com"><img src="img/insta.png"> </a>
                                                <a href="www.twitter.com"><img src="img/twitter.png"> </a>
                                                <a href="www.whatsapp.com"><img src="img/whatsapp.png"> </a>
                                                <a href="www.gmail.com"><img src="img/gmail.png"> </a>
                                                
                                                
                                        </div>
        </footer>
        
    </div>
  </div>

</body>
</html>