# Setup project
1. Start tomcat server: 
   1. Linux: `sudo /opt/lampp/lampp start`
   2. Windows: Tomcat Monitor App
   3. Test: `localhost:8080`
2. Start MySql Server
   1. Linux:  
   2. Windows: Start MySql80 from Services
3. Make API request to: `http://localhost:8089/api/employees`


# Run / Build / Pack

- `cd ./../udemy-spring-boot`
- `mvn spring-boot:run`
- `curl localhost:8089/api/hello`


# Remarks
- If in EntityManager session query Error like "'from' unexpected" ... 
  - `https://stackoverflow.com/questions/42871038/from-unexpected-when-createquery`
  - Add Hibernate facet under Project Structure - Facets.

### Tools
- Jpa Buddy https://plugins.jetbrains.com/plugin/15075-jpa-buddy/features