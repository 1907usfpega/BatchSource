function loadpkmn(pokemon){
    document.getElementById("name").innerHTML=pokemon.name;
    document.getElementById("uwu").innerHTML=pokemon.types[0].name;
    document.getElementById("sprite").setAttribute("src","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemon.id+".png");
}

function getpkmn(){
    let pokemonID=document.getElementById("pkID").value;
    //step1
    var xhr = new XMLHttpRequest();
    //step2
    xhr.onreadystatechange= function(){
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var pokemon = JSON.parse(xhr.responseText);
            loadpkmn(pokemon);
        }
    }
    //step3
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+pokemonID, true);
    //step4
    xhr.send();
}

window.onload=function (){
    document.getElementById("pokesubmit").addEventListener("click", getpkmn, false);
    document.getElementById("pkid").addEventListener("keydown", function (e) {
        if (e.keyCode === 13) {  //checks whether the pressed key is "Enter"
            getpkmn();
        }
    });
    
    document.getElementById("sprite").addEventListener("mouseenter", shiny, false);
    document.getElementById("sprite").addEventListener("mouseleave", def, false);
}

function shiny(event){
    let element=event.currentTarget;
    let pokemonID=document.getElementById("pkID").value;
    element.setAttribute("src","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+pokemonID+".png")
}
function def(event){
    let element=event.currentTarget;
    let pokemonID=document.getElementById("pkID").value;
    element.setAttribute("src","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemonID+".png")
}