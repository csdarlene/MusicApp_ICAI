#Music App
## Getting Started
### Prerequisites  
- JDK-17
- MYSQL 8.0.31  

*Before you start*
- In MYSQL have a database named musicapp
- Go to META-INF.persistence.xml, change value of line 11 & 12

###Services
**Admin:** Can see, edit, create, and delete all data.  
**Users:** Can see, edit their own data, create specific data.

**Design Patterns:**  
Behavioral Design Patterns: Approval of data  
Creational Design Patterns: Duplicate data  
Structural Design Patterns: Restriction & Summing data  

###Instructions
- Step 1: 
  - Go to pom.xml
  - load maven
- Step 2:
  - Go to application.Application
  - Uncomment the first step (line15-18)
  - Run Application
- Step 3:
  - Go to META-INF.persistence.xml
  - Comment line 15
  - Uncomment line 16
- Step 4:
  - Go to application.Application
  - Comment the first step (line15-18)
  - Uncomment the first step (line21-23)
  - Run Application
- Extra:
  - Go to application.Application
  - Comment the first step (line21-23)
  - Uncomment the first step (line25-36)
  - Run Application