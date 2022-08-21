/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;
 
import clases.Actividad;
import clases.Atencion;
import clases.Cita;
import clases.personas.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Angello Bravo
 */
public class ActividadController implements Initializable{
    
    //Atributos
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbTiempo;
    @FXML
    private Label lbNumero;
    @FXML
    private GridPane cuadricula;
    //Creacion de los botones
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button bt9;
    @FXML
    private Button bt10;
    @FXML
    private Button bt11;
    @FXML
    private Button bt12;
    @FXML
    private Button bt13;
    @FXML
    private Button bt14;
    @FXML
    private Button bt15;
    @FXML
    private Button bt16;
    @FXML
    private Button bt17;
    @FXML
    private Button bt18;
    @FXML
    private Button bt19;
    @FXML
    private Button bt20;
    
            
    //Atributos no FXML
    //int[] arrNumeros = new int[20];
    ArrayList<Integer> arrNumeros;
    public static boolean iniciar;
    public static int hora=0, min=0, seg=0;
    int fallas;
    int aciertos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         arrNumeros = generarArreglo(1, 40);
         iniciar = true;
         fallas = 0;
         aciertos = 0;
         int aleatorio = (int) (Math.random()*arrNumeros.size());
         lbNumero.setText(Integer.toString(arrNumeros.get(aleatorio)));

         getChildrenFromGridPane();
        
        Reloj rj = new Reloj(lbTiempo);
        rj.setDaemon(true);
        rj.start();
         
    }
    
    //Metodo que generara el arreglo con numeros aleatorios sin repeticiones
    public ArrayList<Integer> generarArreglo(int min, int max){
        ArrayList<Integer> x = new ArrayList<>();
        while(x.size() != 20){
            int numero = (int) (Math.random()*max)+min;
            if(!x.contains(numero)){
                x.add(numero);
            }
        }
        return x;
    }
    
    public void llenarEspacios(Atencion t){
        lbNombre.setText("Paciente: " +t.getCita().getCliente().toString());
        lbTiempo.setText("0:0:0");
        
    }
    
    //Metodo que obtendra los nodos del grid pane y agregara los valores aleatorios a los botones
    @FXML
   private void getChildrenFromGridPane(){
       int contador = 0;
       for(Node node: cuadricula.getChildren()){
           Button bt = (Button)node;
           bt.setText(Integer.toString(arrNumeros.get(contador)));
           contador++;
       }
   }
   
   //Se llamara a los botones junto a los eventos
   @FXML
   private void manejarActividad() throws IOException{
       bt1.setOnMouseClicked(new ManejadorEventos(bt1));
       bt2.setOnMouseClicked(new ManejadorEventos(bt2));
       bt3.setOnMouseClicked(new ManejadorEventos(bt3));
       bt4.setOnMouseClicked(new ManejadorEventos(bt4));
       bt5.setOnMouseClicked(new ManejadorEventos(bt5));
       bt6.setOnMouseClicked(new ManejadorEventos(bt6));
       bt7.setOnMouseClicked(new ManejadorEventos(bt7));
       bt8.setOnMouseClicked(new ManejadorEventos(bt8));
       bt9.setOnMouseClicked(new ManejadorEventos(bt9));
       bt10.setOnMouseClicked(new ManejadorEventos(bt10));
       bt11.setOnMouseClicked(new ManejadorEventos(bt11));
       bt12.setOnMouseClicked(new ManejadorEventos(bt12));
       bt13.setOnMouseClicked(new ManejadorEventos(bt13));
       bt14.setOnMouseClicked(new ManejadorEventos(bt14));
       bt15.setOnMouseClicked(new ManejadorEventos(bt15));
       bt16.setOnMouseClicked(new ManejadorEventos(bt16));
       bt17.setOnMouseClicked(new ManejadorEventos(bt17));
       bt18.setOnMouseClicked(new ManejadorEventos(bt18));
       bt19.setOnMouseClicked(new ManejadorEventos(bt19));
       bt20.setOnMouseClicked(new ManejadorEventos(bt20));
   }
    
    //Clase interna que creara un hilo para el cronometro
    private class Reloj extends Thread{
        @FXML
        Label e;
        Reloj(Label e){
            this.e = e;
        }
        @Override
        public void run(){
            try{
                int x = 0;
                while(iniciar){
                    ejecutarReloj(x);
                    Thread.sleep(1000);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
        public void ejecutarReloj(int x){
            seg++;
            if(seg >59){
                seg =0;
                min++;
            }
            if(min>59){
                seg=0;
                min=0;
                hora++;
            }
            
            //System.out.println(hora + ":" + min + ":" + seg);
            Platform.runLater(() -> e.setText(hora +":" + min + ":" + seg));
        }
        
    }
    
    //Clase interna para manejar eventos.
    private class ManejadorEventos implements EventHandler<Event>{
        
        private Button btAccion;
        
        public ManejadorEventos(Button btAccion){
            this.btAccion = btAccion;
        }
        
        @Override
        public void handle(Event t) {
            int valorBt = Integer.valueOf(btAccion.getText());
            int valorLabel = Integer.valueOf(lbNumero.getText());
            
            if(valorBt == valorLabel){
                System.out.println("Ta bien :D");
                
                //Eliminar el valor ya seleccionado
                int index = arrNumeros.indexOf(valorLabel);
                arrNumeros.remove(index);
                
                //Cambia el color del boton
                btAccion.setStyle("-fx-background-color: #23F751;");
                aciertos++;
                try{
                    //Coloca otro numero en pantalla
                    int aleatorio = (int) (Math.random()*arrNumeros.size());
                    lbNumero.setText(Integer.toString(arrNumeros.get(aleatorio)));
                }
                catch(IndexOutOfBoundsException e){
                    lbNumero.setText("Game Over");
                }
            }
            else{
                fallas++;
                System.out.println(fallas);
            }
            
            if(arrNumeros.isEmpty()){
                iniciar = false;
                System.out.println("Juego acabado");
                
                //Guardar Informacion
                Cliente cl = RegistrarAtencionController.citaParaAtencion.getCliente();
                LocalDate fecha = RegistrarAtencionController.citaParaAtencion.getFecha();
                Actividad ac = new Actividad(cl, lbTiempo.getText(), fecha, "Bingo",fallas, aciertos);
                
                //Guardar en Texto
                String clString = cl.getDatos() + ";" + cl.getCedula() + ";" + cl.getNombre() + ";" + cl.getTelef() +";" + cl.getEmail();
                String line = clString + ";" + lbTiempo.getText() +";"+ fecha + ";" + "Bingo" +";" + fallas + ";" + aciertos + "\n";
                
                try(FileWriter fl = new FileWriter(App.pathActividades, true)){
                    fl.write(line);
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
                
                //Alerta
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Information Dialog");
                alerta.setHeaderText("Felicitaciones");
                alerta.setContentText("Haz completado la actividad en un tiempo de: " + lbTiempo.getText());
                alerta.showAndWait();
                
                Cita.eliminarCita(RegistrarAtencionController.citaParaAtencion);
                
                try{
                    App.setRoot(App.pathFXMLCitas);
                }
                catch(IOException e ){
                    System.out.println(e.getMessage());
                }
            }
            
        }
        
    }
    
    
    
    
    
    
}
