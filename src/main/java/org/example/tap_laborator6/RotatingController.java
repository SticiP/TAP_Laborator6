package org.example.tap_laborator6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RotatingController {

    @FXML
    private Rectangle rectangle;

    private double rotationAngle = 0;
    private Timeline timeline1, timeline2;
    private double currentScale = 1.0;
    private double targetScale = 2.0; // mărimea țintă la care va crește dreptunghiul

    @FXML
    public void initialize() {
        timeline1 = new Timeline(new KeyFrame(Duration.millis(16), e -> rotateRectangle()));
        timeline1.setCycleCount(Animation.INDEFINITE);
        rectangle.setFocusTraversable(true);
        rectangle.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                toggleAnimation();
            } else if (event.getCode() == KeyCode.R) {
                restartAnimation();
            } else if (event.getCode() == KeyCode.A) {
                scaleRectangle(); // apelarea metodei pentru a mări și micșora dreptunghiul
            }

        });
    }

    private void rotateRectangle() {
        rotationAngle += 1;
        if (rotationAngle >= 360) {
            rotationAngle = 0;
        }
        rectangle.setRotate(rotationAngle);
    }

    private void toggleAnimation() {
        if (timeline1.getStatus() == Animation.Status.RUNNING) {
            timeline1.pause();
        } else {
            timeline1.play();
        }
    }

    private void restartAnimation() {
        timeline1.stop();
        rotationAngle = 0;
        rectangle.setRotate(rotationAngle);
    }

    private void scaleRectangle() {
        Timeline timeline2 = new Timeline(
                new KeyFrame(Duration.millis(16), e -> scale())
        );
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }

    private void scale()
    {
        if (currentScale < targetScale) { //
            if(currentScale > 2)
            {
                currentScale -= 0.05;
            } else if (currentScale < 0.2)
            {
                currentScale += 0.05;
            }
            rectangle.setScaleX(currentScale);
            rectangle.setScaleY(currentScale);
        } else {
            timeline2.stop();
        }
    }
}

