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

<title>Wedding Planning</title>
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
    <div class="middle">
      <form action="AddWedding" method="POST" class="full_wedding">
        <h3>Wedding Planning</h3>

        <label for="wed_day">Wedding Date :</label>
        <input type="date" id="wed_day" name="date" class="inputarea"/> <br><br><br>

          <label for="venue">Venue &nbsp &nbsp  :</label>

          <select name="venue" class="inputarea">
            <option value = "None" > --select venue--</option>
            <option value="Oak Ray Regency">Oak Ray Regency</option>
            <option value="Earls Regency">Earl's Regency</option>
            <option value="Amaya Hills">Amaya Hills</option>
            <option value="OZO">OZO</option>
          </select> &emsp; &emsp; <br><br><a href="#">View Venues and Rates</a> <br><br>

          <input type="radio" id="" name="time" value="Day function">
          <label for="day">Day Function</label> &nbsp &nbsp &nbsp
          <input type="radio" id="" name="time" value="Evening function">
          <label for="evening">Evening Function</label><br><br>

          <label for="count">Pax count</label>
          <input type="number" name="pax_count" class="inputarea"><br><br><br>

          <label for="theme">Theme colour :</label>
          <input type="text" name="theme" class="inputarea"><br><br>
          <br><br>

          <label for="dress">Bride & Groom dressing :</label>

          <select name = "dress" class="inputarea">
            <option value="None"> --select bride & groom dressing--</option>
            <option value="Srilankan traditional">Srilankan traditional</option>
            <option value="Traditional Indian">Traditional Indian</option>
            <option value="European">European</option>
          </select> &emsp; &emsp;<br><br>  
          
          
          <input type="checkbox" id="decorations" name="decoration" value="Yes">
          <label for="decorations">Flower decorations</label><br><br>

          <input type="checkbox" id="photo" name="photo" value="Yes">
          <label for="photo">Photography & Videography :</label><br><br><br>

          <label for="">Wedding car rental : </label>
          <select name = "cars" class="inputarea">
            <option value="None"> --select--</option>
            <option value="Limousine">Limousine</option>
            <option value="BMW M3">BMW M3</option>
            <option value="Toyota Corolla">Toyota Corolla</option>
          </select> &emsp;<br><br> <a href="#">View cars</a><br><br>

        
          <label for="music">Music & Entertainment :</label>
			<select name = "entertain" class="inputarea">
            <option value="None"> --select--</option>
            <option value="Band">Music Band</option>
            <option value="DJ">DJ</option>
            <option value="Dancinggroup">Dancing Group</option>
          </select></label><br><br><br>

           <input type="checkbox" id="" name="poruwa" value="Yes">
           <label for="poruwa">Poruwa ceremony :</label><br><br><br>

  
           <label for="card">Wedding Cake Designs  :</label>

           <select class="inputarea" name = "cake">
            <option value="None"> --select cake design--</option>
            <option value="Lemon and Strawberry">Lemon and Strawberry</option>
            <option value="Red Velvet">Red Velvet</option>
            <option value="Black Forest">Black Forest</option>
 
          </select> &emsp;<br><br> <a href="#">View cake designs</a><br><br>

           
           <label for="card">Wedding card :</label>

           <select class="inputarea" name = "card">
            <option value="None"> --select cake design--</option>
            <option value="Pocket Wedding Invitation">Pocket Wedding Invitation</option>
            <option value="Photo Wedding Invitation">Photo Wedding Invitation</option>
            <option value="Letterpress Wedding Invitation">Letterpress Wedding Invitation</option>
          </select> &emsp;<br><br> <a href="#">View cake designs</a><br><br>

           



           <label for="">Tell us more about your Dream</label><br>
          &emsp;&emsp; &emsp; &emsp; &emsp;<textarea name="description" id="theme_des" cols="50" rows="15"></textarea>
          <br><br><br><br>
          
         <button class="sumbtn" type="submit" name = "submit">Add a booking</button>  
         
          <br><br><br> 
          
         


           

      </form>
      
      
    
}

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