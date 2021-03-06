sesssionData();

$("#login").on("click", function(){
    $("#layer").css("display", "block");
    $("#container").css("opacity", "0.5");
    $("#login-box").css("display", "block");
});

$("#layer").on("click", function(){
    layerOut();
});

$("#formX").submit(function(e){
    layerOut();
    e.preventDefault();
    
    var id = $("#email").val();
    var password = $("#password").val();
//    console.log("id :" + id);
//    console.log("password :" + password);
    $.ajax({
    	type : "post",
    	url : "/swl/login",
    	data : {"id" : id, "password" : password }
    }).done(function(data){
    	var d = JSON.parse(data);
    	console.log(d);
    	if(d.status!=0){
    		iflogin();
    	}else if(d.status!=1){
    		alert("정보가 맞지 않습니다.");
    	}
    });
});

$("#joinBtn").on("click", function(e){
    location.href="join.html";
})

function iflogin(){
	$("#login").css("display", "none");
    $("#main-logoutbtn").css("display", "block");
    $("#write-btn").css("display", "block");
    $("#page_myinfo").css("display", "block");
}

function sesssionData(){
    $.ajax({
    	type : "post",
    	url : "/swl/infoData"
    }).done(function(data){
    	var d = JSON.parse(data).user;
		if(d != null){
			iflogin();
		}
    });
}




/* 공통부분 */
function layerOut(){
    $(".pw-change-box").hide();
    $(".message-contents").hide();
    $("#layer").css("display", "none");
    $("#container").css("opacity", "1");
    $("#login-box").css("display", "none");
    $(".join-box").css("display", "none");
    $(".send-mail").css("display", "none");
}

$("#logout").on("click", function(){
    location.href = 'index.html';
});


$(".arc-box-img").on("click" , function(){
    location.href = "detail.html";
});


$("#detail-list").on("click" , function(){
    location.href = "index.html";
});

$("#writebtn").on("click" , function(){
    location.href = "write.html";
});



$("#leftMenu").on("click" , function(e){
    $("#left-copy").css("display","block").css("z-index","5005").css("width","200px").css("height","auto").css("padding-bottom", "15px");
    e.stopPropagation();
});
$("#right:not(#leftMenu1)").on("click", function(){
            $("#left-copy").hide(300);
});

$(window).on("resize", function(){
    var width = $(window).width();
    console.log(width);
    if(width < 768){
        $("#left-copy").hide();
        $("#right:not(#leftMenu1)").on("click", function(){
            console.log($(this));
            console.log("띠로리리리리");
            $("#left-copy").hide(300);
        });
    }
});

/*메세지 보내는 부분*/
$("#contact_info").submit(function(e){
	e.preventDefault();
	
	var msgName = $("#usrName").val();
	var msgEmail = $("#usrMail").val();
	var msgContents = $("#usr").val();
	
	var d = {
		"msgName" : msgName,
		"msgEmail" : msgEmail,
		"msgContents" : msgContents
	};
	
	
	if(d.msgName == ""){
		alert("이름을 입력하세요.")
	}else if (d.msgEmail == ""){
		alert("답변 받을 이메일을 입력하세요.")
	}else if (d.msgContents == ""){
		alert("피드백 내용을 적어주세요.")
	}else {
		$.ajax({
			type : "post",
			url : "/swl/msg/swl/msgSend",
			data : d
		}).done(function(data){
			alert("메시지가 전송 되었습니다.");
			location.href = 'index.html';
		});
	}
});

/*Contact me 부분*/

$.ajax({
	type : "post",
	url : "/swl/contact/swl/contact"
}).done(function(data){
//	console.log(data);
	var d = JSON.parse(data).result;
//	console.log(d[0].email);
//	console.log(d[0].addr);
//	console.log(d[0].phone);
	
	var proEmail = d[0].email;
	var proAddr = d[0].addr;
	var proPhone = d[0].phone;	
	$("#proEmail").append(proEmail);
	$("#proAddr").append(proAddr);
	$("#proPhone").append(proPhone);
})






