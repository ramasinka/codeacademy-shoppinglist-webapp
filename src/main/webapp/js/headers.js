function getAuthorizaitonCode() {
    var req = new XMLHttpRequest();
    req.open('GET', document.location, false);
    req.send(null);
    var code = req.getResponseHeader('code');
    return code;
}