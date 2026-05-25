package co.edu.poli.Examen2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import co.edu.poli.Examen2.model.Examenesmedicos;
import co.edu.poli.Examen2.model.examensangre;
import co.edu.poli.Examen2.servicios.ImplementacionOperacionCRUD;

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
	private TextArea txtAreaMensajes;

	private ImplementacionOperacionCRUD servicio = new ImplementacionOperacionCRUD();

	@FXML
	public void initialize() {
		// El ComboBox y el ToggleGroup ya están configurados en el FXML
	}

	@FXML
	private void handleGuardar() {
		try {
			String codigo   = txtCodigoExamen.getText().trim();
			String nombre   = txtNombrePaciente.getText().trim();
			String costoStr = txtCosto.getText().trim();
			String grupo    = cmbTipoSangre.getValue();
			String rh       = rbPositivo.isSelected() ? "+" : "-";

			if (codigo.isEmpty() || nombre.isEmpty() || costoStr.isEmpty() || grupo == null) {
				txtAreaMensajes.setText("⚠ Por favor complete todos los campos.");
				return;
			}

			double costo = Double.parseDouble(costoStr);

			examensangre examen = new examensangre(
				nombre,
				java.time.LocalDate.now().toString(),
				codigo,
				costo,
				"COP",
				rh,
				grupo
			);

			String resultado = servicio.crear(examen);
			txtAreaMensajes.setText("✔ " + resultado + "\n" + examen.describir());

		} catch (NumberFormatException e) {
			txtAreaMensajes.setText("⚠ El costo debe ser un número válido. Ejemplo: 150000");
		}
	}

	@FXML
	private void handleLimpiar() {
		txtCodigoExamen.clear();
		txtNombrePaciente.clear();
		txtCosto.clear();
		cmbTipoSangre.setValue(null);
		rbPositivo.setSelected(true);
		txtAreaMensajes.clear();
	}

	@FXML
	private void handleSerializar() {
		String resultado = servicio.serializar(
			servicio.getExamenesmedicos(),
			System.getProperty("user.home"),
			"examenes.dat"
		);
		txtAreaMensajes.setText("📦 " + resultado);
	}

	@FXML
	private void handleDeserializar() {
		Examenesmedicos[] cargados = servicio.deserealizar(
			System.getProperty("user.home"),
			"examenes.dat"
		);
		if (cargados != null) {
			StringBuilder sb = new StringBuilder("📂 Datos deserializados:\n\n");
			for (Examenesmedicos e : cargados) {
				if (e != null) sb.append("• ").append(e.describir()).append("\n");
			}
			txtAreaMensajes.setText(sb.toString());
		} else {
			txtAreaMensajes.setText("No se encontró el archivo 'examenes.dat' o está vacío.");
		}
	}

	@FXML
	private void handleListar() {
		String lista = servicio.listar();
		txtAreaMensajes.setText(lista.isBlank() ? "No hay exámenes registrados." : lista);
	}
}
