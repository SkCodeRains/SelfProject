
function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
        tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return tmpXmlHttpObject;
}
function edit(obj) {
    try {
        const mains = document.getElementById("main");
        mains.classList.remove("d-flex");
        mains.classList.add("d-none");
        const edit = document.getElementById("editpanel");
        edit.classList.remove("d-none");
        edit.classList.add("d-flex");
        document.getElementById("label").innerHTML = obj.id;
        const inp = document.getElementById("eidtsection");
        inp.value = obj.innerHTML;
        inp.name = obj.id;
        inp.focus;
    } catch (error) {
        alert(error);
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


function canceled() {
    const mains = document.getElementById("main");
    mains.classList.remove("d-none");
    mains.classList.add("d-flex");
    const edit = document.getElementById("editpanel");
    edit.classList.remove("d-flex");
    edit.classList.add("d-none");
}

function UpdateIt() {
    var http = createRequestObject();
    try {
        const inp = document.getElementById("eidtsection");
        const obj = document.getElementById(inp.name);
        obj.innerHTML = inp.value;
        http.onreadystatechange = function () {
            if (http.readyState == 4 && http.status == 200) {
                document.getElementById("msg").innerHTML = inp.name + " is updated successfully";
                setInterval(() => {
                    document.getElementById("msg").innerHTML = "";
                }, 3000);
            }
        };
        http.open('POST', "UpdateSt");
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        http.send('columns=' + inp.name + '&datas=' + inp.value);
    } catch (error) {
        console.log(error);
    }
    canceled();
}