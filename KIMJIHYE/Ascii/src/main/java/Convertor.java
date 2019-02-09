import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Convertor {
    private char ascii[] = { '#', '#', '@', '%', '=', '+', '*', ':', '-', '.', ' ' };
    private ArrayList<String> output;
    private int pixel_size = 3;
    private int pixel_align = 4;
    private int width, height, padding;
    BufferedImage image;

    public Convertor(BufferedImage image){
        this.image = image;
        init();
    }

    private void init(){
        output=new ArrayList<String>();
        width = image.getWidth();
        height= image.getHeight();
        padding =( pixel_align - ( (width * pixel_size) % pixel_align) ) %pixel_align;
    }

    public void process(){
        int y=0;
        //for(int y=0; y< height;y++){
            for(int x=0;x<width;x++){
                String line = "";
                // get Pixel
                int color = image.getRGB(x,y);

                // 0x 는 16진수
                // 16진수의 한자리는 4비트를 차지함
                int blue = color & 0xff;
                int green = (color & 0xff00) >> 8;
                int red = (color & 0xff0000) >> 16;
                System.out.println("blue = "+blue+"| green = "+green+" |red = "+red);
                // convert to ascii
                int gray = (blue +green+red) / pixel_size;
                char c = ascii[gray * ascii.length / 256];
                line = line + new String();
                System.out.printf("%c%c",c,c);
            }
            System.out.println();
        //}
    }






}
