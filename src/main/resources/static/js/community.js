function post() {
    var questionId = $("#question_id").val();
    var content = $("#Description").val();
    console.log(content);
    console.log(questionId);
    $.ajax({
        type:"POST",
        url:"/comment",
        contentType:"application/json",
        data:JSON.stringify({
            "parentId":questionId,
            "description":content,
            "type":1
        }),
        success:function (response) {
            if (response.code == 200){
                $("#comment_section").close();
            }else {
                if(response.code == 2003){
                    debugger
                    var isAccepted = confirm(response.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=62a68b8182576a1d0607&redirect_uri=http://localhost:8080/callback&scope=user&state=1&allow_signup=true");
                        window.localStorage.setItem("closable","true");
                    }
                }
                alert(response.message);
            }
           console.log(response);
        },
        dataType:"json"
    });

}
function loginfirst() {
    var name = $("#name1").val();
    var password1 = $("#password1").val();
    var email1 = $("#email1").val();
    console.log(name);
    console.log(password1);
    alert("123");
    $.ajax({
        type:"POST",
        url:"/login",
        contentType:"application/json",
        data:JSON.stringify({
            "accountId":email1,
            "password":password1,
            "name":name
        }),
        success:function (response) {
            if (response.code == 200){
                alert("注册成功！")
            }else {
                if(response.code == 2003){
                    debugger
                    var isAccepted = confirm(response.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=62a68b8182576a1d0607&redirect_uri=http://localhost:8080/callback&scope=user&state=1&allow_signup=true");
                        window.localStorage.setItem("closable","true");
                    }
                }
                alert(response.message);
            }
            console.log(response);
        },
        dataType:"json"
    });

}
function loginsecond() {
    var email2 = $("#email2").val();
    var password2 = $("#password2").val();
    alert("123");
    $.ajax({
        type:"POST",
        url:"/login",
        contentType:"application/json",
        data:JSON.stringify({
            "accountId":email2,
            "password":password2
        }),
        success:function (response) {
            if (response.code == 200){
                $("#comment_section").close();
            }else {
                if(response.code == 2003){
                    debugger
                    var isAccepted = confirm(response.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=62a68b8182576a1d0607&redirect_uri=http://localhost:8080/callback&scope=user&state=1&allow_signup=true");
                        window.localStorage.setItem("closable","true");
                    }
                }
                alert(response.message);
            }
            console.log(response);
        },
        dataType:"json"
    });

}