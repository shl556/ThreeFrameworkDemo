function login_check(){
 if(document.login_form.lgname.value==""){
    alert("用户名不能为空");
    return false;
 }
 if(document.login_form.lgpass.value==""){
    alert("密码不能为空");
    return false;
 }
}

function newpost_check(){
	if(document.postform.title.value=="") {
		alert("标题不能为空");
		return false;
	}
	if(document.postform.content.value=="") {
		alert("内容不能为空");
		return false;
	}
	if(document.postform.content.value.length>1000) {
		alert("长度不能大于1000");
		return false;
	}
}

function newreply_check(){
	if(document.postform.replyContent.value=="") {
		alert("内容不能为空");
		return false;
	}
	if(document.postform.replyContent.value.length>1000) {
		alert("长度不能大于1000");
		return false;
	}
}


function register_check() {
 if(document.register_form.lgname.value==""){
    alert("用户名不能为空");
    return false;
 }
 if(document.register_form.lgpass.value==""){
    alert("密码不能为空");
    return false;
 }
 if(document.register_form.lgpass.value != document.regForm.lgpass_validate.value){
    alert("2次密码不一样");
    return false;
 }
 if(document.register_form.nickname.value==""){
    alert("昵称不能为空");
    return false;
 }
}