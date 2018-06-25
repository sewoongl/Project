$.ajax({
    	type : "post",
	url : "/swl/msgList/swl/msgList"
}).done(function(data){
	var d = JSON.parse(data);
	var dt = d.result;
	$("#msgList").empty();
	
	for(var i = 0; i < dt.length; i++){
			var html = "<tr id='titletrID"+ dt[i].msgNo +"' class='titletr'>";
			html += "<td>" + dt[i].regDate + "</td>";
			html += "<td>" + dt[i].msgName + "</td>";
			html += "<td>" + dt[i].msgEmail + "</td>";
			html += "</tr>";
		$("#msgList").append(html);
	}
	
    $(".titletr").on("click", function(){
    	var rows_id = $(this).attr('id');
    	var new_msgNo = rows_id.substring(9);
    	
    	$.ajax({
	    	type : "post",
	    	url : "/swl/msgOne",
	    	data : {"msgNo" : new_msgNo}
	    }).done(function(data){
	    	var d = JSON.parse(data);
	    	$("#msgOne").empty();
	    	$(".message-contents").show();
         	$("#layer").show();
			var html = "<div class='pw-box-text'>";
			html += "<p class='btn-50' id='msg-date'>" + d.msgData.regDate +"</p>";
			html += "<p class='btn-50' id='msg-writer'>" + d.msgData.msgName + "</p>";
			html += "</div>";
			html += "<div class='input-group join-box-input'>";
			html += "<p id='msg-email'>" + d.msgData.msgEmail + "</p>";
			html += "<textarea rows='5' id='msg-text'>" + d.msgData.msgContents + "</textarea>";
			html += "</div>";
			html += "<div class='join-btn-box'>";
			html += "<input type='button' id='change-confirm' class='btn btn-info btn-50' value='확인'>";
			html += "<input type='button' id='submit-change' class='btn btn-danger btn-50' value='삭제'>";
			html += "</div>";
    		$("#msgOne").append(html);
    			
    			$("#change-confirm").on("click", function(){
    				layerOut();
    	 	    });
				$("#submit-change").on("click", function(){
					console.log(d.msgData.msgNo);
			    	$.ajax({
			    		type : "post",
			    		url : "/swl/msgDel",
			    		data : {"msgNo" : d.msgData.msgNo}
			    	}).done(function(data) {
			    		 alert("메시지가 삭제되었 습니다.");
			    		 location.href="/swl/resources/ex/message.html";
			    	});
    			});
	    });
	}); 
});