**Project Title:** Apply for Me.

**Description:**

You work at a remote company and you earn $1k a month. You are very happy. But you sometimes think - what if there are better jobs out there for me? But it's too much work to apply. In comes: ApplyForMe. A service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.

**References**
- [Entity Relational Diagram](https://github.com/teamhydraulic/apply-for-me-backend-architectural-design/blob/main/docs/updated_db_design.png)
- [Sequence Diagram](https://github.com/teamhydraulic/apply-for-me-backend-architectural-design/blob/main/docs/sequence-diagram.png)
- [Class Diagram](https://github.com/teamhydraulic/apply-for-me-backend-architectural-design/blob/main/docs/ClassdiagramPNG.PNG)
- [SQL Schema](https://github.com/workshopapps/applyforme.web/blob/main/Apply-For-Me-Api/src/main/resources/schema.sql)

**Project Development Requirement**

- Programming Language: Java
- Runtime JDK 11
- Database: MySQL
- API Documentation: Postman and OpenAPI
- SQL Viewer or GUI: Beekeeper Studio or MySQL Workbench
- IDE: IntelliJ or VS Code
- Lombok

**Downloads and References**
- [Enable Annotation Processing Lombok](https://www.google.com/search?q=enable+annotation+processing+lombok&oq=enab&aqs=chrome.0.69i59j69i57j69i59l2j0i433i512j46i433i512j69i65l2.1915j0j7&sourceid=chrome&ie=UTF-8)
- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html "JDK 11")
- [Postman Docs](https://www.postman.com/maintenance-physicist-41351297/workspace/team-hydraulic/environment/24341349-9e7a447a-5ea3-4ccb-9446-4a9865541c64 "Postman Docs")
- [IntelliJ](https://www.jetbrains.com/idea/download/ "IntelliJ")
- [Visual Studio Code](https://code.visualstudio.com/download "Visual Studio Code")
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/ "Workbench")
- [Beekeeper Studio](https://www.beekeeperstudio.io/get "Beekeeper Studio")

#### VCS Branches
- Development
- Staging
- Main

**NB:** All collaborator or member push will be made to development branch

#### Branch Naming Style Guide

**Feature**
- commit message :- feat:summary-of-task or feature/summary-of-task
- branch name :- feat/branch-name or feature/branch-name

**Revision**
- commit message :- revision:summary-of-revision or revision/summary-of-revision
- branch name :- revision/branch-name

**Bug Fix**

- commit message: fix:summary-of-fix or bug-fix:summary-of-fix
- branch name: fix/branch-name or bug-fix/branch-name

**Code Cleanup**

- commit message :- chore:summary-of-cleanup 
- branch name:- chore/branch-name

**Reference**
- [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/ "Conventional Commits")
- [Commit and Branch Practice](https://gist.github.com/digitaljhelms/4287848)

#### Pull Requests Style Guide

##### Issue
- QA engineer can't test phone verification because twilo not sending sms on staging

##### What has changed:
- changed line 97 on utils.js file
- restricted sending of sms to just staging and production

##### What reviewers should know:
- used the ternary expression
- rename adminObject to adminService


#### Code Convention and Naming Standards
- Controller e.g. ApplierController or AuthenticationController or AuthController
- Service e.g. ApplierService or EmailService
- Service Implementation e.g. ApplierServiceImpl or EmailServiceImpl
- Repository e.g. ApplierRepository
- Repository Implementation e.g. ApplierRepositoryImpl
- Validator e.g. EmailAddressValidator
- Validator Implementation .e.g EmailAddressValidatorImpl
- Utility e.g. ApplierUtil or GlobalUtils
- Configuration e.g. SecurityConfig
- Exception e.g. ApplierNotFoundException or EmailAddressNotFoundException or EmailAddressExistsException

**Description**



- Controller class should be annotated with @RestController and @RequestMapping. The base mapping url of any controller should be the name of the entity they are creating a controller for. For instance, if you are creating an AuthenticationController, the base url should be @RequestMapping("/authentication") or @RequestMapping("/auth"). This class will contain HTTP Request handling logic.

- Service class should be annotated with @Service. This class will contain business related logic for Apply For me. Exceptions should be throwned in this classes.

- Repository class should be annotated with @Repository. This class will contain logic that relates to data persistence and management.


**Spring Dependency Injection**

- Constructor Injection
- @Autowired Injection



**Reference**
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html "Google Java Style Guide")


**Tutorials**
- [Getting started with Git: a comprehensive guide for newbies](https://codegym.cc/groups/posts/379-getting-started-with-git-a-comprehensive-guide-for-newbies "Getting started with Git: a comprehensive guide for newbies")
- [Building a RESTful service on Spring Boot](https://codegym.cc/groups/posts/295-overview-of-rest-part-3-building-a-restful-service-on-spring-boot "Building a RESTful service on Spring Boot")