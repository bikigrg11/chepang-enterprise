(function(){

    function updateLogOut() {
        var el = document.getElementById("cartLogout");
        var params = window.location.href.split("?")[1];
        el.setAttribute("href","/userlogout?"+params);
    }

    updateLogOut();

    function updateHome() {
        var hl = document.getElementById("chepanghome");
        var params = window.location.href.split("?")[1];
        hl.setAttribute("href","/viewnext?"+params);
    }

    updateHome();
}());