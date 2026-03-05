import React, { useEffect, useState } from "react";
import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";
import "./Notification.css";

const Notification = () => {
  const [messages, setMessages] = useState([]);

  useEffect(() => {
    const client = new Client({
      webSocketFactory: () =>
        new SockJS("http://localhost:8080/ws"),

      onConnect: () => {
        console.log("CONNECTED TO WEBSOCKET");

        client.subscribe("/topic/notifications", (msg) => {
          setMessages(prev => [...prev, JSON.parse(msg.body)]);
        });
      }
    });

    client.activate();
    return () => client.deactivate();
  }, []);

  return (
    <div className="container">
      <div className="card">
        <h2> Real-Time Notifications</h2>

        {messages.length === 0 && (
          <div className="empty">No notifications yet</div>
        )}

        {messages.map((m, i) => (
          <div className="notification" key={i}>
            <div className="msg">{m.message}</div>
            <div className="time">{m.timestamp}</div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Notification;
