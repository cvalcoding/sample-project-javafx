package com.cvalcoding.sample_project_javafx.ui.widget;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class HBoxFX extends HBox {
    public HBoxFX() {
    }

    /**
     *
     * @param pos position of element
     */
    public void alignement(Pos pos) {
        this.setAlignment(pos);
    }
}
