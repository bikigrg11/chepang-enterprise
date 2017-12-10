(function(){

    //var  userid = null;

    function updateLogOut() {
        var el = document.getElementById("chepanglogout");
        var params = window.location.href.split("?")[1];
        el.setAttribute("href","/userlogout?"+params);
    }

    function updateCartDisplay() {
        var el = document.getElementById("chepangCartDisplay");
        var userid = window.location.href.split("?")[1];

        var actualid;
        if(userid.length > 7){
            actualid = userid.split('&')[2];
        }else{
            actualid = userid;
        }
        el.setAttribute("href","/cartpost?"+actualid);
    }

    function updateUser(){
        var el = document.getElementsByClassName('chepang_item_add');

        var userid = window.location.href.split("?")[1];

        var actualid;
        if(userid.length>7){
            actualid = userid.split('&')[2];
        }
        else{
            actualid = userid;
        }
        for(var i=0; i<el.length;i++){
            el[i].href = el[i].href+'&'+actualid;
        }
     }

    updateCartDisplay();
     updateLogOut();
     updateUser();

}());