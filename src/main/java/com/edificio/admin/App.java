package com.edificio.admin;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Clase principal del Sistema de Administración de Edificios.
 * Punto de entrada de la aplicación JavaFX.
 *
 * <p>Este sistema permite administrar un edificio de apartamentos en arriendo,
 * incluyendo la gestión de personas, contratos, pagos y el sistema de visitas
 * con códigos QR.</p>
 *
 * @author Sebasr0311
 * @author JoseReales-ui
 * @version 1.0.0
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Administración de Edificios");
        // TODO: Cargar vista de login (login.fxml)
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
