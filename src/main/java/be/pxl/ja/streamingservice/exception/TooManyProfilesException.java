package be.pxl.ja.streamingservice.exception;

import be.pxl.ja.streamingservice.account.Profile;
import javafx.scene.control.Alert;

public class TooManyProfilesException extends Throwable {
    public TooManyProfilesException(Profile profile) {
        super(profile.getName() + " is not allowed");
    }

    public TooManyProfilesException(Exception e) {
        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
    }

}
