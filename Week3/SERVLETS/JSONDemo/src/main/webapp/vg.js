function loadVG(vg){
	if(vg!=null){
		document.getElementById("vgID").innerHTML=vg.vgID;
		document.getElementById("vgName").innerHTML=vg.vgName;
		document.getElementById("vgMetaScore").innerHTML=vg.vgMetaScore;
	}else{
		document.getElementById("vgName").innerHTML= "There is no record associated with that ID";
	}
}
function getVG(){
	console.log( " in get VG bananaphone!");
	let vgid=document.getElementById("vgIDInput").value;
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange= function() {
		console.log("in ORSC "+ xhr.readyState );
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			var vg= JSON.parse(xhr.responseText);
			loadVG(vg);
		}
	}
	xhr.open("GET","http://localhost:8080/JSONDemo/vg?vgid=" + vgid,true);
	xhr.send();
}
function postVG(){
	console.log("in postVG");

}
window.onload= function() {
	console.log("in onload");
	document.getElementById("vgSubmitGet").addEventListener("click",getVG,false);
	//document.getElementById("vgFormSubmit").addEventListener("click", postVG,false);
}