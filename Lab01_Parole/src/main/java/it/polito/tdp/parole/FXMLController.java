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
    private Button btnCancella;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    private void stampaCorrenti() {
    	List<String> paroleCorrenti = elenco.getElenco();
    	for (String s : paroleCorrenti) {
    		txtResult.appendText(s + "\n");
    	}
    }

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	String daInserire = txtParola.getText();
    	long start = System.nanoTime();
    	long end;
    	txtParola.clear();
    	txtResult.clear();
    	elenco.addParola(daInserire);
    	this.stampaCorrenti();
    	end = System.nanoTime();
    	txtTempo.setText("" + (end - start) + "ns");
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	long start = System.nanoTime();
    	long end;
    	elenco.reset();
    	txtResult.clear();
    	end = System.nanoTime();
    	txtTempo.setText("" + (end - start) + "ns");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String daCancellare = txtResult.getSelectedText();
    	long start = System.nanoTime();
    	long end;
    	elenco.cancella(daCancellare);
    	txtResult.clear();
    	this.stampaCorrenti();
    	end = System.nanoTime();
    	txtTempo.setText("" + (end - start) + "ns");
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
