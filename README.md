# Prepare CLI  

Prepare CLI is a command-line interface (CLI) application designed to help users prepare for exams by providing a structured way to manage questions, chapters, subjects, and field models. The application is built using Java, Hibernate, and MySQL.  

## Features  

- User authentication (login and registration).  
- Profile management (view and update user details).  
- Field model selection for exam preparation.  
- Subject and chapter selection within a field model.  
- Question-based tests with multiple-choice answers.  
- Scoring system for test performance.  

## Project Structure  

The project follows a modular structure with the following key components:  

```
src/  
├── main/  
│   ├── java/  
│   │   ├── com/  
│   │   │   ├── dao/  
│   │   │   ├── entities/  
│   │   │   ├── helpers/  
│   │   │   ├── services/  
│   │   │   ├── util/  
│   │   │   └── vtech/  
│   ├── resources/  
│   │   └── hibernate.cfg.xml  
├── test/  
│   ├── java/  
│   │   └── com/  
│   │       └── vtech/  
```  

### Key Directories  

- **com.dao**: Contains DAO interfaces and their implementations for database operations.  
- **com.entities**: Defines the entity classes mapped to database tables.  
- **com.helpers**: Contains helper classes and constants.  
- **com.services**: Contains service interfaces and their implementations for business logic.  
- **com.util**: Utility classes, including Hibernate session management.  
- **com.vtech**: Contains the main application logic and CLI operations.  

## Prerequisites  

- Java 8 or higher.  
- MySQL database.  
- Maven for dependency management.  

## Setup  

1. Clone the repository:  
    ```bash  
    git clone <repository-url>  
    cd Prepare_CLI  
    ```  

2. Configure the database:  
    - Create a MySQL database named `prepare_cli`.  
    - Import the `prepare_cli.sql` file located in the project root.  

3. Update the Hibernate configuration:  
    - Open `src/main/resources/hibernate.cfg.xml`.  
    - Update the database connection details (username, password, etc.).  

4. Build the project:  
    ```bash  
    mvn clean install  
    ```  

5. Run the application:  
    ```bash  
    java -jar target/Prepare_CLI-1.0-SNAPSHOT.jar  
    ```  

## Usage  

1. **Login or Register**:  
    - Use the CLI to log in or create a new account.  

2. **Profile Management**:  
    - View or update your profile details.  

3. **Prepare Section**:  
    - Select a field model, subject, and chapter.  
    - Take a test and view your score.  

## Technologies Used  

- **Java**: Core programming language.  
- **Hibernate**: ORM framework for database interactions.  
- **MySQL**: Relational database for storing data.  
- **Maven**: Dependency and build management.  

## Database Schema  

The database consists of the following tables:  

- `user`: Stores user details.  
- `field_model`: Represents different fields of study.  
- `subject`: Represents subjects within a field model.  
- `chapter`: Represents chapters within a subject.  
- `question`: Stores questions for tests.  

### Relationships:
- `field_model` is linked to `subject` via a foreign key.
- `subject` is linked to `chapter` via a foreign key.
- `chapter` is linked to `question` via a foreign key.

## Contributing  

Contributions are welcome! Please follow these steps:  

1. Fork the repository.  
2. Create a new branch for your feature or bug fix.  
3. Commit your changes and push them to your fork.  
4. Submit a pull request.  

## License  

This project is private and not open for public use or distribution.

## Contact

For any questions or feedback, feel free to reach out by sending a message on [GitHub](https://github.com/TagCoding223).
