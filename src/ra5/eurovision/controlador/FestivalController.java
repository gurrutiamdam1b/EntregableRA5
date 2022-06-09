package ra5.eurovision.controlador;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import ra5.eurovision.modelo.Festival;
import ra5.eurovision.modelo.PaisExcepcion;

import java.io.File;
import java.io.IOException;

public class FestivalController {
    Festival f;

    @FXML
    private TextField FieldPais;

    @FXML
    private CheckBox Check;

    @FXML
    private javafx.scene.control.TextArea TextArea;

    public FestivalController() {
        f = new Festival();

    }
    @FXML
    void mostrarGanador(){
        TextArea.setText(f.ganador());
        if (Check.isSelected()){
            try {
                f.guardarResultados();
                TextArea.appendText("\n "+ "Pais ganador guardado en el fichero");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void mostrarPuntos(){
        try {
            TextArea.setText("La puntuacion de "+ FieldPais.getText() +" es " + f.puntuacionDe(FieldPais.getText().toUpperCase()));
        } catch (PaisExcepcion e) {
            TextArea.setText("NO EXISTE EL PAIS");
        }

    }
    @FXML
    void leer(){
        FileChooser selector = new FileChooser();
        selector.setTitle("Elige fichero para leer");
        selector.setInitialDirectory(new File("."));
        File fi = selector.showOpenDialog(null);
        f.leerPuntuaciones(fi.getAbsolutePath());
        TextArea.setText("El numero de erroes son: " + f.leerPuntuaciones(fi.getAbsolutePath()));
    }
    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }



    private void cogerFoco() {
//        txtPais.requestFocus();
//        txtPais.selectAll();

    }

    @FXML
    void clear(ActionEvent event) {
//        areaTexto.setText("");
//        cogerFoco();

    }

}

