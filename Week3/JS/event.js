function bubble(event){
    let element= event.currentTarget;
    element.style.backgroundColor="green";
    alert(element.id);
}

window.onload= function(){
    document.getElementById("A").addEventListener("click",bubble,false);
    document.getElementById("B").addEventListener("click",bubble,false);
    document.getElementById("C").addEventListener("click",bubble,false);
    document.getElementById("D").addEventListener("click",bubble,false);
}