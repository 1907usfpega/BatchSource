function bubble(event){
    let element=event.currentTarget;
    element.style.backgroundColor="green";
    alert(element.id);
}

window.onload= function(){
    document.getElementById("A").addEventListener("click",bubble,true);
    document.getElementById("B").addEventListener("click",bubble,true);
    document.getElementById("C").addEventListener("click",bubble,true);
    document.getElementById("D").addEventListener("click",bubble,true);
}