document.addEventListener("mousedown", function() {
	setTimeout(function() {
		var x = document.getElementsByClassName("btn-group")[0].className;
		if (x == 'btn-group show') {
			document.getElementById('second').style.marginTop = '200px';
		} else {
			document.getElementById('second').style.marginTop = '100px';
		}
	}, 200);

});



$('.Dropdown').on('show.bs.dropdown', function() {
	alert('ullu');
})



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




//index.jsp select funtions operations....


function selector(path) {
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






// default processResponse single tag value
function processResponse() {
	if (http.readyState == 4) {
		var response = http.responseText;
		document.getElementById(id).innerHTML = response;
	}
}
//End ---------->






//ourfirstAccount.html   called function retrive data from getAccount.jsp
function GetAccount(id) {
	this.id = id;
	uid = document.getElementById("uid").value;
	var input = document.getElementById("uid");
	input.addEventListener("keyup", function(event) {
		if (event.keyCode === 13) {
			http.open('get', 'ajax/getAccount.jsp?uid=' + uid);
			http.onreadystatechange = processResponse;
			http.send(null);
		}
	});
}
//End ---------->






// DropDownType.html  called relative related all data 
function getAccountType(id, type) {
	this.id = id; try {
		type
		http.open('get', 'ajax/DropDownType.jsp?type=' + type);
		http.onreadystatechange = processResponse;
		http.send(null);
	}
	catch (error) {
		alert("called");
	}

}
//End ---------->








// DropDownlistdetails.html  called retrive related sigle person data data 
function dropDownList(id, to) {
	this.id = id;
	if (to == 'listType') {
		type = document.ddlfrm.listType.value;
		http.open('get', 'ajax/DropDownlistdetails.jsp?type=' + type + '&to=' + to);
	}


	if (to == 'listName') {
		name = document.ddlfrm2.listName.value;
		http.open('get', 'ajax/DropDownlistdetails.jsp?id=' + name + '&to=' + to);
	}
	http.onreadystatechange = processResponse;
	http.send(null);
}
//End ---------->







// registration.html  called method validate user id  by <3<3<3 servelet 3>3>3>
function registrationCheck() {
	var aaa = document.getElementById("accno").value;
	http.open('get', 'registrationCheck?Number=' + aaa);
	http.onreadystatechange = processResponse2;
	http.send(null);
}
function processResponse2() {
	if (http.readyState == 4) {
		var subbt = document.getElementById("submitbn");
		var response = http.responseText;
		var aaa = document.getElementById("accno").value;
		if (aaa.length > 3) {
			if (response == "true") {
				document.getElementById("accno").style.color = "white";
				document.getElementById("accno").style.fontSize = "18px";
				document.getElementById("accno").style.fontFamily = "'Lucida Console', Monaco, monospace";
				subbt.removeAttribute('disabled');
			} else {
				fontsStyleForInputValid(subbt);
			}
		} else {
			fontsStyleForInputValid(subbt);
		}

	}
}
function fontsStyleForInputValid(subbt) {
	document.getElementById("accno").style.color = "red";
	try {
		subbt.setAttribute('disabled', true);
		document.getElementById("accno").style.fontSize = "16px";
		document.getElementById("accno").style.fontFamily = "'Times New Roman', Serif font: Times New Roman, Sans-serif";
	} catch (e) {
		alert(e);
	}

}
//End ---------->







/*
registration.html called validating remaining field 
and inserting data using <3<3<3 servelet 3>3>3> and beans
*/
function registration() {
	var accno = document.getElementById("accno").value;
	var accnm = document.getElementById("accnm").value;
	var acctype = document.getElementById("acctype").value;
	var accbal = document.getElementById("accbal").value;
	switch ("") {
		case accno:
			alert("Please Account Number");
			break;
		case accnm:
			alert("Please Account Holder Name");
			break;
		case acctype:
			alert("Please Select Account Type");
			break;
		case accbal:
			alert("Please Enter Initail Balance");
			break;
		default:
			http.open('get', 'registration?n=' + accno + '&m=' + accnm + '&t=' + acctype + '&b=' + accbal);
			http.onreadystatechange = processResponsereg;
			http.send(null);
	}
}
function processResponsereg() {
	if (http.readyState == 4) {
		var response = http.responseText;
		if (response == "true") {
			document.getElementById("accno").value = "";
			var accnm = document.getElementById("accnm").value;
			document.getElementById("accnm").value = "";
			document.getElementById("acctype").selectedIndex = 0;
			document.getElementById("accbal").value = "";
			alert("New User " + accnm + " Created Sucessfully");
		} else {
			alert("Error Contact Industry" + response);
		}
	}
}
//End ---------->


