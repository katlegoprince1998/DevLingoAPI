

# DevLingoAPI
DevLingoAPI stands as a robust REST API meticulously crafted using Spring Boot and MongoDB. Leveraging Docker, this application has been containerized for seamless deployment and scalability. It offers an array of programming language details, providing developers easy access to comprehensive language-related information.

This is a CRUD System with basic security. I used MongoDB to store and retrieve my data. This project is containerised using Docker.


## Resources

1. api/v1/get
   - This resource will display all data from mongo db.

2. api/v1/create
   - This resouce allows users to create a new document into the database via Postman, Insomnia ect

3. api/v1/get/{name}
   - Users can search for programming languages by name, for instance, user can search for Java and all information related to Java will be returned.

4. api/v1/search
   -This end point enables the user to search through the database by either providing the name, community, year created, created by or usage keys.
   -I used pagination to implement this end point.
   -The aim was to enhance user experience in case they is large dataset to be loaded from the database.

5. api/v1/update/{id}
   - The user can update the data by providing the id of the data he or she wants to update.
  
6. api/v1/delete/{id}
   - The User can delete data by simply providing the id of the data that must be deleted.

# Security

In this project I implemented basic security, I created a default user using In memory user Details manager. For the SecurityFilterChain I only made few configuartions like disabling CSRF, ensuring that all HTTP requests must be authorised. 

# System Architecture

Link : https://drive.google.com/file/d/1FZWj76J_DvW4qXGgM7WgkExjhrYcgCsv/view?usp=sharing
   
