/**
 * 
 */

function openform(x) {
	try {
		document.getElementById("NewAccount").style.display = "none";
		document.getElementById("CloseAccount").style.display = "none";
		document.getElementById("transfer").style.display = "none";
		document.getElementById("report").style.display = "none";
		document.getElementById(x).style.display = "block";
	} catch (error) {
	}
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

function ShowAll() {
	alert("Hello");
	document.getElementById("myTable").style.display = "none";
	var x = document.getElementById("show").value;
	if (x == "On") {
		document.getElementById("closeacctable").style.display = "block";
	} else {
		document.getElementById("closeacctable").style.display = "none";
	}
}