package pacman.render.graphics;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Animation {
    // FIELDS ---------------------------------- //

    protected Map<String, Image> images;
    protected String currentState;
    protected int animationState;

    // CONSTANTS ------------------------------- //

    public final String[] STATES = {"Idle"};
    public final int[] ANIMATION_STATES = {1};

    // CONSTRUCTOR ----------------------------- //

    public Animation() {
        this.images = new HashMap<String, Image>();
        currentState = STATES[0];
        animationState = ANIMATION_STATES[0];
    }

    // METHODS --------------------------------- //

    public void AddAnimationState(String name, Image image, int i) {
        this.images.put(name + "_" + i, image);
    }

    public void animate() {
        if (this.animationState == ANIMATION_STATES.length)
            this.animationState = ANIMATION_STATES[0];
        else this.animationState = ANIMATION_STATES[this.animationState];
    }

    public void changeState(String name) {
        this.currentState = name;
    }

    public Image getCurrentImage() {
        return images.get(this.GetImageKey());
    }

    protected String GetImageKey() {
        return this.currentState + "_" + this.animationState;
    }
}