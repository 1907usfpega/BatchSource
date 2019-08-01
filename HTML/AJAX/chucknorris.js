function loadMovie(movie)
{
    document.getElementById("jokestring").innerHTML = movie.value.joke;
}

function getMovie()
{
    console.log("In get Pokemon");
    let firstName = "", lastName = "";
    if(document.getElementById("firstNameText").value == "")
    {
        firstName = "Chuck";
    }
    else
    {
        firstName = document.getElementById("firstNameText").value;
    }
    
    if(document.getElementById("lastNameText").value == "")
    {
        lastName = "Norris";
    }
    else
    {
        lastName = document.getElementById("lastNameText").value;
    }
    //Step 1
    var xhr = new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function()
    {
        console.log("In ORSC");
        if(xhr.readyState == 4 && xhr.status == 200)
        {
            console.log(xhr.responseText);
            var movie = JSON.parse(xhr.responseText);
            loadMovie(movie);
        }
    }
    //Step 3exclude=[nerdy]
    xhr.open("GET", "http://api.icndb.com/jokes/random?exclude=[nerdy]&firstName="+firstName+"&lastName="+lastName, true);

    //Step 4
    xhr.send();
}
window.onload = function()
{
    console.log("in onload");
    document.getElementById("jokesubmit").addEventListener("click", getMovie, false);
    //look into querySelector
}