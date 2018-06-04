package pacman.file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileManager {

    // CONSTANTS --------------------------- //

    private final static String IMG_FILES_PATH = "/home/maja/Pulpit/pacman-grid/src/pacman/file/";
    private final static String IMG_FORMAT = "png";

    // METHODS -------------------- //

    // read image for a sprite and animationState
    public Image readImage(String spriteName, String stateName, Integer animationState) {

        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(new File(GetImageUrl(spriteName, stateName, animationState)));
        } catch (IOException ex) {
            // do sth....
            ex.printStackTrace();
            System.err.println("No file found");
        }

        return bufferedImage;

    }

    private String GetImageUrl(String spriteName, String stateName, Integer animationState) {
        return IMG_FILES_PATH.equals("") ? "/" + spriteName + "_" + stateName + "_" + animationState + "." + IMG_FORMAT :
                IMG_FILES_PATH + spriteName + "_" + stateName + "_" + animationState + "." + IMG_FORMAT;
    }

}