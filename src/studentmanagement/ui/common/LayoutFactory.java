package studentmanagement.ui.common;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

public final class LayoutFactory {

 private LayoutFactory() {

 }

 public static GridPane createFormGrid() {

 GridPane grid = new GridPane();

 grid.setHgap(10);

 grid.setVgap(8);

 grid.setPadding(new Insets(10, 10, 10, 10));

 return grid;

 }

 public static void showCentered(BorderPane borderPane, GridPane grid) {

 grid.setAlignment(Pos.CENTER);

 borderPane.setCenter(grid);

 }

}
