<div align="center">

#  iOne

**Empowering seamless management for your business success**  
*A modern Point of Sale system built with Spring Boot*

<br>

###  Tech Stack

![Java](https://img.shields.io/badge/Java-26.3%25-007396?style=for-the-badge&logo=java&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML-69.5%25-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS-4.2%25-1572B6?style=for-the-badge&logo=css3&logoColor=white)

<br>

###  Built With

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Select2](https://img.shields.io/badge/Select2-FF5722?style=for-the-badge)

</div>


---

  

## Table of Contents

  

- [Overview](#overview)

- [Getting Started](#getting-started)

- [Prerequisites](#prerequisites)

- [Installation](#installation)

- [Usage](#usage)

- [Testing](#testing)

  

---

  

## Overview

  

**iOne** is a powerful Point of Sale system built with Spring Boot that streamlines inventory and customer management.

  

### Why iOne?

  

This project provides a complete POS solution with modern web technologies. Key features include:

  

- 🎨 **Spring Boot Backend:** Robust Java backend with Spring MVC architecture

- 📊 **Thymeleaf Templates:** Dynamic server-side rendering for all views

- 🖥️ **Modern UI:** Clean responsive interface built with Bootstrap 5

- 🔍 **Enhanced UX:** Select2 for advanced dropdown functionality

- 🔒 **Data Management:** JPA repositories for efficient database operations

- ✅ **Testing:** Comprehensive test coverage including integration tests

  

---

  

## Getting Started

  

### Prerequisites

  

- Java JDK 17+

- Maven 3.8+

- MySQL 8.0+ (or your preferred database)

  

### Installation

  

1. **Clone the repository:**

```sh

git clone https://github.com/Nethwindu/iOne

```
  
  

2.  **Navigate to the project directory:**

  

```sh

cd iOne

```

  

3. **Configure database:**

Update `src/main/resources/application.properties` with your MySQL credentials:

  

```

spring.datasource.url=jdbc:mysql://localhost:3306/your_database

spring.datasource.username=your_username

spring.datasource.password=your_password

```

  

4. **Build the project:**

  

```sh

mvn clean install

```

  

---

  

### Usage

  

Run the application:

  

```sh

mvn spring-boot:run

```

  

Access the application at:

`http://localhost:8080`

  

---

  

### Testing

  

Run all tests:

  

```sh

mvn test

```

  

---

  

[⬆ Return to top](#ione)

