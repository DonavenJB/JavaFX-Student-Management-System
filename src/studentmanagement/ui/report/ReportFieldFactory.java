package studentmanagement.ui.report;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Node;

import javafx.scene.control.Button;

import javafx.scene.control.Control;

import javafx.scene.control.Label;

import javafx.scene.control.ScrollPane;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;

import javafx.scene.control.TitledPane;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import studentmanagement.ui.common.LayoutFactory;

public final class ReportFieldFactory {

 private ReportFieldFactory() {

 }

 public static GridPane createRootPane() {

 GridPane root = LayoutFactory.createFormGrid();

 root.setAlignment(Pos.CENTER);

 return root;

 }

 public static VBox createMainColumn() {

 VBox mainColumn = new VBox(15);

 mainColumn.setAlignment(Pos.TOP_CENTER);

 return mainColumn;

 }

 public static Label createPageTitle(String text) {

 Label pageTitle = new Label(text);

 pageTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

 return pageTitle;

 }

 public static GridPane createTwoColumnFilterGrid() {

 GridPane filterGrid = LayoutFactory.createFormGrid();

 filterGrid.setAlignment(Pos.CENTER);

 return filterGrid;

 }

 public static GridPane createFourColumnSummaryGrid() {

 GridPane grid = LayoutFactory.createFormGrid();

 grid.setVgap(8);

 grid.setAlignment(Pos.CENTER);

 return grid;

 }

 public static HBox centeredButtons(Button... buttons) {

 HBox row = new HBox(10);

 row.setAlignment(Pos.CENTER);

 row.getChildren().addAll(buttons);

 return row;

 }

 public static TitledPane titledPane(String title, Node content, double width) {

 TitledPane pane = new TitledPane(title, content);

 pane.setCollapsible(false);

 pane.setAnimated(false);

 pane.setPrefWidth(width);

 return pane;

 }

 public static ScrollPane resultsScrollPane(VBox resultsBox) {

 ScrollPane scrollPane = new ScrollPane(resultsBox);

 scrollPane.setFitToWidth(true);

 scrollPane.setPrefViewportHeight(240);

 scrollPane.setPrefWidth(860);

 return scrollPane;

 }

 public static VBox createResultsBoxWithPlaceholder(String message) {

 VBox resultsBox = new VBox();

 resultsBox.setSpacing(0);

 resultsBox.setFillWidth(true);

 resultsBox.setAlignment(Pos.TOP_CENTER);

 Label placeholder = new Label(message);

 placeholder.setPadding(new Insets(12, 12, 12, 12));

 resultsBox.getChildren().add(placeholder);

 return resultsBox;

 }

 public static void resetResultsPlaceholder(VBox resultsBox, String message) {

 resultsBox.getChildren().clear();

 Label placeholder = new Label(message);

 placeholder.setPadding(new Insets(12, 12, 12, 12));

 resultsBox.getChildren().add(placeholder);

 }

 public static TextField summaryField(String promptText) {

 TextField field = new TextField();

 field.setEditable(false);

 field.setFocusTraversable(false);

 field.setPromptText(promptText);

 field.setPrefWidth(220);

 field.setStyle("-fx-control-inner-background: #eeeeee; -fx-opacity: 1;");

 return field;

 }

 public static TextArea summaryArea(String promptText) {

 TextArea area = new TextArea();

 area.setEditable(false);

 area.setWrapText(true);

 area.setFocusTraversable(false);

 area.setPromptText(promptText);

 area.setPrefColumnCount(20);

 area.setPrefRowCount(2);

 area.setStyle("-fx-control-inner-background: #eeeeee; -fx-opacity: 1;");

 return area;

 }

 public static void clearDetailFields(Control... controls) {

 for (Control control : controls) {

 if (control instanceof TextField) {

 ((TextField) control).clear();

 } else if (control instanceof TextArea) {

 ((TextArea) control).clear();

 }

 }

 }

}
