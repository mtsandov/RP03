package com.mycompany.proyecto2doparcial;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    
    @FXML
    private void cambiarServicios() throws IOException {
        App.setRoot("servicios");
    }
    
    @FXML
    private void cambiarEmpleados() throws IOException{
        App.setRoot("empleados");
    }
    
    @FXML
    private void cambiarClientes() throws IOException{
        App.setRoot("clientes");
    }
    
    @FXML
    private void cambiarCitas() throws IOException{
        App.setRoot("citas");
    }
    
    @FXML
    private void cambiarAtenciones() throws IOException{
        App.setRoot("atenciones");
    }
    
}
