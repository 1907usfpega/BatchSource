var btn = document.getElementById("btn");
btn.addEventListener("click", function() {
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'file:///Users/terryim/Desktop/OnewaytoHomework/ImT/TRMS/JRMS/src/main/webapp/WEB-INF/form.html');
    ourRequest.onload = function() {
        var ourData = JSON.parse(ourRequest.responseText);
        console.log(ourData[0]);
    };
    ourRequest.send();
    //ajax is done
})

//how to respond to events from html side
//create a variable that points towards the html element


//below is how the JSON object is constructed from the html and set to a string
function jsonBuilder() {
    var elements = document.getElementById("vgForm").elements;
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