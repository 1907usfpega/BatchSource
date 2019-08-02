function bubble(event){
  let element = event.currentTarget;
  element.style.backgroundColor = "green";
  alert("You chose " + element.id);
}

// window.onload = function() {
//   document.getElementByTagName("Rock").addEventListener("click", bubble, true);
//   document.getElementByTagName("Paper").addEventListener("click", bubble, true);
//   document.getElementByTagName("Scissors").addEventListener("click", bubble, true);
//   document.getElementByTagName("Lizard").addEventListener("click", bubble, true);
//   document.getElementByTagName("Spock").addEventListener("click", bubble, true);
// }

window.onload = function() {
  document.getElementById("A").addEventListener("click",bubble,true);
  document.getElementById("B").addEventListener("click",bubble,true);
  document.getElementById("C").addEventListener("click",bubble,true);
  document.getElementById("D").addEventListener("click",bubble,true);
}

// window.onload = function() {
//   document.getElementById("B").addEventListener("click",bubble,true);
// }
//
// window.onload = function() {
//   document.getElementById("C").addEventListener("click",bubble,true);
// }
//
// window.onload = function() {
//   document.getElementById("D").addEventListener("click",bubble,true);
// }
