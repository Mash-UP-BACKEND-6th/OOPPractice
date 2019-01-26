import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

public class validation {
    // 유효성 체크
    // 24 비트 비트맵만 처리합니다.
    private static int pixelBits = 24;

    public static boolean isValidated(BufferedImage image){
        ColorModel cm = image.getColorModel();

        if(cm.getPixelSize() == pixelBits){
            System.out.println("[ 유효성 체크 ] 24비트 비트맵 OK ");
            return true;
        }else{
            System.out.println("[ 유효성 체크 ] 24비트가 아님");
            return false;
        }
    }
}
