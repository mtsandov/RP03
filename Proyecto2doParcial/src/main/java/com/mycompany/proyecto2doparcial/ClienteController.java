/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.personas.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
        lista = FXCollections.observableArrayList();
        ArrayList<Cliente> listaClientes = Cliente.cargarClientes(App.pathClientes);
        for(Cliente cl: listaClientes){
            lista.add(cl);
        }
        
        //Crear la Tabla
        colCedula.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        colTelef.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telef"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colDatos.setCellValueFactory(new PropertyValueFactory<Cliente, String>("datos"));
        
        tablaClientes.setItems(lista);
        
    }
    
    
    @FXML
    private void cambiarAgregar() throws IOException{
        App.setRoot("agregarCliente");
    }
    
    @FXML
    private void regresar() throws IOException{
        App.setRoot("clientes");
    }
    @FXML
    private void cambiarMain() throws IOException{
        App.setRoot("main");
    }
}
