function login() {
	try {
		var form = document.getElementById("loginform");
		var http = new XMLHttpRequest;
		http.open("POST", "Login", true);
		http.send(form);
	} catch (error) {
		alert("hahahahaa" + error);
	}
}
function signupLoad() {
	var logs = document.getElementById("SignUp");
	logs.id = "Login";
	logs.innerHTML = "Login";
	logs.href = "javascript:location.reload()";
	{
		try {
			var http = new XMLHttpRequest;
			http.open("GET", "Logs/SignUp.jsp", true);
			http.onload = () => {
				var divs = document.getElementById("loginSignUp");
				try {
					divs.style.marginTop = "7%";
				} catch (error) {
					alert(error);
				}
				divs.innerHTML = http.responseText;
				signup();
			}
			http.send();
		} catch (error) {
			alert(error);
		}
	}
}