# Setup project
1. Start tomcat server: `sudo /opt/lampp/lampp start`
2. Make API request to: `http://localhost:8089/api/employees`


# Remarks
- If in EntityManager session query Error like "'from' unexpected" ... 
  - `https://stackoverflow.com/questions/42871038/from-unexpected-when-createquery`
  - Add Hibernate facet under Project Structure - Facets.