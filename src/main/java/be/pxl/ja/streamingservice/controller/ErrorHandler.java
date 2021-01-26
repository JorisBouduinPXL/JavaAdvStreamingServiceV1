package be.pxl.ja.streamingservice.controller;

import be.pxl.ja.streamingservice.exception.TooManyProfilesException;
import javafx.scene.control.Alert;

public class ErrorHandler {

    public static void showError(Exception e) {

        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
    }

    public static void showError(TooManyProfilesException e) {
        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
    }

}
