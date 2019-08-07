function loadPokemon(pokemon) {
    document.getElementById("name").innerHTML = pokemon.id+" "+pokemon.name;
    document.getElementById("height").innerHTML = "height: "+pokemon.height+"<br>weight: "+pokemon.weight;
    document.getElementById("img").setAttribute("src", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.id + ".png");
    //document.getElementsByClassName("sprite").setAttribute("src", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.id + ".png");
    //document.getElementsByTagName(h3).innerHTML = pokemon.name;
}

function getPokemon() {
    console.log("in get pokemon");
    let pokemonID = document.getElementById("pkID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    
    //Step 2
    xhr.onreadystatechange = function () {
        console.log("in ORSC");
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            var pokemon = JSON.parse(xhr.responseText);
            loadPokemon(pokemon);
        }//end if
    }//end function
    
    //Step 3
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + pokemonID, true);
    
    //Step 4
    xhr.send();
}//end getPokemon

window.onload = function () {
    console.log("in onload")
    document.getElementById("pokesubmit").addEventListener("click", getPokemon, false);
    document.getElementById("pokesubmit2").addEventListener("click", getPokemon2, false);
    document.getElementById("img").addEventListener("click", turnaround, false);
}//end function

function turnaround(event) {
    let element = event.getElement;
    let pokemonID = document.getElementById("pkID").value;
    if (document.getElementById("img").getAttribute("src") == "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/" + pokemonID + ".png") {
        document.getElementById("img").setAttribute("src", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemonID + ".png");
    } else {
        document.getElementById("img").setAttribute("src", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/" + pokemonID + ".png");
    }
}










function loadPokemon2(pokemon) {
    document.getElementById("name2").innerHTML = pokemon.id+" "+pokemon.name;
    document.getElementById("height2").innerHTML = "height: "+pokemon.height+"<br> weight: "+pokemon.weight;
    document.getElementById("img2").setAttribute("src", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.id + ".png")
}

function getPokemon2() {
    console.log("in get pokemon 2");
    let pokemonID = document.getElementById("pkID2").value;
    //Step 1
    var xhr = new XMLHttpRequest();

    //Step 2
    xhr.onreadystatechange = function () {
        console.log("in ORSC");
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            var pokemon = JSON.parse(xhr.responseText);
            loadPokemon2(pokemon);
        }//end if
    }//end function

    //Step 3
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + pokemonID, true);

    //Step 4
    xhr.send();
}//end getPokemon2








