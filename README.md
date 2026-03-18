# Student Management Program

Student Management Program is a JavaFX desktop application for managing academic records through a menu-driven interface. The project is organized around core university-style entities such as students, departments, instructors, courses, and enrollments, with support for reporting and data validation workflows.

## Overview

The application is structured as a modular desktop system with clear package separation for:

- application bootstrap and shared runtime context
- window launching and shell-level UI
- top-level menu construction and shell-level navigation wiring
- custom collection support for in-memory catalogs
- domain models for academic records
- file-based persistence handlers
- JavaFX feature modules
- reporting
- service integrations

The long-term goal is to provide a clean desktop experience for managing and reviewing academic data from a single application window.

## Current Foundation

The current version includes:

- application startup flow
- shared application context
- JavaFX shell launcher
- top-level menu factory and shell controller
- custom generic list collection
- core domain models for students, departments, instructors, courses, enrollments, and reports
- foundational handler contract for persistence operations
- student and department persistence handlers for flat-file loading and saving

This stage expands the persistence layer with the first concrete handlers while keeping the broader CRUD feature modules, reporting screens, shared UI helpers, and service integrations for later pushes.

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
│       ├── handler/
│       │   └── EntityHandler.java
│       ├── model/
│       │   ├── Course.java
│       │   ├── Department.java
│       │   ├── Enrollment.java
│       │   ├── Instructor.java
│       │   ├── Report.java
│       │   └── Student.java
│       └── ui/
│           └── shell/
│               ├── AppWindowLauncher.java
│               ├── MainMenuController.java
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
