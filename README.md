# 🚀 Nivora Ask

> A scalable, event-driven Q&A backend built with Spring Boot, Kafka, Elasticsearch, and MongoDB.

---

## 📌 Overview

**Nivora Ask** is a high-performance backend system for a community-driven Q&A platform (similar to StackOverflow).
It is designed with **scalability, performance, and clean architecture** in mind.

> ⚠️ **Note:**
> This project is configured for **local development only**:
>
> * MongoDB runs locally as the primary database
> * Kafka runs on `localhost:9092`
> * Elasticsearch runs on `localhost:9200`
>
> Docker and cloud deployment are **not included** at this stage.
> The focus is on **backend architecture and system design**, not deployment.

---

## 🧠 Architecture

Nivora Ask follows a **layered + event-driven architecture**:

```
Controller → Service → Adapter → Repository → Database
                        ↓
                    Kafka (Async Events)
                        ↓
                  Elasticsearch (Search)
```

### Key Concepts:

* **Clean architecture separation** (DTO, Adapter, Service layers)
* **Event-driven system** using Kafka
* **Search engine integration** using Elasticsearch
* **Reactive programming** for high scalability

---

## ⚙️ Tech Stack

### Backend

* Java 17+ / 21+
* Spring Boot
* Spring WebFlux (Reactive)

### Database

* MongoDB (Primary Database)

### Messaging

* Apache Kafka (Event streaming)

### Search

* Elasticsearch (Full-text search)

### Build Tool

* Gradle

---

## ✨ Features

### 🧾 Question System

* Create and retrieve questions
* Cursor-based pagination for efficient listing
* Offset-based pagination for search

### 💬 Answer System

* Add answers to questions
* Fetch all answers for a specific question

### ❤️ Engagement System

* Like / Dislike on questions and answers
* Async view count tracking using Kafka

### 🔍 Search System

* Full-text search using Elasticsearch
* Reactive, non-blocking search queries

### ⚡ Event-Driven Design

* Kafka producer for events (e.g., view tracking)
* Kafka consumer for async processing
* Improved performance and scalability

---

## 🔄 Event Flow (View Count Example)

```
User views question
        ↓
Kafka Producer sends event
        ↓
Kafka Consumer processes event
        ↓
View count updated asynchronously
```

---

## 📁 Project Structure

```
com.nivora.ask
│
├── controllers      # REST APIs
├── service          # Business logic
├── adapter          # DTO ↔ Entity mapping
├── repo             # Data access layer
├── dto              # Request/Response objects
├── model            # Domain entities
├── config           # Configurations (Kafka, etc.)
├── producers        # Kafka producers
├── consumers        # Kafka consumers
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Harshjha002/Nivora-Ask.git
cd nivora-ask
```

---

### 2️⃣ Configure Environment Variables

Create a `.env` file:

```env
DB_URL=your_database_url
DB_USERNAME=your_username
DB_PASSWORD=your_password
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
ELASTICSEARCH_URL=localhost:9200
```

---

### 3️⃣ Start Dependencies (Locally)

Make sure the following services are running locally:

* MongoDB → `localhost:27017`
* Kafka → `localhost:9092`
* Elasticsearch → `localhost:9200`

> You can start these using local installations or any method you prefer.

---

### 4️⃣ Run the Application

```bash
./gradlew bootRun
```

---

## 🧪 API Highlights

### Create Question

```
POST /questions
```

### Get Questions (Cursor Pagination)

```
GET /questions?cursor=xyz
```

### Search Questions

```
GET /questions/search?q=java
```

### Add Answer

```
POST /answers
```

### Like / Dislike

```
POST /likes
```

---

## 🚀 Scalability Highlights

* **Kafka-based async processing** → handles high traffic
* **Elasticsearch** → fast search on large datasets
* **Reactive APIs** → non-blocking performance
* **Cursor pagination** → efficient large dataset traversal

---

## 🎯 Future Improvements

* Authentication & Authorization (JWT)
* Redis caching layer
* Notification system (Kafka events)
* Ranking algorithm for search
* Microservices architecture

---

## 👨‍💻 Author

**Harsh Jha**
Backend Developer | Building **Nivora Ecosystem**

---

## ⭐ Final Note

This project demonstrates:

* Strong backend fundamentals
* Scalable system design
* Real-world architecture patterns

> Built as part of the **Nivora ecosystem vision** 🚀
