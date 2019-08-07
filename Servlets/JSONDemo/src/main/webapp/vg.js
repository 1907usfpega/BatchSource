function loadVG(vg) {
	if(vg !== null) {
		document.getElementById("vgID").innerHTML="ID: " + vg.vgID;
		document.getElementById("vgName").innerHTML="Nombre: " + vg.vgName;
		document.getElementById("vgMetaScore").innerHTML="Partitura del MetaCritic: " + vg.vgMetaScore;
	} else {
		document.getElementById(vgName).innerHTML = "No hay registro asociado con questo ID";
	}
}

function getVG() {
	console.log(" en saca VG bananafono!");
	let vgid = document.getElementById("vgIDInput").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("en ORSC " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var vg = JSON.parse(xhr.responseText);
			loadVG(vg);
		}
	}
	xhr.open("GET","http://localhost:8080/JSONDemo/vg?vgid=" + vgid, true);
	xhr.send();
}

function postVG() {
	console.log("en postVG");
}

window.onload = function() {
	console.log("en onload");
	document.getElementById("vgSubmitGet").addEventListener("click",getVG,false);
	// document.getElementById("vgFormSubmit").addEventListener("click",postVG,false);
}
