import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BufferedImage image = null;
        String imagePath="", savePath = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("변환할 이미지의 경로 : ");
        //imagePath = scanner.next();
        imagePath = "C:\\Users\\ggaps\\OneDrive\\바탕 화면\\객체지향\\작은호랑이.bmp";
        File imagefile = new File(imagePath);

        try {
            image = ImageIO.read(imagefile);
            if(validation.isValidated(image)){
                Convertor cvt = new Convertor(image);
                cvt.process();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("저장할 파일 경로 : ");
        savePath = scanner.next();





    }
}
