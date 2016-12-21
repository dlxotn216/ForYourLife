/**
 * Created by Neonexsoft on 2016-11-28.
 */
$(document).ready(function(){

    $('#connBtn').click(function() {
        conn();
    });

    $('#sendBtn').click(function() {
        send();
    });

    var sock;
    function conn(){
        sock = new SockJS("http://localhost:8080/echo.sockjs");
        sock.onmessage= onMessage;
        sock.onclose = onClose;
        sock.opOpen= onOpen;
    }
    function send(){
        var msg = $("#message").val();
        alert(msg+" send");
        sock.send(msg);
    }

    function onOpen(){
        alert("opened");
    }

    function onMessage(evt){
        alert("서버로부터 수신: "+ evt.data);
        sock.close();
    }

    function onClose(evt){
        alert("연결 종료");
    }
});