function $(id) {
    return document.getElementById(id);
}

function preRegist() {

    var unameTxt = $("unameTxt");
    var uname = unameTxt.value;
    var unameSpan = $("unameSpan");
    var unameReg = /.{6,16}/;
    if (!unameReg.test(uname)) {
        unameSpan.style.visibility="visible";
        return false;
    }else {
        unameSpan.style.visibility="hidden";
    }

    var pwdTxt = $("pwdTxt");
    var pwd = pwdTxt.value;
    var pwdSpan = $("pwdSpan");
    var pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9a-zA-Z]{8,}$/;
    if (!pwdReg.test(pwd)) {
        pwdSpan.style.visibility="visible";
        return false;
    }else {
        pwdSpan.style.visibility="hidden";
    }

    var pwd2 = $("pwdTxt2").value;
    var pwdSpan2 = $("pwdSpan2");
    if (pwd!=pwd2) {
        pwdSpan2.style.visibility="visible";
        return false;
    }else {
        pwdSpan2.style.visibility="hidden";
    }

    var emailTxt = $("emailTxt");
    var email = emailTxt.value;
    var emailSpan = $("emailSpan");
    var emailReg = /^[a-zA-Z0-9\.-]+@([a-zA-z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    if (!emailReg.test(email)) {
        emailSpan.style.visibility="visible";
        return false;
    }else {
        emailSpan.style.visibility="hidden";
    }


    return true;
}


function createXMLHttpRequest() {
    if (window.XMLHttpRequest) {
        xmlHttpRequest = new XMLHttpRequest();
    }else if (window.ActiveXObject) {
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxm12.XMLHTTP");
        }

    }

}


function ckUname(uname) {
    createXMLHttpRequest();
    var url = "user.do?operate=ckUname&uname=" + uname;
    xmlHttpRequest.open("POST",url,true);
    xmlHttpRequest.onreadystatechange = ckUnameCB;
    xmlHttpRequest.send();
}

function ckUnameCB() {
    if (xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200) {
        var responseText = xmlHttpRequest.responseText;
        if (responseText=="{'uname','1'}") {
            alert("用户名已经被注册");
        }else {
            alert("用户可以使用");
        }
    }
}