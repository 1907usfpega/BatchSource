function loadVG(vg){
	if(vg!=null){
		document.getElementbyID("vgID").innerHTML=vg.vgID;
		document.getElementbyID("vgName").innerHTML=vg.vgName;
		document.getElementbyID("vgMetaScore").innerHTML=vg.vgMetaScore;
	}else{
		document.getElementbyID("vgName").innerHTML= "there is no record associated with that ID";
	}
	
}
function getVG(){
	console.log("in get VG bananaphone!");
	let vgid=document.getElementbyID("vgIDInput").value;
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange= function() {
		console.log("in ORSC"+ xhr.readyState);
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			var vg= JSON.parse(xhr.responseText);
			loadVG(vg);
		}
	}
	xhr.open("GET","http://localhost:8080/jsonDemo/vg?vgid=" + vgid,true);
	xhr.send();
}
function postVG(){
	console.log("in postVG");

}
window.onload= function() {
	console.log("in onload");
	document.getElementById("vgSubmitGet").addEventListener("click", getVG,false);
	document.getElementById("vgFormSubmit").addEventListener("click", postVG,false);
}