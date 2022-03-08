package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtArea;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
	private Button btnCancella;
    
    @FXML
    void doDelete(ActionEvent event) {
    	long startTime = System.nanoTime();
    	String parolaDaCancellare = txtResult.getSelectedText();
    	elenco.delete(parolaDaCancellare);
    	elenco.getElenco();
    	txtResult.setText(elenco.toString());
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtArea.setText(Long.toString(elapsedNanos)+" ns");
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	long startTime = System.nanoTime();
    	String parola = txtParola.getText();
    	elenco.addParola(parola);
    	elenco.getElenco();
    	txtResult.setText(elenco.toString());
    	txtParola.clear();
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtArea.setText(Long.toString(elapsedNanos)+" ns");
    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtArea.setText(Long.toString(elapsedNanos)+" ns");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}