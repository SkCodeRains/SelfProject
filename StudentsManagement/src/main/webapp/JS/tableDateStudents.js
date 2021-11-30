//import {hello} from './Main';

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
        tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return tmpXmlHttpObject;
}
function Update(obj) {
	alert(obj.value);
    var http = createRequestObject();
    try {
        http.onreadystatechange = function () {
            if (http.readyState == 4 && http.status == 200) {
                if (http.responseText == 'true') {
                    document.getElementById("msgP").innerHTML = obj.name + " is updated successfully";
                    setInterval(() => {
                        document.getElementById("msgP").innerHTML = "";
                    }, 3000);
                }
            }
        };
        http.open('POST', "UpdateSt");
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        http.send('columns=' + obj.name + '&datas=' + obj.value);

    } catch (error) {
        console.log(error);
    }
}


function Delete(obj) {
    var http = createRequestObject();
    try {
        if (confirm("are you sure you want to delete")) {
            http.open('get', "DeleteSt");
            const ht = '<div class="d-flex h-100 justify-content-center flex-column align-items-center "><p class="  font-weight-bolder text-capitalize"> your account is deleted thank you !!! </p><p class="  font-weight-bold  just text-capitalize"> you will be redirected to Login page ... </p></div>'
            http.onreadystatechange = function () {
                if (http.readyState == 4 && http.status == 200) {
                    if (this.responseText == 'true') {
                        document.getElementById("msg").innerHTML = ht;
                        setInterval(() => {
                            window.location.href = "Login.jsp"
                        }, 3000);
                    } else {

                    }
                }
            };
            http.send();
        }
    } catch (error) {
        console.log(error);
    }



}