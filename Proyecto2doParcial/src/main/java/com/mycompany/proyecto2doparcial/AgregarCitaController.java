/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.Cita;
import clases.Servicio;
import clases.personas.Cliente;
import clases.personas.Empleado;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Angello Bravo
 */
public class AgregarCitaController implements Initializable{
    
    //Atributos
    @FXML
    private ComboBox cbTerapia;
    @FXML
    private ComboBox cbCliente;
    @FXML
    private ComboBox cbEmpleado;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private TextField txtHora;
    //Ketodos
    
    @FXML
    private void llenarCombos(){
        cbTerapia.getItems().setAll(Servicio.cargarServicios(App.pathServicios));
        cbCliente.getItems().setAll(Cliente.cargarClientes(App.pathClientes));
        cbEmpleado.getItems().setAll(Empleado.cargarEmpleados(App.pathEmpleados));
    }
    //Incializar
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarCombos();
    }
    @FXML
    private void regresar() throws IOException{
        App.setRoot(App.pathFXMLCitas);
    }
    
    //Metodo agregarCita\
    @FXML
    private void guardarCita(){
        ArrayList<Cita> listaCitas = Cita.cargarCitas(App.pathCitas);
        String[] tiempo = txtHora.getText().split(":");
        Cita cita = new Cita(dpFecha.getValue(),LocalTime.of(Integer.parseInt(tiempo[0]), Integer.parseInt(tiempo[1])),(Cliente)cbCliente.getValue(), (Empleado)cbEmpleado.getValue(), (Servicio)cbTerapia.getValue());
            
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.pathCitas))){
            //Comprobacion que no haya una cita en la misma fecha y hora.
            if(listaCitas.contains(cita)){
                throw new Exception();
            }
            
            
            else{
                listaCitas.add(cita);
                //Serializacion
                out.writeObject(listaCitas);
                out.flush();

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Information Dialog");
                alerta.setHeaderText("Resultado de la operación");
                alerta.setContentText("Cita agregada exitosamente");
                alerta.showAndWait();

                App.setRoot(App.pathFXMLCitas);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Archivo no Encontrado");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setContentText("Error al registrar la nueva Cita");
            alerta.showAndWait();
        }
    }
}
