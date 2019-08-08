// import { loadavg } from "os";

function on() {
    document.getElementById("overlay").style.display = "block";
}

function off() {
    document.getElementById("overlay").style.display = "none";
}

function logIn() {
    document.getElementById("loader");
    console.log("login clicked");
}

//clear button to clear all user input
function clearInput() {
    document.getElementById('200').value = "";
    console.log("clear");

}

var clearBtn = document.getElementById('200');
clearBtn.addEventListener("click", clearInput);
//clear event logic done




//submit request
// function submitInput() {
//     var ourRequest = new XMLHttpRequest();
//     var javaData = document.getElementsByClassName("inp");
//     console.log(javaData);
// ourRequest.open('GET', 'server path goes here');
// ourRequest.onload = function() {

// };
// ourRequest.send();
// };

var subBtn = document.getElementById('100');
subBtn.addEventListener("click", function() {
    // var ourRequest = new XMLHttpRequest();
    var javaData = document.getElementsByClassName("inp");
    console.log(javaData.value);
});







window.onload = function() {
    console.log("onload ready");
    //below lines need fixing, from vg.js
    // document.getElementById('submitbuttonID').addEventListener("click", submitInput function, false);
    // document.getElementById('submitbuttonID').addEventListener("click", submitInput function, false);

}