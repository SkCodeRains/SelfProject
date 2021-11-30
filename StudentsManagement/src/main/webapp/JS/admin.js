function createRequestObject() {
	var tmpXmlHttpObject;
	if (window.XMLHttpRequest) {
		tmpXmlHttpObject = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return tmpXmlHttpObject;
}
var id = null;


function LoadsDatas(op, ids) {
	id = 'id=' + ids;
	LoadsData(op);
}

function LoadsData(op) {
	var http = createRequestObject();
	try {
		http.onreadystatechange = () => {
			if (http.readyState == 4 && http.status == 200) {
				document.getElementById('container').innerHTML = http.responseText;
			}
		}
		http.open('POST', op + '.jsp');
		http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		http.send(id);
		id = null;
	} catch (error) {
		console.log(error);
	}
}

function rejectReq(obj) {
	const http = createRequestObject();
	try {
		http.onreadystatechange = () => {
			if (http.readyState == 4 && http.status == 200) {
				if (http.responseText == "true") {
					document.getElementById('container').innerHTML = "<h1 class='text-danger embed-responsive'>Request rejected successfully</h1>";
					setInterval(() => { location.reload(true);}, 3000);
				}
				else
					document.getElementById('container').innerHTML = http.responseText;
			}
		}
		http.open('POST', 'RejectReq');
		http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		http.send('id=' + obj.id);
	} catch (e) {
		console.log(e)
	}
}


function acceptReq(obj) {
	const http = createRequestObject();
	try {
		http.onreadystatechange = () => {
			if (http.readyState == 4 && http.status == 200) {
				if (http.responseText == "true") {
					document.getElementById('container').innerHTML = "<h1 class='text-success embed-responsive'>Request accepted successfully</h1>";
				setInterval(() => { location.reload(true);}, 3000);
				}
				else
					document.getElementById('container').innerHTML = http.responseText;
			}
		}
		http.open('POST', 'AcceptReq');
		http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		http.send('id=' + obj.id);
	} catch (e) {
		console.log(e)
	}
}