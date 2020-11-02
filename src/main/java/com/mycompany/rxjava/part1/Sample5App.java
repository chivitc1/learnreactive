package com.mycompany.rxjava.part1;

import io.reactivex.Observable;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Hot Observable example
 *
 */
public class Sample5App extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        ToggleButton toggleButton = new ToggleButton("Toggle ME");
        Label label = new Label();

        Observable<Boolean> selectedStates = valuesOf(toggleButton.selectedProperty());

        selectedStates.map(selected -> selected ? "DOWN" : "UP")
                .subscribe(label::setText);
        VBox box = new VBox();
        box.getChildren().addAll(toggleButton, label);
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
    }

    private static <T> Observable<T> valuesOf(ObservableValue<T> fxObservable) {
        return Observable.create(emitter -> {
            //Init state
            emitter.onNext(fxObservable.getValue());

            //emit new value change using source's listener
            final ChangeListener<T> listener = ((observable, oldValue, newValue) -> emitter.onNext(newValue));
            fxObservable.addListener(listener);
        });
    }
}
