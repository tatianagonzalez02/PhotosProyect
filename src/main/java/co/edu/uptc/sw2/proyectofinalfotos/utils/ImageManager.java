package co.edu.uptc.sw2.proyectofinalfotos.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author FREDY
 * @reference
 * https://ingeniods.wordpress.com/2013/04/30/redimensionamiento-de-imagenes-en-java/
 */
public class ImageManager {

    public static int MAX_WIDTH = 800;
    public static int MAX_HEIGHT = 600;

    public static void copyImage(String filePath, String copyPath, String text, String sDate) throws IOException {
        BufferedImage bimage = loadImage(filePath);
        if (bimage.getHeight() > bimage.getWidth()) {
            int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
            bimage = resize(bimage, MAX_WIDTH, heigt);
            int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
            bimage = resize(bimage, width, MAX_HEIGHT);
        } else {
            int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
            bimage = resize(bimage, width, MAX_HEIGHT);
            int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
            bimage = resize(bimage, MAX_WIDTH, heigt);
        }
        drawString(bimage, text, sDate);
        saveImage(bimage, copyPath);
    }

    public static BufferedImage loadImage(String pathName) throws IOException {
        return ImageIO.read(new File(pathName));
    }

    public static void saveImage(BufferedImage bufferedImage, String pathName) throws IOException {
        String format = (pathName.endsWith(".png")) ? "png" : "jpg";
        File file = new File(pathName);
        file.getParentFile().mkdirs();
        ImageIO.write(bufferedImage, format, file);
    }

    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
        g.dispose();
        return bufim;
    }

    public static void drawString(BufferedImage bufferedImage, String text, String sDate) throws IOException {
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawString(text, 10, bufferedImage.getHeight() - 22);
        graphics2D.drawString(sDate, 10, bufferedImage.getHeight() - 10);
    }
}
