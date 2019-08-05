  function loadPokeman(pokeman) {
  document.getElementById("name").innerHTML=pokeman.name;
}

function getPokeman() {
  console.log("in get pokeman")
  let pokemanID=document.getElementById("pkID").value;
  // STEP 1
  var xhr = new XMLHttpRequest();
  // STEP 2
  xhr.onreadystatechange = function(){
    console.log("in ORSC");
    if(xhr.readyState==4 && xhr.status==200) {
      console.log(xhr.responseText);
      var pokeman = JSON.parse(xhr.responseText);
      loadPokeman(pokeman);
    }
  }
  // STEP 3
  xhr.open("GET","https://pokeapi.co/api/v2/pokemon/"+pokemanID,true);
  // STEP 4
  xhr.send();
}

window.onload = function() {
  console.log("in onload");
  document.getElementById("pokesubmit").addEventListener("click",getPokeman,false);
}
