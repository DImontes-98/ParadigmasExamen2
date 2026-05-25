package co.edu.poli.Examen2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

	@FXML
	private TextField txtCodigoExamen;
	@FXML
	private TextField txtNombrePaciente;
	@FXML
	private TextField txtCosto;
	@FXML
	private ComboBox<String> cmbTipoSangre;
	@FXML
	private RadioButton rbPositivo;
	@FXML
	private RadioButton rbNegativo;
	@FXML
	private ToggleGroup tgFactorRH;
	@FXML
	private TextArea txtAreaResultados;

	@FXML
	public void initialize() {
	}

	@FXML
	private void handleGuardar() {
	}

	@FXML
	private void handleLimpiar() {
	}

	@FXML
	private void handleSerializar() {
	}

	@FXML
	private void handleDeserializar() {
	}

	@FXML
	private void handleListar() {
	}
}
