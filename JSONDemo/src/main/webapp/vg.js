function loadVG(vg) {
	if (vg != null) {
		document.getElementById("vgID").innerHTML = "Game ID: "+vg.vgID;
		document.getElementById("vgName").innerHTML = "Game Name: "+vg.vgName;
		document.getElementById("vgMetaScore").innerHTML = "Game MetaScore: "+ vg.vgMetaScore;
	}
	else {
		document.getElementById("vgName").innerHTML = "There is no record associated with that ID."
		document.getElementById("vgID").innerHTML = "";
		document.getElementById("vgMetaScore").innerHTML = "";

	}
}//end loadVG

function getVG() {
	console.log(" in get VG bananaphone!")
	let vgid = document.getElementById("vgIDInput").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		console.log(" in ORSC " + xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var vg = JSON.parse(xhr.responseText);
			loadVG(vg);
		}//end if
	}//end function
	xhr.open("GET", "http://localhost:8080/JSONDemo/vg?vgid=" + vgid, true);
	xhr.send();
}//end getVG

function postVG() {
	console.log("in postVG");

	//let vg = document.getElementById("vgForm").submit;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		console.log("in ORSC " + xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
		}
	}
	xhr.open("POST", "http://localhost:8080/JSONDemo/vg", true);
	var trash = jsonBuilder();
	xhr.send(trash);
}

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

window.onload = function () {
	console.log("in onload");
	document.getElementById("vgSubmitGet").addEventListener("click", getVG, false);
	document.getElementById("vgFormSubmit").addEventListener("click",postVG,false);
}
