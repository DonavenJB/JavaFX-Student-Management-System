# Dependencies

## Required
- Java 17 or later
- JavaFX SDK
- Gson

## Eclipse Setup

To run the JavaFX application in Eclipse:

1. Import the project as an existing Eclipse Java project.
2. Add the JavaFX SDK libraries to the build path.
3. Configure VM arguments similar to the following if needed:

```text
--module-path "C:/path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
```

4. Add `gson-2.x.x.jar` to the project build path when Gson-backed features are added to the workspace.

## Current Application Entry Point
- `studentmanagement.app.Main`
