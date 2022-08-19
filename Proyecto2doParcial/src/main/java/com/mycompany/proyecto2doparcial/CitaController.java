package com.mycompany.proyecto2doparcial;


import clases.Cita;
import clases.Servicio;
import clases.personas.Cliente;
import clases.personas.Empleado;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Angello Bravo
 */
public class CitaController implements Initializable{
    //Atributos
    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private TableColumn<Cita, Cliente> colNombre;
    @FXML
    private TableColumn<Cita, Empleado> colEmpleado;
    @FXML
    private TableColumn<Cita, Servicio> colServicio;
    @FXML
    private TableColumn<Cita, LocalDate> colFecha;
    @FXML
    private TableColumn<Cita, LocalTime> colHora;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colEmpleado.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        colServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        
        tablaCitas.getItems().setAll(Cita.cargarCitas(App.pathCitas));
    }
    
    //Cambiara a la ventana para registrar la atencion de la cita seleccionada.-
    @FXML
    private void registrarAtencion() throws IOException{
        Cita c = (Cita)tablaCitas.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Citas/registrarAtencion.fxml"));
        RegistrarAtencionController ct = new RegistrarAtencionController();
        
        RegistrarAtencionController.citaParaAtencion = c;
        fxmlloader.setController(ct);
        BorderPane root = (BorderPane) fxmlloader.load();
        
        ct.llenarCampos(c);
        App.changeRoot(root);
    }
    
    @FXML
    private void cambiarRegistrarAtencion() throws IOException{
        App.setRoot("Citas/registrarAtencion");
    }
    
    @FXML
    private void cambiarAgregar() throws IOException{
        App.setRoot("Citas/agregarCita");
    }
    
    @FXML
    private void cambiarConsultar() throws IOException{
        App.setRoot("consultarCitas");
    }
    
    
    @FXML
    private void cambiarMain() throws IOException{
        App.setRoot("main");
    }
}
