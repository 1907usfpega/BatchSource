function loadJoke(joke) {
  document.getElementById("setup").innerHTML=joke.setup;
  document.getElementById("punchline").innerHTML=joke.punchline;
}

function getJoke() {
  console.log("In Get Joke");
  var xhr = new XMLHttpRequest;
  xhr.onreadystatechange = function() {
    console.log("in ORSC");
    if(xhr.readyState==4 && xhr.status==200) {
      console.log(xhr.responseText);
      var joke = JSON.parse(xhr.responseText);
      loadJoke(joke);
    }
  }
  xhr.open("GET","https://official-joke-api.appspot.com/random_joke",true);
  xhr.send();
}

window.onload = function() {
  console.log("in onload");
  document.getElementById("jokesubmit").addEventListener("click",getJoke,false);
}
