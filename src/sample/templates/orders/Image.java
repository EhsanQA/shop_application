package sample.templates.orders;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Image {

    private String iPath;
    private int width;
    private int height;
    private String oPath;

    public String getoPath() {
        return oPath;
    }

    Image() {
    }

    Image(String iPath, int width, int height, String oPath) {

        this.iPath = iPath;
        this.width = width;
        this.height = height;
        this.oPath = oPath;

    }

    public void rw() throws IOException {

        BufferedImage image = null;

        try {
            File input_file = new File(iPath);

            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);


            image = ImageIO.read(input_file);

            System.out.println("Reading complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        try {
            // Output file path
            File output_file = new File(oPath);

            // Writing to file taking type and path as
            ImageIO.write(image, "jpg", output_file);

            System.out.println("Writing complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }
}
