'use strict';
var userNamePage = document.querySelector("#username-page");
var chatPage = document.querySelector("#chat-page");
var userNameForm = document.querySelector("#usernameForm");
var messageForm = document.querySelector("#messageForm");
var messageInput = document.querySelector("#message");
var messageArea = document.querySelector("#messageArea");
var connectingElement = document.querySelector(".connecting");

var stompClient = null;
var userName = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event){
    userName = document.querySelector("#name").value().trim();
    if(userName){
        userNamePage.classList.add("hiddent");
        chatPage.classList.remove("hidden");

        var soket = new SocKetJS('/ws');
        stompClient = Stomp.over(soket);   

        stompClient.connect({}, onConnected, onError);
    }

    event.preventDefault();
}

function onConnected(){
    stompClient.subscribe("/topic/public", onMessageReceived);

    stompClient.send(
        "/app/chat.addUser", 
        {},
        JSON.stringify({sender: userName, type: "JOIN"}) 
    );
    connectingElement.classList.add("hidden");

}
function onError(){
    connectingElement.textContent = "Could not to connect WebSockt. Please refresh this page and try!";
    connectingElement.style.color = "red";
}
function onMessageReceived(){

}

function sendMessage(event){

    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient){
        var chatMessage = {
            sender: userName,
            content : messageContent,
            type: "CHAT"
        };
        stompClient.send(
            "app/chat.sendMessage",
            {},
            JSON.stringify(chatMessage)
        );
        messageInput.content = "";
    }
    event.preventDefault();
}
userNameForm.addEventListener("submit", connect, true);
messageForm.addEventListener("submit", sendMessage, true);
