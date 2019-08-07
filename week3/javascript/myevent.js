function bubble (event){
    let element= event.currentTarget;
    element.style.backgroundColor="green";
    alert(element.id);
}

function cry(event){
    let element=event.currentTarget;
    
    element.style.color="hotpink";
    element.style.fontFamily="Comic Sans Ms";
    element.style.fontSize="55px";
}
function cry(event){
    let element=event.currentTarget;
    
    element.style.color="yellow";
    element.style.fontFamily="san-serif";
    element.style.fontSize="23px";
}


//true root to node (capturing)
//false node to root ()
window.onload=function(){
    document.getElementById("a").addEventListener("click",bubble,true);
    document.getElementById("b").addEventListener("click",bubble,true);
    document.getElementById("c").addEventListener("click",bubble,true);
    document.getElementById("d").addEventListener("click",bubble,true);

    document.getElementById("d").addEventListener("mouseenter", cry, false);
    document.getElementById("d").addEventListener("mouseleave", uncry, false);
}