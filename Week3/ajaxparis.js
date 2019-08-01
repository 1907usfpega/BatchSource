function loadMap(city){
    document.getElementById("name").innerHTML=city.name;
}

function getMap(){
    console.log("in get city");
    let cityID= document.getElementById("cityID").value;
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("in ORSC");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var city= JSON.parse(xhr.responseText);
            loadMap(city);
        }
    }
    //Step 3
    xhr.open("GET",'https://maps.googleapis.com/maps/api/js?key=cityID&callback=initMap'+cityID,true);
    //Step 4
    xhr.send();
}
window.onload= function(){
    console.log( "in onload");
    document.getElementById("citysubmit").addEventListener("click",getcity,false);
}
