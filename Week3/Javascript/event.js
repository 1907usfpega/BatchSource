function bubble(event) {
    let element = event.currentTarget;
    element.style.backgroundColor = "green";
    alert(element.id);
}

function cry(event){
    let element = event.currentTarget;
    element.style.color = "hotpink";
    element.style.fontFamily = "Comic Sans MS";
    element.style.fontSize = "55px";
    //alert(element.id);
}
function uncry(event){
    let element = event.currentTarget;
    element.style.color = "black";
    element.style.fontFamily = "Arial";
    element.style.fontSize = "14px";
    //alert(element.id);
}

function yellow(event){
    let element = event.currentTarget;
    element.style.color = "purple";
    element.style.fontFamily = 'Comic Sans MS';
    element.style.fontSize = "172px";
}



//true root to node (capturing)
//false node to root ()
window.onload = function () {
    document.getElementById("A").addEventListener("click", bubble, false);
    document.getElementById("B").addEventListener("click", bubble, false);
    document.getElementById("C").addEventListener("click", bubble, false);
    document.getElementById("D").addEventListener("click", bubble, false);
    

    document.getElementById("A").addEventListener("mouseenter",yellow,true);
    document.getElementById("B").addEventListener("mouseleave",uncry,false);
    document.getElementById("C").addEventListener("mouseenter",cry,false);
    
    document.getElementById("E").addEventListener("mouseenter",yellow,true);
    document.getElementById("E").addEventListener("mouseleave",uncry,true);
}