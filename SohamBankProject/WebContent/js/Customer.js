/**
 * 
 */

function openform(x) {
	try {
		document.getElementById("Statement").style.display = "none";
		document.getElementById("Transfer").style.display = "none";
		document.getElementById("bill").style.display = "none";
		document.getElementById("Recharge").style.display = "none";
		document.getElementById(x).style.display = "block";
	} catch (error) {
		alert(e);
	}
}

function repoerts() {
	try {
		document.getElementById("tbales").style.display = "none";
		document.getElementById("reports").style.display = "block";
	} catch (e) {

	}

}

function hideclose() {
	document.getElementById("reports").style.display = "none";
	document.getElementById("tbales").style.display = "";
}

function searchshow(inp, tabl, diva) {

	try {
		var input, filter, table, tr, td, i, txtValue;
		input = document.getElementById(inp);
		var le = document.getElementById(inp).value;
		if (1 < le.length) {
			document.getElementById(diva).style.display = "block";
		} else {
			document.getElementById(diva).style.display = "none";
		}
		filter = input.value.toUpperCase();
		table = document.getElementById(tabl);
		tr = table.getElementsByTagName("tr");
		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[1];
			if (td) {
				txtValue = td.textContent || td.innerText;
				if (txtValue.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}

	} catch (e) {
		alert("table " + e);
	}
}

function passvalidate(k) {

	document.getElementById("passSubmit").style.display = "none";
	var i = document.getElementById("oldpass").value;
	if (k == i) {
		document.getElementById("oldpass").style.borderColor = "green";
		var n = document.getElementById("newpass").value;
		var g = document.getElementById("confpass").value;
		if (n == g) {
			if (n == "") {

			} else {
				document.getElementById("newpass").style.borderColor = "green";
				document.getElementById("confpass").style.borderColor = "green";
				document.getElementById("passSubmit").style.display = "block";
			}
		} else {
			document.getElementById("newpass").style.borderColor = "red";
			document.getElementById("confpass").style.borderColor = "red";
		}

	} else {
		document.getElementById("oldpass").style.borderColor = "red";

	}
}

function ClearFields() {
	document.getElementById("confpass").value = "";
	document.getElementById("newpass").value = "";
	document.getElementById("oldpass").value = "";
}