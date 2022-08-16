/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.personas.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Angello Bravo
 */
public class ClienteController implements Initializable{
    
    @FXML
    TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente, String> colCedula;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colTelef;
    @FXML
    private TableColumn<Cliente, String> colEmail;
    @FXML
    private TableColumn<Cliente, String> colDatos;
    
    @FXML
    private Button btAgregar;
    
    public ObservableList<Cliente> lista;
    
    
    //Metodos
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelef.setCellValueFactory(new PropertyValueFactory<>("telef"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDatos.setCellValueFactory(new PropertyValueFactory<>("datos"));
        
        tablaClientes.getItems().setAll(Cliente.cargarClientes(App.pathClientes));
        
    }
    
    @FXML
    private void agregarView() throws IOException{
        App.setRoot("Clientes/agregarCliente");
    }
    
    @FXML
    private void cambiarMain() throws IOException{
        App.setRoot("main");
    }
    
    
    
}
