# Setup project
1. Start tomcat server: 
   1. Linux: `sudo /opt/lampp/lampp start`
   2. Windows: Tomcat Monitor App
   3. Test: `localhost:8080`
2. Start MySql Server
   1. Linux:  
   2. Windows: Start MySql80 from Services
3. API request (custom endpoint): `http://localhost:8089/api/employees`
4. API request (spring-data-rest endpoints): `http://localhost:8089/employees`


-------------------------------------------------------------
# Run / Build / Pack

- `cd ./../udemy-spring-boot`
- `mvn spring-boot:run`
- `curl localhost:8089/api/hello`


-------------------------------------------------------------
# Remarks

## IoC / DI
- Prioritize beans of same type
  - `@Primary` and/or `@Qualifier("<BeanID>")` where BeanId is classsname with lower first case
  - https://www.baeldung.com/spring-primary


## ORM 
- EntityManager and native Hibernate API (**HQL**)
- EntityManager and standard JPA API (**JPQL**)
- Spring Data JPA  (**Repository Pattern**)

## Spring Data JPA
- **@Transactional** not necessary, implemented by Spring Data
- **Pagination** / **Sorting**
  - https://www.bezkoder.com/spring-boot-pagination-sorting-example/


##  Spring Data REST
- Autogenerate CRUD endpoints
- only need:
    - Entity
    - Repository (like in spring-data-jpa)
    - maven.pom dependency





## Jackson (De)Serializer
- works automatically in background
- lives in component: **????**
- **Customization**
  - https://www.baeldung.com/jackson-json-view-annotation
  - https://www.baeldung.com/spring-boot-customize-jackson-objectmapper
  - https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring
  

## Actuator
- `http://localhost:8089/actuator/health`
- `http://localhost:8089/actuator/info`
- for configuration: 
  -   https://www.baeldung.com/spring-boot-actuator-enable-endpoints



-------------------------------------------------------------
# Remarks
- If in EntityManager session query Error like "'from' unexpected" ... 
  - `https://stackoverflow.com/questions/42871038/from-unexpected-when-createquery`
  - Add Hibernate facet under Project Structure - Facets.

### Tools
- Jpa Buddy https://plugins.jetbrains.com/plugin/15075-jpa-buddy/features