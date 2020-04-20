import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class ImageEngine {

    private BufferedImage image;
    private String path;

    ImageEngine( String path){
        this.path = path;
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

    void write()
    {
        try
        {
            File of = new File(path+"_out");
            ImageIO.write(image, "jpg", of);
        }
        catch(IOException e)
        {
            System.out.println("Unable to write file.");
            e.printStackTrace();
        }
    }

}
