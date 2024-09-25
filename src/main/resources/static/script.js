var stompClient = null;

function connect() {
    let socket = new SockJS("/server1");

    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("Connected: " + frame);

        // Hide name form and show chat room
        $("#name-form").addClass('d-none');
        $("#chat-room").removeClass('d-none');

        // Subscribe to the topic
        stompClient.subscribe("/topic/return-to", function (response) {
            console.log("Received message: ", response.body); // Debug log
            showMessage(JSON.parse(response.body));
        });
    }, function (error) {
        console.error("Connection error: " + error);
    });
}

function showMessage(message) {
    // Ensure message has required properties
    if (message && message.name && message.content) {
        $("#message-container-table").prepend(`<tr><td><b>${message.name} :</b> ${message.content}</td></tr>`)
    } else {
        console.error("Invalid message format: ", message);
    }
}

function sendMessage() {
    let jsonOb = {
        name: localStorage.getItem("name"),
        content: $("#message-value").val()
    };

    // Check if message content is valid before sending
    if (jsonOb.content) {
        console.log("Sending message: ", jsonOb); // Debug log
        stompClient.send("/app/message", {}, JSON.stringify(jsonOb));
        $("#message-value").val('');  // Clear the input after sending
    } else {
        console.warn("Message content is empty");
    }
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
        console.log("Disconnected");
    }

    // Clear local storage and UI
    localStorage.removeItem("name");
    $("#name-form").removeClass('d-none');
    $("#chat-room").addClass('d-none');
}

$(document).ready(() => {
    $("#login").click(() => {
        let name = $("#name-value").val();
        if (name) {
            localStorage.setItem("name", name);
			
			$("name-title").html(name);
            connect()
			
			
        } else {
            console.warn("Name is empty");
        }
    });

    $("#send-btn").click(() => {
        sendMessage();
    });

    $("#logout").click(() => {
        disconnect();
    });
});
