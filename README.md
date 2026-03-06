# Student Management Program

Student Management Program is a JavaFX desktop application for managing academic records through a menu-driven interface. The project is organized around core university-style entities such as students, departments, instructors, courses, and enrollments, with support for reporting and data validation workflows.

## Overview

The application is structured as a modular desktop system with clear package separation for:

- application bootstrap and shared runtime context
- window launching and shell-level UI
- top-level menu construction and shell-level navigation wiring
- custom collection support for in-memory catalogs
- domain models
- file-based persistence handlers
- JavaFX feature modules
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
│       ├── app/
│       │   ├── AppBootstrap.java
│       │   ├── AppContext.java
│       │   └── Main.java
│       ├── collection/
│       │   └── MyGenericList.java
│       └── ui/
│           └── shell/
│               ├── AppWindowLauncher.java
│               └── MainMenuFactory.java
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

This repository follows a package-based organization and is intended to grow into a full desktop student information system with separate modules for data management, reporting, and validation.
