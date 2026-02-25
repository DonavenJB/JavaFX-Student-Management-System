# Student Management Program

Student Management Program is a JavaFX desktop application for managing academic records through a menu-driven interface. The project is organized around core university-style entities such as students, departments, instructors, courses, and enrollments, with support for reporting and data validation workflows.

## Overview

The application is being built as a modular desktop system with clear package separation for:

- application bootstrap and shared context
- domain models
- file-based persistence handlers
- JavaFX user interface modules
- reporting
- service integrations

The long-term goal is to provide a clean desktop experience for managing and reviewing academic data from a single application window.

## Planned Functional Areas

- Student management
- Department management
- Instructor management
- Course management
- Enrollment management
- Academic reports
- ZIP-based location lookup for student records

## Technology

- Java
- JavaFX
- Gson
- Eclipse project structure

## Project Layout

```text
StudentManagementProgram/
├── src/
│   └── studentmanagement/
│       └── app/
│           ├── AppBootstrap.java
│           └── Main.java
├── .classpath
├── .gitignore
├── .project
├── DEPENDENCIES.md
└── README.md
```

## Running in Eclipse

1. Import the folder as an existing Eclipse project.
2. Add the JavaFX SDK to the project build path or module path.
3. Run `studentmanagement.app.Main` as a JavaFX application.

## Notes

This repository uses standard package-based organization and is intended to grow into a full desktop student information system with separate modules for data management, reporting, and validation.
