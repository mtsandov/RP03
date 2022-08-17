package com.mycompany.proyecto2doparcial;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    
    @FXML
    private void cambiarServicios() throws IOException {
        App.setRoot(App.pathFXMLServicios);
    }
    
    @FXML
    private void cambiarEmpleados() throws IOException{
        App.setRoot(App.pathFXMLEmpleados);
    }
    
    @FXML
    private void cambiarClientes() throws IOException{
        App.setRoot(App.pathFXMLClientes);
    }
    
    @FXML
    private void cambiarCitas() throws IOException{
        App.setRoot(App.pathFXMLCitas);
    }
    
    @FXML
    private void cambiarAtenciones() throws IOException{
        App.setRoot(App.pathFXMLAtenciones);
    }
    
}
