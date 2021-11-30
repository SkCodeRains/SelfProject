
// <-- http request object for IE and others creation-
function createRequestObject() {
	var tmpXmlHttpObject;
	if (window.XMLHttpRequest) {
		tmpXmlHttpObject = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return tmpXmlHttpObject;
}
var http = createRequestObject();
var id = 'sk';
/* creation done--->


*/




// default processResponse single tag value
function processResponse() {
	if (http.readyState == 4) {
		var response = http.responseText;
		document.getElementById(id).innerHTML = response;
	}
}
//End ---------->




//index.jsp select funtions operations....


function EjbSelector(path) {
	if (path != "") {
		document.getElementById('second').setAttribute('CLASS', 'listBut2');
		FirstProgram('second', path);
	}
}

function FirstProgram(id, ref) {
	this.id = id;
	http.open('get', ref);
	http.onreadystatechange = processResponse;
	http.send(null);

}
//End ---------->




//ourfirstAccount.html   called function retrive data from getAccount.jsp
function EjbGetAccount(id) {
	this.id = id;
	uid = document.getElementById("uid").value;
	http.open('get', 'Ejbs/getAccount.jsp?uid=' + uid);
	http.onreadystatechange = processResponse;
	http.send(null);
}

//End ---------->







































