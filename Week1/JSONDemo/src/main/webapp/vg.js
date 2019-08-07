function loadVG(vg){
	if (vg!=null){
		document.getElementById("vgid").innerHTML=vg.vgID;
		document.getElementById("vgName").innerHTML=vg.vgName;
		document.getElementById("vgMetaScore").innerHTML=vg.vgMetaScore;
	}
	else{
		document.getElementById("vgName").innerHTML="there is no element by this id";
	}
}
function getVg(){
	let vgid=document.getElementById("vgIdInput").value;
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var vg=JSON.parse(xhr.responseText);
			loadVG(vg);
		}
	}
	xhr.open("GET","http://localhost:8080/JSONDemo/vg?vgid="+vgid,true);
	xhr.send();
}

function postVg(){
	
}
window.onload=function(){
	document.getElementById("vgSubmitGet").addEventListener("click",getVg,false);
	//document.getElementById("vgFormSubmit").addEventListener("click",postVg,false);
	
}