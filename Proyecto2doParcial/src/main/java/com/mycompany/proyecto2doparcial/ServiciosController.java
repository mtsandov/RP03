/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.Servicio;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author Angello Bravo
 */

public class ServiciosController implements Initializable{

    //Atributos FXML
    @FXML
    TableView<Servicio> tablaServicios;
  
    @FXML
    private TableColumn<Servicio, String> colServicios;
    @FXML
    private TableColumn<Servicio, Float> colDuracion;
    @FXML
    private TableColumn<Servicio, Float> colPrecio;
    @FXML
    private TableColumn<Servicio, Boolean> colEstado;
    
    //Atributos Java
    public ObservableList<Servicio> lista; //Lista que presentara en la tabla 
    
    //Metodos
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista = FXCollections.observableArrayList();
        ArrayList<Servicio> listaServicio = Servicio.cargarServicios(App.pathServicios);
        for(Servicio s: listaServicio){
            lista.add(s);
        }
        
        //Crea la Tabla
        colServicios.setCellValueFactory(new PropertyValueFactory<Servicio, String>("tipo"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<Servicio, Float>("duracion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Servicio,Float>("precio"));
        colEstado.setCellValueFactory(new PropertyValueFactory<Servicio,Boolean>("estado"));
//        
        tablaServicios.setItems(lista);
    }

    @FXML
    private void cambiarMain() throws IOException{
        App.setRoot("main");
    }
    
    @FXML
    private void cambiarAgregarServicio() throws IOException{
        App.setRoot("Servicios/agregarServicio");
    }
}
