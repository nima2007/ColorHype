import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class ImageEngine {

    private BufferedImage image;

    ImageEngine( String path){
        File file = new File(path);
        try {
            image = ImageIO.read(file);

        } catch (IOException e) {
            System.out.println("Unable to read file.");
            e.printStackTrace();
        }
        System.out.println("File read successfuly");
        System.out.println("Image height: " + image.getHeight() );
        System.out.println("Image width: " + image.getWidth() );
    }

}
