function fetchdata(paths) {
    var path;
    if (paths == 'Main') {
        path = 'fetchdata.jsp';
    } else {
        path = 'insert.jsp';
    }
    try {
        const http = new XMLHttpRequest;
        http.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("container").innerHTML = this.responseText;
            }
        };
        http.open("post", path, true);
        http.send();
    } catch (error) {
        alert(error)
    }
}