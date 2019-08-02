function bubble(event) {
    let element = event.currentTarget;
    element.style.background = "green";
    alert(element.id);
}

window.onload = function () {
    document.getElementById("A").addEventListener("click", bubble, true)
}

window.onload = function () {
    document.getElementById("B").addEventListener("click", bubble, true)
}

window.onload = function () {
    document.getElementById("C").addEventListener("click", bubble, true)
}

window.onload = function () {
    document.getElementById("D").addEventListener("click", bubble, true)
}