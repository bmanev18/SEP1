function performSearch() {

    
    var filter = searchBox.value.toUpperCase();
  
 
    for (var rowI = 0; rowI < trs.length; rowI++) {
  
     
      var tds = trs[rowI].getElementsByTagName("td");
  
     
      trs[rowI].style.display = "none";
  

      for (var cellI = 0; cellI < tds.length; cellI++) {
  
   
        if (tds[cellI].innerHTML.toUpperCase().indexOf(filter) > -1) {
  

          trs[rowI].style.display = "";
  
   
          continue;
  
        }
      }
    }
  
  }
  

  const searchBox = document.getElementById('myInput');
  const table = document.getElementById("searchTable");
  const trs = table.tBodies[0].getElementsByTagName("tr");
  
  
  searchBox.addEventListener('keyup', performSearch);
  


  

