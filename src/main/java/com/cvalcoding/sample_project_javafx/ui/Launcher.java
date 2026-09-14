package com.cvalcoding.sample_project_javafx.ui;

import com.cvalcoding.sample_project_javafx.controller.EmployeeController;
import com.cvalcoding.sample_project_javafx.model.entity.Employee;
import com.cvalcoding.sample_project_javafx.ui.widget.LabelFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launcher extends Application {

    private Parent createContent() {
        return new StackPane(new Text("Hello World"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        EmployeeController employeeController = new EmployeeController();

        VBox vBox = new VBox();
        // Top bar
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.BOTTOM_LEFT);
        VBox.setMargin( topBox, new Insets(10.0d) );

        HBox topRightBox = new HBox();
        HBox.setHgrow(topRightBox, Priority.ALWAYS );
        Button back = new Button("Back");
        topRightBox.setAlignment(Pos.BOTTOM_RIGHT);
        topRightBox.getChildren().add(back);

        Button add = new Button("ADD");
        topBox.getChildren().addAll(add, topRightBox);

        TableView<Employee> employeeTableView = new TableView<>();
        employeeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        VBox.setMargin(employeeTableView, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        VBox.setVgrow(employeeTableView, Priority.ALWAYS);

        TableColumn<Employee, Integer> idCol = new TableColumn<>("#");
        idCol.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));

        TableColumn<Employee, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, String> firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> extension = new TableColumn<>("Extension");
        extension.setCellValueFactory(new PropertyValueFactory<>("extension"));

        TableColumn<Employee, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Employee, String> officeCode = new TableColumn<>("code");
        officeCode.setCellValueFactory(new PropertyValueFactory<>("officeCode"));

        TableColumn<Employee, Integer> reportsTo = new TableColumn<>("reports");
        reportsTo.setCellValueFactory(new PropertyValueFactory<>("reportsTo"));

        TableColumn<Employee, String> jobTitle = new TableColumn<>("job");
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

        employeeTableView.getColumns().addAll(idCol, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);

        employeeTableView.getItems().addAll(employeeController.index());

        vBox.getChildren().addAll(topBox, employeeTableView);
        Scene sc = new Scene(vBox, 1000, 700);
        primaryStage.setScene(sc);
//        primaryStage.setScene(new Scene(createContent(), 300, 300));
        primaryStage.show();
    }
}
