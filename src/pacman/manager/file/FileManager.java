package pacman.manager.file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileManager {

    // CONSTANTS --------------------------- //

    private final static String IMG_FILES_PATH = "/home/maja/Pulpit/PACMAAAN/src/pacman/manager/file/";
    private final static String IMG_FORMAT = "jpg";

    // METHODS -------------------- //

    // read image for a sprite and animationState
    public Image readImage(String spriteName, String stateName) {

        BufferedImage bufferedImage = null;

        try {
            System.err.println(GetImageUrl(spriteName, stateName));
            bufferedImage = ImageIO.read(new File(GetImageUrl(spriteName, stateName)));
        } catch (IOException ex) {
            // do sth....
            ex.printStackTrace();
            System.err.println("No file found");
        }

        return bufferedImage;

    }

    private String GetImageUrl(String spriteName, String stateName) {
        return IMG_FILES_PATH.equals("") ? "/" + spriteName + "_" + stateName + "." + IMG_FORMAT :
                IMG_FILES_PATH + "/" + spriteName + "_" + stateName + "." + IMG_FORMAT;
    }

}