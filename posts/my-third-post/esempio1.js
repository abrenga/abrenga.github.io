var http = new XMLHttpRequest(type, url, callback);
http.open('GET', url, true);
http.send();
http.onload = function () {
    if (http.status === 200){ 
        console.log(http.responseText);
    }
}

