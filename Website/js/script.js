/*
$.get("xml/person.xml", function (xml, status) {
    var firstname = $(xml).find("firstname");
    var displayName = $(firstname[0]).text();
    $("#textField1").html(displayName);
});

$.get("xml/mates.xml", function(xml, status){
    var firstname=$(xml).find("firstname");
    var lastname=$(xml).find("lastname");
    var birthday=$(xml).find("birthday");
    var nationality=$(xml).find("nationality");
    var email=$(xml).find("email");
    var eyeColor=$(xml).find("eyeColor");
    var displayfitst = $(firstname[0]).text();
    var displayName = $(firstname[0]).text();
    var displayName = $(firstname[0]).text();
    var displayName = $(firstname[0]).text();
    var displayName = $(firstname[0]).text();
    var displayName = $(firstname[0]).text();
    $("#textField1").html(displayfitst);
});
*/
/*
$.get("xml/roomlist.xml", function(xml, status){
 var txt="<table><tr><th>RoomNo</th><th>RoomType</th></tr>";
 $(xml).find("rooms").each(function(){
    var roomNo=$(this).find("roomNumber").text();
    var roomType=$(this).find("roomType").text();
    txt += "<tr>" + "<td>" + roomNo +"</td>" + "<td>" + roomType + "</td>" + "</tr>";

 });
 txt += "</table>";
 $("#textField1").html(txt);
});
*/
/*
$.get("xml/reservationList.xml", function(xml, status){
 var txt1="<table><tr><th>RoomNo</th><th>RoomType</th><th>Price</th><th>Arrival</th><th>Departure</th></tr>"
 $(xml).find("reservations").each(function(){
    var roomNo1=$(this).find("roomNumber").text();
    var roomType1=$(this).find("roomType").text();
    var price=$(this).find("price").text();
    $(xml).find("checkInDate").each(function(){
        var checkIn=$(this).find("day").text() + "-" + $(this).find("month").text() + "-" +  $(this).find("year").text();
    $(xml).find("checkOutDate").each(function(){
        var checkOut=$(this).find("day").text() + "-" + $(this).find("month").text() + "-" +  $(this).find("year").text();
    $(xml).find("checkOutDate").each(function(){
    txt1 +="<tr>" + "<td>" + roomNo1 +"</td>"+ "<td>" + roomType1 +"</td>"+ "<td>" + price +"</td>"+ "<td>" + checkIn +"</td>"+ "<td>" + checkOut +"</td>" + "</tr>";
 });   
 });   
 });
 });
 txt1 += "</table>";
 $("#textField2").html(txt1);
});
*/
$.get("xml/reservationList2.xml", function(xml, status){
    var txt1="<table><tr><th>RoomNo</th><th>RoomType</th><th>Price</th><th>Arrival</th><th>Departure</th></tr>"
    $(xml).find("reservations").each(function(){
       var roomNo1=$(this).find("roomNumber").text();
       var roomType1=$(this).find("roomType").text();
       var price=$(this).find("pricePerNight").text();
       $(xml).find("checkInDate").each(function(){
           var checkIn=$(this).find("day").text() + "-" + $(this).find("month").text() + "-" +  $(this).find("year").text();
       $(xml).find("checkOutDate").each(function(){
           var checkOut=$(this).find("day").text() + "-" + $(this).find("month").text() + "-" +  $(this).find("year").text();
       $(xml).find("checkOutDate").each(function(){
       txt1 +="<tr>" + "<td>" + roomNo1 +"</td>"+ "<td>" + roomType1 +"</td>"+ "<td>" + price +"</td>"+ "<td>" + checkIn +"</td>"+ "<td>" + checkOut +"</td>" + "</tr>";
    });   
    });   
    });
    });
    txt1 += "</table>";
    $("#textField3").html(txt1);
   });
   
   
   




