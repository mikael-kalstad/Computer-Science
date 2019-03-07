import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Valutaberegner extends Application {
    String valutaFra;
    String valutaTil;
    Valuta valutaFraObj;
    Valuta valutaTilObj;

    Button btnKonverter;
    Button btnNyValuta;
    Alert alert;
    TextInputDialog input;

    ArrayList<Valuta> valutaliste = new ArrayList<>(Arrays.asList(
            new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
            new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
            new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
            new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)
    ));

    public static void main(String[] args) {
        launch(args);
    }

    // Finner objekt med string navn
    public Valuta getValuta(String valutanavn){
        if (valutaFra == null || valutaFra.equals("")) return null;

        for (Valuta valuta : valutaliste) {
            if (valuta.getValutanavn().equals(valutanavn)) return valuta;
        }

        return null;
    }

    // Konverter metode
//    public double konverter(Valuta valutaFra, Valuta valutaTil, double sum) {
//        if (valutaFra == null || valutaTil == null) return -1;
//        double norske;
//    }

    // Alert box
    public void showAlert(String title, String message, String headerText, Alert.AlertType type) {
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        alert.show();
    }

    // Input dialog
    public void showInputDialog(String title, String headerText, String message) {
        input = new TextInputDialog();
        input.setTitle(title);
        input.setHeaderText(headerText);
        input.setContentText(message);
    }

    // Legg til liste
    public void leggTilListe(ListView liste, ArrayList<Valuta> arr) {
        // Legger til valutanavn i listene
        arr.forEach((valuta) -> liste.getItems().add(valuta.getValutanavn()));
        liste.refresh();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Vindu tittel
        primaryStage.setTitle("Valutaberegner");
        ListView<String> fraValutaListe = new ListView<>();
        ListView<String> tilValutaListe = new ListView<>();


        // Legger til valutanavn i listene
        leggTilListe(fraValutaListe, valutaliste);
        leggTilListe(tilValutaListe, valutaliste);

        // Event listener til listene
        fraValutaListe.setOnMouseClicked(e -> {
            valutaFra = fraValutaListe.getSelectionModel().getSelectedItem();
            valutaFraObj = getValuta(valutaFra);
        });

        tilValutaListe.setOnMouseClicked(e -> {
            valutaTil = tilValutaListe.getSelectionModel().getSelectedItem();
            valutaTilObj = getValuta(valutaTil);
        });

        // Konverter btn
        btnKonverter = new Button("Konverter");
        btnKonverter.setOnAction(e -> {
            if (valutaFra == null || valutaTil == null) {
                showAlert("Advarsel", "Valuta til og fra må velges for å konvertere", "Vær forsiktig!", Alert.AlertType.INFORMATION);
            } else {
                showInputDialog("Valutaberegner", "Antall", "Velg antall " + valutaFra);
                Optional<String> result = input.showAndWait();
                result.ifPresent(value -> {
                    double kalkulertVerdi = Valuta.konverter(valutaFraObj, valutaTilObj, Double.parseDouble(value));
                    String msg = value + " " + valutaFra + " blir " + kalkulertVerdi + valutaTil;
                    showAlert("Valutaberegner", msg, "Beregnet valuta", Alert.AlertType.INFORMATION);
                });
            }
        });

        // Ny valuta btn
        btnNyValuta = new Button("Ny valuta");
        btnNyValuta.setOnAction(e -> {
            Dialog dialog = new Dialog();
            dialog.setTitle("Valutaberegner");
            dialog.setHeaderText("Ny valuta");

            // Buttons
            ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

            // Enable/Disable button depending on whether fields are entered
            Node okButton = dialog.getDialogPane().lookupButton(okButtonType);
            okButton.setDisable(true);

            TextField navn = new TextField();
            TextField kurs = new TextField();
            TextField enhet = new TextField();

            navn.setPromptText("Euro");
            kurs.setPromptText("65");
            enhet.setPromptText("1");

            Label navnLabel = new Label("Navn: ");
            Label kursLabel = new Label("Kurs: ");
            Label enhetLabel = new Label("Enhet: ");

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            grid.add(navn, 1, 0);
            grid.add(navnLabel, 0, 0);

            grid.add(kurs, 1, 1);
            grid.add(kursLabel, 0, 1);

            grid.add(enhet, 1, 2);
            grid.add(enhetLabel, 0, 2);

            // Input validation
            enhet.textProperty().addListener((observable, oldValue, newValue) -> {
                okButton.setDisable(newValue.trim().isEmpty());
            });

            dialog.getDialogPane().setContent(grid);
            dialog.show();

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == okButtonType) {
                    valutaliste.add(new Valuta(
                            navn.getText(),
                            Double.parseDouble(kurs.getText()),
                            Integer.parseInt(enhet.getText()))
                    );
                    // Tømmer listene
                    fraValutaListe.getItems().clear();
                    tilValutaListe.getItems().clear();

                    // Oppdaterer listene
                    leggTilListe(fraValutaListe, valutaliste);
                    leggTilListe(tilValutaListe, valutaliste);
                }
                return null;
            });
        });


        // Layout
        GridPane grid = new GridPane(); // Master

        // Tekst
        Label fra = new Label("Valuta fra");
        Label til = new Label("Valuta til");
        grid.add(fra, 0, 0);
        grid.add(til, 1, 0);

        // Lister
        grid.add(fraValutaListe, 0, 1);
        grid.add(tilValutaListe, 1, 1);

        // Btns
        grid.add(btnNyValuta, 0, 2);
        grid.add(btnKonverter, 1, 2);

        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.show();
    }
}