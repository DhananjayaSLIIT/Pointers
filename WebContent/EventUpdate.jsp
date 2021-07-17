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
<title>Update Event</title>
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
    
    <% 
    	String date = (String)request.getAttribute("date");
    	String time = (String)request.getAttribute("time");
    	int pcount = (Integer)request.getAttribute("pax_count");
    	String furniture = (String)request.getAttribute("furniture");
    	String description = (String)request.getAttribute("description");
    %>
    


<!----------------------------------------------------------------------------------------------------------------------------------------->
    <div class="middle">
    <div class="middle">
      <form action="UpdateEventServlet" method = "POST" class="full_wedding">
        <h3>Corporate Event Planning</h3>

		<label for="cparty">Event Date :</label>
        <input type="date" id="wed_day" name="edate" value = "<%=date%>"> <br><br>


        <label >Event Type &nbsp &nbsp  :</label>

          <select name = "etype">
            <option value="None"> --select event--</option>
            <option value="Conference event"> Conferences</option>
            <option value="Seminar event">Seminars</option>
            <option value="Trade Show">Trade Shows / Expos</option>
            <option value="Product Launches">Product Launches</option>
            <option value="Other">other</option>
            
          </select> &emsp; &emsp;<br>
          <p style="font-size: small;">*If you selecting other option pleace mention some details about the event in the descriptoint box bellow</p>
          <br>

          <label for="venue">Venue &nbsp &nbsp  :</label>

          <select name = "venue">
            <option style="display: none;"> --select venue--</option>
            <option value="Oak Ray Regency">Oak Ray Regency</option>
            <option value="Earls Regency">Earl's Regency</option>
            <option value="Amaya Hills">Amaya Hills</option>
            <option value="OZO">OZO</option>
            <option value="Corporation">Your corporation</option>
            <option value="other">other</option>
           
          </select> &emsp; &emsp; <a href="#">View Venues and Rates</a> <br><br>

         <%if(time.equals( "Day function")){ %>
          <input type="radio" id="" name="time" value="Day function" checked/>
          <label for="day">Day Function</label> &nbsp &nbsp &nbsp
          <input type="radio" id="" name="time" value="Evening function">
          <label for="evening">Evening Function</label><br><br>
		<%}else if(time.equals("Evening function")){ %>
		  <input type="radio" id="" name="time" value="Day function" checked/>
          <label for="day">Day Function</label> &nbsp &nbsp &nbsp
          <input type="radio" id="" name="time" value="Evening function" checked/>
          <label for="evening">Evening Function</label><br><br>
        <%} %>
      

          <label for="count">Pax count</label>
          <input type="number" name="pax_count" value="<%=pcount%>"><br><br>

		<%if(furniture.equals("Yes")) {%>	
          <input type="checkbox" id="" name="furniture" value="Yes" checked/>
          <label for="">Furniture Rentals & arrangement</label><br><br>
        <%}else{ %>
        <input type="checkbox" id="" name="furniture" value="Yes">
          <label for="">Furniture Rentals & arrangement</label><br><br>
        <%} %>  

          <label for="">Tell us more about your Event</label><br>
          &emsp; &emsp; &emsp; &emsp;<textarea name="description" id="theme_des" cols="50" rows="15"><%=description %></textarea>
          <br><br><br>
        
          
        <button class="sumbtn" type="submit" name = "submit" value = "submit">Add a booking</button>
        <br><br><br>

      </form>

    </div>  
      
      
    


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