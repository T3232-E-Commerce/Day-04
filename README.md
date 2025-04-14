# Student and Course Management API

This project is a RESTful API for managing student and course information using Spring Boot. It provides CRUD (Create, Read, Update, Delete) operations for Student and Course entities.

## Architecture

The project follows an object-oriented design with inheritance to minimize code duplication:

- `CRUDcontroller<K,T>`: A generic controller that provides basic CRUD operations for any entity type
- `StudentController`: Extends CRUDcontroller for Student-specific operations
- `CourseController`: Extends CRUDcontroller for Course-specific operations

## API Endpoints

### Student Endpoints

All student endpoints are under `/app` base path.

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/app/`  | Get all students |
| GET    | `/app/{id}` | Get student by registration number |
| POST   | `/app/`  | Add a new student |
| PUT    | `/app/{id}` | Update an existing student |
| DELETE | `/app/{id}` | Delete a student |

### Course Endpoints

All course endpoints are under `/api/courses` base path.

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/courses/` | Get all courses |
| GET    | `/api/courses/{id}` | Get course by ID |
| POST   | `/api/courses/` | Add a new course |
| PUT    | `/api/courses/{id}` | Update an existing course |
| DELETE | `/api/courses/{id}` | Delete a course |

## Models

### Student

```java
public class Student {
    private String regNo;
    private String name;
    private int age;
    private String course;
    private double gpa;
    // Getters and setters
}
```

### Course

```java
public class Course {
    private String courseId;
    private String name;
    private int credit;
    // Getters and setters
}
```

## Sample Usage

### Get All Students

```
GET /app/
```

Response:
```json
{
  "2020ICT07": {
    "regNo": "2020ICT07",
    "name": "Udara",
    "age": 21,
    "course": "ICT",
    "gpa": 3.9
  },
  "2020ICT06": {
    "regNo": "2020ICT06",
    "name": "Jello",
    "age": 27,
    "course": "ICT",
    "gpa": 3.2
  },
  "2020ICT91": {
    "regNo": "2020ICT91",
    "name": "Dilmy",
    "age": 32,
    "course": "ICT",
    "gpa": 2.9
  }
}
```

### Add New Course

```
POST /api/courses/
```

Request body:
```json
{
  "courseId": "ICT04",
  "name": "Mobile App Development",
  "credit": 4
}
```

## Error Handling

- If a requested resource is not found, the API returns `null` (this could be enhanced with proper HTTP status codes)
- The API validates request data before processing

## Setup and Running

1. Clone the repository
2. Make sure you have Maven and JDK installed
3. Run `mvn spring-boot:run` to start the application
4. Access the API at `http://localhost:8080`

## Troubleshooting

Common issues:

- **Ambiguous mapping errors**: Ensure that method signatures in child controllers properly override parent controller methods using the `@Override` annotation
- **404 errors**: Check that the request URL matches the controller's `@RequestMapping` path
