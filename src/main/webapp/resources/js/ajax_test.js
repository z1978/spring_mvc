function del(n) {
	var s = document.getElementById('s');
	var t = s.childNodes.length;
	for (var i = 0; i < t; i++) {
		if (i == n - 1) {
			s.removeChild(s.childNodes[i]);
		}
	}
}

function add(n, txt) {
	var s = document.getElementById('s');
	var t = s.childNodes.length;
	var li = document.createElement("li");
	li.innerHTML = txt;
	for (var i = 0; i < t; i++) {
		if (n == -1) {
			s.appendChild(li);
		} else if (i == n - 1) {
			s.insertBefore(li, s.childNodes[i]);
		}
	}
}

function showDate(n) {
	var mydate = Date();
	var dateul = document.getElementById('dateul');
	var cnt = s.childNodes.length;
	var li = document.createElement("li");
	li.innerHTML = mydate;
	for (var i = 0; i < cnt; i++) {
		if (n == -1) {
			dateul.appendChild(li);
		} else if (i == n - 1) {
			dateul.insertBefore(li, dateul.childNodes[i]);
		}
	}
}
// $(function() {
// $('div').append('<input type=text>');
// document.write(Date());
// var confRet = confim("test message");
// if (confRet) {
// document.write(Date());
// var form = $("#testForm").get()[0];
// $("#uploadButton").on("click", showCustomer(form));
// } else {
// toEnabled();
// return false;
// }
// });


// Ajax通信成功時処理
function success(data) {
	alert("success:" + data);

	$("#output_data").text("");
	for (var cnt = 0; cnt < data.length; cnt++) {
		$("#output_data").append("data[" + cnt + "]：" + data[cnt] + "；");
	}
}

// Ajax通信失敗時処理
function error(XMLHttpRequest, textStatus, errorThrown) {
	alert("error:" + XMLHttpRequest);
	alert("status:" + textStatus);
	alert("errorThrown:" + errorThrown);
}

$(function() {
	// Ajax通信テスト ボタンクリック
	$("#ajax_btn").click(function() {
		// outputDataを空に初期化
		$("#output_data").text("");
		$.ajax({
			type : "GET",
			url : "getTestData1.html",
//			dataType : "json",
			success : function(data) {
				success(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	});

	// Ajax通信テスト ボタンクリック
	$("#ajax_btn2").click(function() {
		 //テキストボックスの入力チェックとか
		  var jsonString = $('form').serializeArray();
		  var formData = JSON.stringify(jsonString);
			$.ajax({
				type: 'POST',
				url: 'getTestData2.html',
				data: JSON.stringify(jsonString),
				contentType: 'application/json',
				datatype: 'json',
				scriptCharset: 'utf-8'
			}).done(function(data){
		                //返ってきたときの処理
				alert(data);
			}).fail(function(data){
				//返らなかったときの処理
				alert(data);
			});

			
		// outputDataを空に初期化
		$("#output_data").text("");
//		$.ajax({
//			type : "POST",
//			url : "getTestData2.html",
//			dataType : "json",
//			success : function(data) {
//
//				for (var i = 0; i < data.length; i++) {
//				    alert(data[i]);
//					success(data[i]);
//
//				}
//			},
//			error : function(XMLHttpRequest, textStatus, errorThrown) {
//				error(XMLHttpRequest, textStatus, errorThrown);
//			}
//		});
	});

});
