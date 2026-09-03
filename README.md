# PrimeNest Realty — Real Estate CRM Backend

A production-oriented **Spring Boot REST API** for managing real estate leads, customers, properties, follow-ups, communication templates, reports, analytics, and secure user authentication.

## 🏠 About PrimeNest Realty

**PrimeNest Realty — Smart Real Estate CRM for Lead & Property Management**

PrimeNest Realty is a full-stack Real Estate CRM designed to help real estate agencies manage leads, customers, properties, follow-ups, reports, and communication from one centralized platform.

The backend provides secure REST APIs consumed by the React frontend.

---

## 🚀 Key Features

* 🔐 JWT-based authentication and role-based security
* 👥 Lead management
* 👤 Customer management
* 🏠 Property management
* 📅 Follow-up management
* 📊 Reports and analytics
* 📧 Email communication
* 💬 WhatsApp/message template support
* 🔎 Search, filtering and pagination support
* ✅ Input validation and exception handling
* 🗄️ MySQL database integration
* 🐳 Docker-ready backend
* 🌐 RESTful API architecture

---

## 🛠️ Technology Stack

### Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA / Hibernate
* REST APIs
* Maven

### Database

* MySQL

### Security

* JWT Authentication
* Password encryption
* Role-based authorization

### Communication

* Gmail / SMTP
* WhatsApp integration support
* Message templates

### Deployment

* Docker
* Maven

---

## 📂 Project Structure


backend/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── RealEstateLeadManager/
│       │       ├── controller/
│       │       ├── entity/
│       │       ├── repository/
│       │       ├── security/
│       │       └── service/
│       │
│       └── resources/
│
├── Dockerfile
├── pom.xml
└── README.md


## 🔑 Main API Modules

| Module            | Purpose                                 |
| ----------------- | --------------------------------------- |
| Authentication    | Login and JWT authentication            |
| Leads             | Create, update, view and manage leads   |
| Customers         | Manage customer information             |
| Properties        | Manage property listings                |
| Follow-ups        | Track scheduled client follow-ups       |
| Reports           | Generate business reports               |
| Analytics         | View CRM business statistics            |
| Email             | Send email communication                |
| Message Templates | Manage reusable communication templates |



## 🔐 Configuration & Security

Sensitive configuration such as:

* Database passwords
* Gmail credentials
* JWT secrets
* API credentials

should be supplied through local configuration/environment variables.

The actual `application.properties` containing sensitive credentials should **not** be committed to GitHub.

A safe configuration template is provided as:


src/main/resources/application.properties.example


## ▶️ Running the Backend Locally

### 1. Clone the repository


git clone https://github.com/urvi2501/realestate-lead-manager-backend.git


### 2. Open the backend directory


cd realestate-lead-manager-backend

### 3. Configure application properties

Create your local:


src/main/resources/application.properties


using the example configuration provided in:


src/main/resources/application.properties.example


Add your own database and service credentials.

### 4. Start the application

Windows:


.\mvnw.cmd spring-boot:run


The backend runs on:


http://https://realestate-lead-manager-backend-production.up.railway.app




## 🐳 Docker

The project includes a `Dockerfile` for containerized deployment.

Build the image:


docker build -t primenest-realty-backend .

Run the container:


docker run -p 8080:8080 primenest-realty-backend


Database configuration should be supplied according to the deployment environment.



## 🔗 Frontend

The backend is designed to work with the PrimeNest Realty React frontend.

Frontend repository:

**realestate-lead-manager**


## 💼 Business Use Case

PrimeNest Realty can be customized for:

* Real estate agencies
* Property consultants
* Independent brokers
* Builders and developers
* Property sales teams
* Rental management businesses

The system can be further customized with company branding, workflows, fields, reports and integrations based on individual business requirements.



## 🔮 Possible Future Enhancements

* AWS deployment
* Advanced dashboard analytics
* Automated email notifications
* WhatsApp Cloud API integration
* Advanced role/permission management
* Cloud database
* Automated backups
* CI/CD pipeline
* Multi-company / SaaS architecture
* Mobile application



## 👩‍💻 Project

**PrimeNest Realty — Real Estate CRM**

Built with:

**Java + Spring Boot + Spring Security + JPA/Hibernate + MySQL + React**


## 📄 License

This project is intended for demonstration, customization and commercial project development.


