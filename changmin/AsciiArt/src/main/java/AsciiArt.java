import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

class RGB24 {
    final static int PIXEL_SIZE_OF_BYTE = 3;
    char red;
    char green;
    char blue;

    public RGB24(char red, char green, char blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public RGB24(byte blue, byte green, byte red) {
        this.red = (char)(red & 0xff);
        this.green = (char)(green & 0xff);
        this.blue = (char)(blue & 0xff);
    }

    public char getRed() {
        return red;
    }

    public char getGreen() {
        return green;
    }

    public char getBlue() {
        return blue;
    }

    public int getGray() {
        return (red + green + blue) / PIXEL_SIZE_OF_BYTE;
    }

}

public class AsciiArt {
    static final int PIXEL_SIZE = 3;
    static char[] ascii = { '#', '#', '@', '%', '=', '+', '*', ':', '-', '.', ' ' };

    public String getAsciiImage(Bitmap bitmap) {
        BitmapHeader bitmapHeader = bitmap.getBitmapHeader();
        StringBuilder stb = new StringBuilder();

        int width = bitmapHeader.getBiWidth();
        int height = bitmapHeader.getBiHeight();

        for (int y = height - 1; y >= 0; y--)
        {
            // 가로 크기만큼 반복
            for (int x = 0; x < width; x++)
            {
                int gray = bitmap.getPixel(x, y).getGray();

                char c = ascii[gray * ascii.length / 256];

                // 비트맵 이미지에서는 픽셀의 가로, 세로 크기가 똑같지만
                // 보통 ASCII 문자는 세로로 길쭉한 형태이므로 정사각형 모양과 비슷하게 보여주기 위해
                // 같은 문자를 두 번 저장해줌
                stb.append(c);
                stb.append(c);
            }

            stb.append('\n');
        }
        return stb.toString();
    }

    public static void main(String[] args) throws IOException {
        File input = new File("AsciiArt/brown.bmp");
        BitmapReader bitmapReader = new BitmapReader();
        Bitmap bitmap = bitmapReader.read(input);
        AsciiArt asciiArt = new AsciiArt();
        String ascii = asciiArt.getAsciiImage(bitmap);

        File output = new File("AsciiArt/output.txt");
        FileWriter fileWriter = new FileWriter(output);
        fileWriter.write(ascii, 0, ascii.length());
    }


    /**
     *
     * 자바 API를 이용한 간단한 버전
     */

    public static void simple() throws IOException {
        File input = new File("AsciiArt/brown.bmp");
        File output = new File("AsciiArt/output.txt");
        getAscii(input, output);
    }

    public static void getAscii(File input, File output) throws IOException {
        BufferedImage image = ImageIO.read(input);
        FileWriter fileWriter = new FileWriter(output);

        int height = image.getHeight();
        int width = image.getWidth();

        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                Color color = new Color(image.getRGB(x, y));
                int gray = (color.getRed() + color.getGreen() +color.getBlue()) / PIXEL_SIZE;
                char c = ascii[gray * ascii.length / 256];

                System.out.print(c);
                fileWriter.append(c);
            }

            System.out.println();
            fileWriter.append("\n");
        }
    }
}
