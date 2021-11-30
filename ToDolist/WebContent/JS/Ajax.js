/**
 * 
 */
function createRequestObject() {
	var tmpXmlHttpObject;
	if (window.XMLHttpRequest) {
		tmpXmlHttpObject = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return tmpXmlHttpObject;
}


http = createRequestObject();

function addTask() {
	http = createRequestObject();
	try {
		http.open('get', '../addTask', true);
		http.onload = () => {
			var response = http.responseText;
			document.getElementById('todo').innerHTML = response;
			runAble();
		}
		http.send(null);
	} catch (error) {
		alert(error);
	}

}



function editUpdateTask(id, text, DivID) {
	try {
		divs = document.createElement("DIV");
		divs.setAttribute("id", "EditeDiv");
		document.body.insertBefore(divs, document.body.firstChild);
		http = createRequestObject();
		http.open('get', 'UpdatePanel.jsp?id=' + id + '&data=' + text + '&divId=' + DivID, true);
		http.onload = () => {
			var response = http.responseText;
			document.getElementById('EditeDiv').innerHTML = response;
		}
		http.send();
	} catch (error) {
		alert(error);
	}
}

function movedata(id, fromto, forto) {
	try {
		http = createRequestObject();
		http.open('post', '../MoveData', true);
		http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		http.send("id=" + id + "&fromto=" + fromto + "&forto=" + forto);
	} catch (error) {
		alert(error);

	}
}
function UpdateAjax(id, fromto) {
	var data = document.getElementById('styled').value;
	if (data.charAt(0) != " " && data.length >= 1) {
		try {
			http = createRequestObject();
			http.onload = () => {
				var response = http.responseText;
				document.getElementById('todo').innerHTML = response;
				removeDiv();
				runAble();
			}
			http.open('post', '../UpdateData', true);
			http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			http.send("id=" + id + "&fromto=" + fromto + "&data=" + data);
		} catch (error) {
			alert(error);
		}

	}
	else {
		removeDiv();
		if (data.length >= 1)
			alert("First Letter Can not Be A  Space ");
		else
			alert("Task Can't be Null")
	}
}



function removeTask(id) {
	if (confirm("Are You Sure To Delete")) {
		try {
			var http = createRequestObject();
			http.onload = () => {
				var res = http.responseText;
				document.getElementById("todo").innerHTML = res;
				runAble();
			}
			http.open('post', '../DeleteData', true);
			http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			http.send("id=" + id);
		} catch (error) {

		}
	}
}






















