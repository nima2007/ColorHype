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

        System.out.println(" Image height: " + image.getHeight() );
        System.out.println(" Image width: " + this.width);

    }

    void colorSwap ( char a, char b){

        for (int i = 0; i < (height-1); i++) {
            for (int j =0; j < width; j++) {

                //System.out.println(" height[i]: " + i );
                //System.out.println(" width[i]: " + j);

                int rgb = image.getRGB(j,i);
                System.out.println("RGB value is: " + rgb );

                int red = (rgb >> 16) & 0xff; //Suggestion: (rgb << 16) | 0xff hehe
                int green = (rgb >> 8) & 0xff;
                int blue = (rgb) & 0xff;

                System.out.println("rgb: " + red + ", " + green + ", " + blue);
                System.out.println();
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
