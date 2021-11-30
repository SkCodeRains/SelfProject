/**
 * 
 */
function signup() {
	button = document.querySelector('[type=submit]');
	var a, b;
	document.getElementById("username").addEventListener("focusout", (event) => {
		try {
			http = new XMLHttpRequest();
			var x = document.getElementById("error");
			http.onload = () => {
				if (http.responseText == "true") {
					x.innerHTML = "Username Available";
					x.style.color = 'green';
					a = 1;
				} else {
					a = 0;
					x.style.color = "red";
					x.innerHTML = "Username Already Exists";

				}
			}
			http.open("post", "UsernameValidator", true);
			http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			http.send("id=" + event.target.value);
		} catch (error) {
			alert(error);
		}

	})
	document.getElementById("conf").addEventListener("focusout", pass);
	document.getElementById("pass").addEventListener("focusout", pass);

	function pass() {
		var x = document.getElementById("pass").value;
		var y = document.getElementById("conf").value;
		if (x != "" && y != "") {
			var ins = document.getElementById("passv");
			if (x == y) {
				ins.innerHTML = "password matched";
				ins.style.color = "green";
				b = 1;
			} else {
				b = 0;
				ins.innerHTML = "password not matching";
				ins.style.color = "red";
			}
		}
	}
	document.getElementById("sub").addEventListener("mouseover", () => {
		if (a == 1 && b == 1) {
			document.getElementById("temp").value = "true";
		} else {
			document.getElementById("temp").value = "";

		}
	});
}
