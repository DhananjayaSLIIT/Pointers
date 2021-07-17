<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/event planning.css">

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
<title>Events</title>
</head>
<body>

<div class="container">   
    <div class="topnav" id="myTopnav">
        <div>
            <a href="#"><img class="mainlogo" src="img/blog-logo.png" alt=""></a>
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
<div class="ev-event">
 <form action="" method="POST">
  <div class="event" id="left">
      <h3 class="btn">Wedding</h3>
      <a href="http://localhost:8080/Pointers/WeddingPlanning.jsp" name = "submit" value = "wedding"><img class="img1" src="img/wedding.png" alt="" ></a>
  </div>
 

  <div class="event" id="main">
      <h3 class="btn">Party</h3>
      <a href="http://localhost:8080/Pointers/PartyPlanning.jsp"><img class="img2" src="img/party.png" alt=""></a>
  </div>

  <div class="event" id="right">
      <h3 class="btn">Corporate</h3>
      <a href="http://localhost:8080/Pointers/CorporateEventPlanning.jsp"><img class="img3" src="img/corporate.png" alt=""></a>
  </div>
</form>  
 
</div>

<br><br><br>
  



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