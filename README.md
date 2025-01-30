
# **MSC airline** 🏢  🛫🛬

---

![CI](https://github.com/monicasimoF5/mscAirline/actions/workflows/ci.yml/badge.svg)

---

## 📝 **Introduction**
Welcome to the MSC airline project!  This is a Spring Boot backend application designed to manage **airports**, **flights**, **reservations**, **users** and user **profiles** through CRUD operations..

---
## 🎯 **Project objectives:**

- **Vuelos disponibles** ✈️
- **Estado de los vuelos** 🛫🛬
- **Gestión de pasajeros** 🛄
- **Aeropuertos** 🏢

---

## 📦 **erDiagram**
![erDiagram.jpg](utils/erDiagram.jpg)

---

## 📦 **UML Diagram**
![UMLdiagram.jpg](utils/UMLdiagram.jpg)

---

## 📊 **Broad**
![Trello.jpg](utils/Trello.jpg)

---

## 🗂️  **Files Structure**

    |--- .idea
    |--- src
        |--- main
            |--- java
                |---org.msc.mscAirline
                        |--- airports
                            |--- Airport
                            |--- AirportController
                            |--- AirportMapper
                            |--- AirportRepository
                            |--- AirportRequest
                            |--- AirportResponse
                            |--- AirportService
                        |--- authentication
                            |--- AuthenticationController
                        |--- config
                            |--- SecurityConfiguration
                        |--- exceptions
                            |--- AirlineAlreadyExistsException
                            |--- AirlinetNotFoundException
                            |--- GlobalExceptionHandler
                        |--- flights
                            |--- Flights
                            |--- FlightsController
                            |--- FlightsMapper
                            |--- FlightsRepository
                            |--- FlightsRequest
                            |--- FlightsResponse
                            |--- FlightsService
                            |--- FlightsValidationException
                        |--- home
                            |--- HomeController
                        |--- profiles
                            |--- Profile
                            |--- ProfileController
                            |--- ProfileMapper
                            |--- ProfileRepository
                            |--- ProfileRequest
                            |--- ProfileResponse
                            |--- ProfileService
                        |--- register
                            |--- RegisterController
                            |--- RegisterService
                        |--- reservations
                            |--- Reservations
                            |--- ReservationsController
                            |--- ReservationsMapper
                            |--- ReservationsRepository
                            |--- ReservationsRequest
                            |--- ReservationsResponse
                            |--- ReservationsService
                            |--- ReservationsValidationException
                        |--- roles
                            |--- Role
                            |--- RoleRepository
                            |--- RoleService
                        |--- security
                            |--- JpaUserDetailService
                            |--- SecurityUser
                        |--- users
                            |--- User
                            |--- UserController
                            |--- UserMapper
                            |--- UserRepository
                            |--- UserRequest
                            |--- UserResponse
                            |--- UserService
                        |--- MscAirlineApplication
            |--- resources
                |--- META-INF
                    |--- additional-spring-configuration-metadata.json
                |--- application.properties
                |--- application-dev.properties
                |--- application-test.properties
                |--- dataH2.sql
                |--- dataPostgres.sql
        |--- test
           |--- java
               |---org.msc.mscAirline
                        |--- airports
                            |--- AirportServiceTest
                        |--- MscAirlineApplicationTests

---

## 💻 Technology Stack:

<img src="https://img.shields.io/badge/Intellij%20Idea-000?logo=intellij-idea&amp;style=for-the-badge"/> 
<img src= "https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white"/> 
<img src= "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/> <img src= "https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white"/> 
<img src="https://img.shields.io/badge/-Apache Maven-C71A36?style=flat&logo=apachemaven&logoColor=white"/> 
<img src="https://img.shields.io/badge/-Hibernate-59666C?style=flat&logo=hibernate&logoColor=white"/>
<img src= "https://img.shields.io/badge/-Postman-FF6C37?style=flat&logo=postman&logoColor=white"/> 
<img src="https://img.shields.io/badge/-MySQL-4479A1?style=flat&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/-Docker-2496ED?style=flat&logo=docker&logoColor=white"/> 
<img src="https://img.shields.io/badge/-PostgreSQL-4169E1?style=flat&logo=postgresql&logoColor=white"/>
<img src="https://img.shields.io/badge/-Trello-0052CC?style=flat&logo=trello&logoColor=white"/>
<img src="https://img.shields.io/badge/Lucid-282C33?logo=lucid&logoColor=fff&style=for-the-badge"/> 
<img src="https://img.shields.io/badge/-Mermaid-FF3670?style=flat&logo=mermaid&logoColor=white"/> 

---

## 🌐 Author

### **Mònica Simó**
[<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/monicasimoF5)  
[<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/mónica-simó/)

