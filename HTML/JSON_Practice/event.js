function bubble(event)
{
    let element = event.currentTarget;
    element.style.backgroundColor="green";
    alert(element.id);
}

function rps(event)
{
    let element = event.currentTarget;
    let outputResult = document.getElementById("result");
    let compChoice = Math.floor(Math.random()*3);
    if(element.value == compChoice)
    {
        //alert("Draw");
        outputResult.innerHTML = "Draw!";
    }
    else if(element.value == 0 && compChoice == 1)
    {
        //alert("Computer Wins With Paper versus Player's Rock!");
        outputResult.innerHTML = "Computer Wins With Paper versus Player's Rock!";
    }
    else if(element.value == 1 && compChoice == 2)
    {
        //alert("Computer Wins With Scissors versus Player's Paper!");
        outputResult.innerHTML = "Computer Wins With Scissors versus Player's Paper!";
    }
    else if(element.value == 2 && compChoice == 0)
    {
        //alert("Computer Wins With Rock versus Player's Scissors!");
        outputResult.innerHTML = "Computer Wins With Rock versus Player's Scissors!";
    }
    else if(element.value == 1 && compChoice == 0)
    {
        //alert("Player Wins With Paper versus Computer's Rock!");
        outputResult.innerHTML = "Player Wins With Paper versus Computer's Rock!";
    }
    else if(element.value == 2 && compChoice == 1)
    {
        //alert("Player Wins With Scissors versus Computer's Paper!");
        outputResult.innerHTML = "Player Wins With Scissors versus Computer's Paper!";
    }
    else if(element.value == 0 && compChoice == 2)
    {
        //alert("Player Wins With Rock versus Computer's Scissors!");
        outputResult.innerHTML = "Player Wins With Rock versus Computer's Scissors!";
    }

}

window.onload = function()
{
    document.getElementById("A").addEventListener("click", rps, false);
    document.getElementById("B").addEventListener("click", rps, false);
    document.getElementById("C").addEventListener("click", rps, false);
    document.getElementById("D").addEventListener("click", bubble, false);
    document.getElementById("choice").addEventListener("click", rps, false);
}