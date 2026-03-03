package com.example.csc325assign3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu themeMenu = new Menu("Theme");
        Menu helpMenu = new Menu("Help");

        menuBar.getMenus().addAll(fileMenu, editMenu, themeMenu, helpMenu);


        // TableView setup
        TableView<Student> tableView = new TableView<>();
        TableColumn<Student, String> idColumn = new TableColumn<>("ID");
        TableColumn<Student, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Student, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Student, String> departmentColumn = new TableColumn<>("Department");
        TableColumn<Student, String> majorColumn = new TableColumn<>("Major");
        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");

        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, departmentColumn, majorColumn, emailColumn);

        // Form Fields
        TextField searchField = new TextField();
        TextField lastNameField = new TextField();
        TextField departmentField = new TextField();
        TextField majorField = new TextField();
        TextField emailField = new TextField();
        TextField imageUrlField = new TextField();

        // Buttons
        Button clearButton = new Button("Clear");
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button editButton = new Button("Edit");
        clearButton.setMaxWidth(Double.MAX_VALUE);
        addButton.setMaxWidth(Double.MAX_VALUE);
        deleteButton.setMaxWidth(Double.MAX_VALUE);
        editButton.setMaxWidth(Double.MAX_VALUE);

        lastNameField.setPromptText("Last Name");
        departmentField.setPromptText("Department");
        majorField.setPromptText("Major");
        emailField.setPromptText("Email");
        imageUrlField.setPromptText("Image URL");

        // Layout for Form
        VBox formLayout = new VBox(5);
        formLayout.getChildren().addAll(
                searchField,
                lastNameField,
                departmentField,
                majorField,
                emailField,
                imageUrlField,
                clearButton, addButton, deleteButton, editButton
        );
        Image logo = new Image(getClass().getResourceAsStream("/image.png"));
        ImageView logoView = new ImageView(logo);

        HBox logoBox = new HBox(logoView);
        logoBox.setAlignment(Pos.TOP_LEFT);
        logoBox.setPadding(new Insets(10,10,10,10));

        // Give form VBox a style class
        formLayout.getStyleClass().add("form-box");

        HBox bottomLayout = new HBox();
        bottomLayout.getStyleClass().add("bottom-box");
        bottomLayout.setPrefHeight(37);

        VBox.setMargin(clearButton, new Insets(90, 0, 0, 0));

// Center layout (table + form)
        HBox contentLayout = new HBox();
        contentLayout.getChildren().addAll(logoBox, tableView, formLayout);

// Root layout (menu on top)
        VBox root = new VBox();
        root.getChildren().addAll(menuBar, contentLayout, bottomLayout);

        contentLayout.setAlignment(Pos.CENTER_RIGHT);

        Scene scene = new Scene(root, 800, 570);
        scene.getStylesheets().add(
                getClass().getResource("/styles.css").toExternalForm()
        );


        primaryStage.setTitle("FSC CSC325 Full Stack Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
