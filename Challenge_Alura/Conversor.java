/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Challenge_Alura;

/**
 *
 * @author Joseph
 */
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Conversor extends Application {

    private Map<String, Double> exchangeRates;

    private ComboBox<String> currencyComboBox;
    private TextField amountTextField;
    private Label resultLabel;

    private TextField celsiusTextField;
    private Button convertTemperatureButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conversor de Divisas y Temperatura");

        // Inicializa las tasas de cambio
        initializeExchangeRates();

        GridPane gridPane = createGridPane();
        addCurrencyControls(gridPane);
        addTemperatureControls(gridPane);
        addConvertButton(gridPane);

        Scene scene = new Scene(gridPane, 300, 240);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Pregunta si el usuario desea continuar con el programa al cerrar la ventana
        primaryStage.setOnCloseRequest(event -> {
            event.consume(); // Evita el cierre de la ventana
            showConfirmationDialog(primaryStage);
        });
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        gridPane.setStyle("-fx-background-color: #CAFAE5;");
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        return gridPane;
    }

    private void addCurrencyControls(GridPane gridPane) {
        Label currencyLabel = new Label("Divisas:");
        gridPane.add(currencyLabel, 0, 0);

        currencyComboBox = new ComboBox<>();
        currencyComboBox.getItems().addAll(exchangeRates.keySet());
        currencyComboBox.setValue("Elige tu divisa");
        gridPane.add(currencyComboBox, 1, 0);

        Label amountLabel = new Label("Monto:");
        gridPane.add(amountLabel, 0, 1);

        amountTextField = new TextField();
        gridPane.add(amountTextField, 1, 1);
    }

    private void addTemperatureControls(GridPane gridPane) {
        Label temperatureLabel = new Label("Temperatura (°C):");
        gridPane.add(temperatureLabel, 0, 2);

        celsiusTextField = new TextField();
        gridPane.add(celsiusTextField, 1, 2);
    }

    private void addConvertButton(GridPane gridPane) {
        Button convertButton = new Button("Conversor");
        gridPane.add(convertButton, 0, 3, 2, 1);
        GridPane.setMargin(convertButton, new Insets(10, 0, 0, 0));

        resultLabel = new Label();
        convertButton.setStyle("-fx-background-color: #A0EDF7; -fx-text-fill: black;");

        gridPane.add(resultLabel, 0, 4, 2, 1);
        GridPane.setMargin(resultLabel, new Insets(10, 0, 0, 0));

        convertButton.setOnAction(event -> {
            String selectedCurrency = currencyComboBox.getValue();
            String amountText = amountTextField.getText();

            if (!amountText.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountText);
                    convertCurrency(selectedCurrency, amount);
                } catch (NumberFormatException e) {
                    resultLabel.setText("VALOR INVALIDO");
                }
            } else {
                resultLabel.setText("SE NECESITA UN VALOR");
            }
        });

        convertTemperatureButton = new Button("CONVERTIDOR DE TEMPERATURA");
        gridPane.add(convertTemperatureButton, 0, 5, 2, 1);
        GridPane.setMargin(convertTemperatureButton, new Insets(10, 0, 0, 0));
        convertTemperatureButton.setStyle("-fx-background-color: #A0EDF7; -fx-text-fill: black;");

        convertTemperatureButton.setOnAction(event -> {
            String celsiusText = celsiusTextField.getText();

            if (!celsiusText.isEmpty()) {
                try {
                    double celsius = Double.parseDouble(celsiusText);
                    convertTemperature(celsius);
                } catch (NumberFormatException e) {
                    resultLabel.setText("Temperatura invalida");
                }
            } else {
                resultLabel.setText("Se requiere un valor");
            }
        });
    }

    private void convertCurrency(String currency, double amount) {
        double exchangeRate = exchangeRates.get(currency);
        double convertedAmount = Math.round(amount * exchangeRate);
        resultLabel.setText(amount + " USD = " + convertedAmount + " " + currency);
    }

    private void convertTemperature(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        resultLabel.setText(celsius + " °C = " + fahrenheit + " °F");
    }

    private void initializeExchangeRates() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD a USD", 1.0);
        exchangeRates.put("USD a EUR", 0.89);
        exchangeRates.put("USD a GBP", 0.78);
        exchangeRates.put("USD a JPY", 109.16);
        exchangeRates.put("USD a Won", 0.00075);
        exchangeRates.put("USD a MXN", 17.60);
        exchangeRates.put("USD a ARS", 231.63);
        exchangeRates.put("USD a BRL", 4.88926);

        // Agrega más tasas de cambio según sea necesario
    }

    private void showConfirmationDialog(Stage primaryStage) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmar salida");
        alert.setHeaderText("¿Deseas salir del programa?");
    

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            primaryStage.close();
        }
    }
}







