/**
 * Created by Administrator on 2015/12/21.
 */
 function register_check() {
    var lgname = document.getElementById("lgname");

    if (lgname.validity.valueMissing) {
        lgname.setCustomValidity("用户名不能为空");
    }else{
        lgname.setCustomValidity("");
    }
    var pass1 =document.getElementById("pass1");
    var pass2=document.getElementById("pass2");
    if(pass1.validity.valueMissing){
        pass1.setCustomValidity("密码不能为空");

    }else{
        pass1.setCustomValidity("");
    }
    if(pass1.value!=pass2.value){
        pass2.setCustomValidity("密码不一致");

    }else{
        pass2.setCustomValidity("");
    }
    var nickname=document.getElementById("nickname");
    if(nickname.validity.valueMissing){
        nickname.setCustomValidity("昵称不能为空");

    }else{
        nickname.setCustomValidity("");
    }
}



