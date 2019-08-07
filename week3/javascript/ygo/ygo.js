function getcard(){
    let cardID=document.getElementById("pkID").value;
    //step1
    var xhr = new XMLHttpRequest();
    //step2
    xhr.onreadystatechange= function(){
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var pokemon = JSON.parse(xhr.responseText);
            loadpkmn(card);
        }
    }
    //step3
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+cardID, true);
    //step4
    xhr.send();
}

function loadcard(card){
    document.getElementById("name").innerHTML=card.name;
    document.getElementById("sprite").setAttribute("src","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemon.id+".png");
}