import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.EmptyStackException;
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

        System.out.println(" Image height: " + image.getHeight() );
        System.out.println(" Image width: " + this.width);

    }

    void colorSwap ( char a){
        /* the data don't change, but the interperation */
        /* Options are 'r', 'g' 'b' */

        for (int i = 0; i < (height-1); i++) {
            for (int j =0; j < width; j++) {

                //System.out.println(" height[i]: " + i );
                //System.out.println(" width[i]: " + j);

                int rgb = image.getRGB(j,i);
                System.out.println("RGB value is: " + rgb );

                int red = (rgb >> 16) & 0xff; //Suggestion: (rgb << 16) | 0xff hehe
                int green = (rgb >> 8) & 0xff;
                int blue = (rgb) & 0xff;

                Color col;

                //System.out.println("rgb: " + red + ", " + green + ", " + blue);
                //System.out.println();

                switch (a) {
                    case '1':
                         col = new Color( green, red, blue);
                        break;
                    case '2':
                         col = new Color(red, blue, green);
                        break;
                    case '3':
                         col = new Color(blue, green, red);
                        break;
                    default:
                        throw new EmptyStackException();

                }
                image.setRGB(i, j, col.getRGB());

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
