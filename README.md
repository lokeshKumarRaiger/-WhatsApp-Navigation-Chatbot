# WhatsApp Navigation Chatbot

A Java Spring Boot backend service that implements a WhatsApp chatbot for navigation assistance. It demonstrates:

- REST API endpoints to receive chat messages  
- Simple rule‑based message processing (`hi`, `help`, `bye`)  
- Persistence of all chats in Firebase Firestore  
- Real WhatsApp messaging via Twilio’s WhatsApp Sandbox  
- Easy deployment to Render (or any cloud provider)

---

## 🚀 Features

- **Message handling**: Process incoming user messages and generate replies  
- **Firestore storage**: Save every user query + bot reply with timestamps  
- **Twilio integration**: Send real WhatsApp messages from your sandbox number  
- **Extensible design**: Swap in Meta Cloud API, add NLP, route lookups, etc.  

---

## 🛠️ Tech Stack

- **Java 17+**  
- **Spring Boot**  
- **Firebase Admin SDK** (Firestore)  
- **Twilio Java SDK** (WhatsApp Sandbox)  
- **Maven**  

---

## 📋 Prerequisites

1. **Java 17 SDK** (or newer)  
2. **Maven 3.6+**  
3. A **Firebase** project with Firestore enabled  
4. **Twilio** account and WhatsApp sandbox configured  
5. **Git** (for cloning and version control)  

---

## ☁️ Deployment
You can deploy to Render, Heroku, or any Java‑friendly host.

Push your code to GitHub.

On Render:

Create a new Web Service.

Connect to your GitHub repo.

Set Build Command: ./mvnw clean package

Set Start Command: java -jar target/chatbot-0.0.1-SNAPSHOT.jar

Add environment variables for Firebase path and Twilio credentials.

Render will build and deploy your bot, giving you a public URL.

