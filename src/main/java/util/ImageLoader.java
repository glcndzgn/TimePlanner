package util;

import javax.imageio.ImageIO;
import java.awt.*;

public class ImageLoader {

    public Image loadImage(String path) throws Exception{
        return ImageIO.read(getClass().getClassLoader().getResource(path));
    }
    public Image loadImage(String path,int w,int h) throws Exception {
        Image image = loadImage(path);
        return image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
    }
}
