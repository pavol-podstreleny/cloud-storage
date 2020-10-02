# Personal file storage
Web [application](https://personal-storage-app.herokuapp.com/login) that securely stores user files, notes, and credentials.

The application provides the following capabilities:
- Simple File Storage: Upload/download/remove files
- Note Management: Add/update/remove text notes
- Password Management: Save, edit, and delete website credentials.

Following technologies were used to develop the website:

Back-end:
- Java
- Spring Boot
- [H2](https://github.com/h2database/h2database) (in-memory database)
- [MyBatis](https://github.com/mybatis/mybatis-3) (SQL mapper)
- [Thymeleaf](https://www.thymeleaf.org/) (template engine)

Front-end:
- HTML 5
- CSS 3
- JavaScript
- [Sass](https://sass-lang.com/)

## Run web application locally
#### 1) The first step is to clone the repository
```cmd
git clone https://github.com/pavol-podstreleny/cloud-storage.git
```

#### 2) Move into `cloud-storage` folder
```cmd
cd cloud-storage
```
#### 3) Run maven script
Before you run the following script, you should download [JAVA JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) and set up the `JAVA_HOME` environment variable.

Windows:
```cmd
mvnw.cmd clean install
```

Linux:
```cmd
./mvnw clean install
```

#### 4) Run Spring Boot application
Windows: 
```cmd
mvnw.cmd spring-boot:run
```

Linux:
```cmd
./mvnw spring-boot:run
```

Application should run on http://localhost:8080
