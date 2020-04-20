import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class ImageEngine {

    private BufferedImage image;
    private String path;
    private int height;
    private int width;

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

        this.height = image.getHeight();
        this.width = image.getWidth();

        System.out.println("Image height: " + height );
        System.out.println("Image width: " + width);
    }

    private void colorSwap ( char a, char b){
        a = 'b';
        b = 'r';

        for (int i = 0; i < height; ++i) {
            for (int j =0; j < width; ++j) {

                System.out.println("RGB value is: " + image.getRGB(i,j) );

            }
        }

    }

    void write() {
        try {
            File of = new File(path+"_out");
            ImageIO.write(image, "jpg", of);
        }
        catch(IOException e) {
            System.out.println("Unable to write file.");
            e.printStackTrace();
        }
    }

}
