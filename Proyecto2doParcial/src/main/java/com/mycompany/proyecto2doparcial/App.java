package com.mycompany.proyecto2doparcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    
    public static String pathServicios = "src/main/java/archivos/servicios.txt";
    public static String pathEmpleados = "src/main/java/archivos/empleados.txt";
    public static String pathClientes = "src/main/java/archivos/clientes.txt";
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Sistema");
        stage.setMinHeight(600);
        stage.setMinWidth(600);
        stage.setMaxHeight(600);
        stage.setMaxWidth(600);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}