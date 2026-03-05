# Real-Time Notification Broadcast Service

##  Project Overview
This project is a **Real-Time Notification Broadcast Service** that delivers instant notifications to all connected users using **Spring WebSocket** and a **React frontend**.

The backend supports real-time communication and can be easily deployed using **Docker containers**.

---

##  Features

- Real-time notification delivery using **WebSocket**
- Multiple users can connect simultaneously
- Broadcast messages to all connected clients
- REST API for triggering notifications
- Health check endpoint
- Dockerized backend for easy deployment
- React-based lightweight frontend UI

---

##  Tech Stack

### Backend
- Java
- Spring Framework / Spring Boot
- WebSocket
- REST API

### Frontend
- React.js
- HTML5
- CSS3

### DevOps
- Docker
- GitHub

---

## ⚙️ How to Run the Project

### 1️⃣ Clone Repository
git clone <repository-url>
cd notification-service

---

### 2️⃣ Build Backend
mvn clean package
This will generate the **JAR file inside the target folder**.

---

### 3️⃣ Run Backend using Docker
Build Docker Image
docker build -t notification-app .
Run Container
docker run -p 8080:8080 notification-app
Backend will start at:
http://localhost:8080

---

### 4️⃣ Run Frontend
Go to frontend folder
cd notification-ui
Install dependencies
npm install
Start React server
npm start
Frontend will run at:
http://localhost:3000
---

## 🔔 WebSocket Endpoint
ws://localhost:8080/ws
Topic Subscription
/topic/notifications
---

## 🧪 Testing Notifications
Notifications can be triggered using REST API.
Example:
POST http://localhost:8080/api/notify
This will broadcast notifications to all connected users.

---

## 🐳 Docker Support
The backend is containerized using Docker.
Dockerfile includes:
- OpenJDK base image
- Application JAR
- Port exposure
- Entry point configuration

---

## 📈 Future Improvements
- Redis Pub/Sub for multi-instance broadcast
- Authentication & authorization
- Notification persistence using MySQL
- Kubernetes deployment

---

## 👨‍💻 Author
Mahendra Singh  
Java Full Stack Developer


## 📂 Project Structure
