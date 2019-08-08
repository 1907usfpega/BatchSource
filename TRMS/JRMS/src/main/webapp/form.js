function logIn() {
    document.getElementById("loader");
    console.log("login clicked");
}
// var lastName = document.getElementById('lName').value;
// var firstName = document.getElementById('fName').value;
// var email = document.getElementById('email').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;
// var lastName = document.getElementById('').value;


var formUrl = 'file:///Users/terryim/Desktop/OnewaytoHomework/ImT/TRMS/JRMS/src/main/webapp/WEB-INF/form.html';


function postForm() {
    console.log("in postForm");

    let vg = document.getElementById("formid").submit;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log("in ORSC " + xhr.readyState);
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST", formUrl, true);
    var trash = jsonBuilder();
    xhr.send(trash);

}

function jsonBuilder() {
    var elements = document.getElementById("formid").elements;
    var obj = {};
    for (var i = 0; i < elements.length - 1; i++) {
        var item = elements.item(i);
        obj[item.name] = item.value;
        console.log(obj);


    }
    var json = JSON.stringify(obj);
    console.log(json);
    return json;
}

function test() {
    console.log(lastName + firstName);
}