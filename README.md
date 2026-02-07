# chatbot-service

# Spring Boot Ollama LLM Microservice

## 📌 Overview
This project is a full-stack AI chatbot application built using:

- React.js frontend (Chat UI)
- Spring Boot 3 microservice backend
- Ollama Local LLM (CodeLlama / Llama3 / Mistral etc.)

The Spring Boot service receives user queries from the React UI, forwards them to the locally running Ollama LLM, and returns the generated response back to the frontend.



## 🏗️ Architecture

React UI → Spring Boot Microservice → Ollama LLM → Spring Boot → React UI

### Flow:
1. User enters prompt in React UI
2. Request sent to Spring Boot REST API
3. Backend forwards request to Ollama local API
4. LLM generates response
5. Response returned to UI


## Features
- REST API(http://localhost:8080/api/chat) endpoint for React.js frontend
- Sends user queries to Ollama LLM(API:http://localhost:11434/api/generate) and returns responses
- Handles JSON request and response
- Basic logging and error handling


## Prerequisites
- Java 17+
- Gradle
- Spring Boot 3.x
- Ollama API access
- Internet access for Ollama API requests

## 🚀 Tech Stack

### Frontend
- React.js
- Fetch API
- Modern Chat UI

### Backend
- Java 17+
- Spring Boot 3
- REST APIs
- WebClient

### AI Layer
- Ollama Local LLM
- CodeLlama / Llama3 / Mistral Models

### Build Tools
- Gradle
gradle clean build --> command for building service in local
gradle bootRun --> command for running application in local

## Installation
1. Clone the repository:
git clone https://github.com/NarasimhaBora/chatbot-service.git




