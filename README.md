# Personal Blog - Java Spring Boot Application

This is a simple personal blog built with Java Spring Boot. It has two sections: a Guest section where visitors can read articles and an Admin section for managing articles (add, edit, delete).

Project url : https://github.com/sreekarsai193/BloggingApplication
## Features

- **Guest Section**: View the list of articles and read individual articles.
- **Admin Section**: Add, edit, and delete articles (basic authentication for access).
- Articles are stored in the filesystem (JSON or Markdown format).

### Prerequisites

Ensure that you have the following installed on your system:
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or compatible version.
- [Git](https://git-scm.com/downloads) to clone the repository.

### Setup

1. **Clone the repository**:

   ```
   git clone https://github.com/your-username/your-blog-repo.git
   cd your-blog-repo
   ```
## Run the Project

To run the Spring Boot application, use the following command:

### If you are in a Unix-like terminal (Linux, macOS):
```
   ./mvnw spring-boot:run
```
### If you are in Windows CMD:
```
mvnw.cmd spring-boot:run
```
 
## Access the pages

### Guest Section

- **Home Page**: 
  - **URL**: `http://localhost:8080/home`
  - **Description**: Displays a list of all articles published on the blog.

- **Article Page**: 
  - **URL**: `http://localhost:8080/article/{title}`
  - **Description**: Displays the details of a specific article based on the title.

### Admin Section

- **Admin Dashboard**: 
  - **URL**: `http://localhost:8080/admin`
  - **Description**: Prompts for a username and password. 
    - **Username**: `admin`
    - **Password**: `adminpassword`
  - **Features**: Displays all articles with options to edit, delete, and add new articles.

- **Edit Article Page**: 
  - **URL**: `http://localhost:8080/edit/{title}`
  - **Description**: Takes you to the editing page of a specific article. 
    - **Note**: You cannot edit the title of the article as it is the primary key used to identify the article.

- **New Article Page**: 
  - **URL**: `http://localhost:8080/new`
  - **Description**: Takes you to a page where you can create a new article. 
    - **Note**: You cannot add an article with an existing title.



    
   
   
