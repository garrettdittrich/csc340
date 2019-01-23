
var stompClient = null;

$(document).ready(function(){
	
	if(stompClient!=null)
		stompClient.disconnect();

	 var socket = new SockJS('http://192.168.1.10:8080/livescore-websocket');
	 stompClient = Stomp.over(socket);
	
    $("button").click(function(){
        
    	sendData2Socket();
    	
    });
});

function sendData2Socket() {
	
	var username = $("#username").val();
	var password = $("#password").val();
	var gps = $("#gps").val();
	
	stompClient.send("/app/user", {}, JSON.stringify({'username': username, 'password': password, 
		'gps': gps}));

}