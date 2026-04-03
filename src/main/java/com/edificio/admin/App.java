package com.edificio.admin;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Clase principal del Sistema de Administración de Edificios.
 * Punto de entrada de la aplicación JavaFX.
 *
 * @autor Sebasr0311
 * @autor JoseReales-ui
 * @version 1.0.0
 */
public class App extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        escenarioPrincipal.setTitle("Sistema de Administración de Edificios");
        // TODO: Cargar vista de inicio de sesión (inicio-sesion.fxml)
        escenarioPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
