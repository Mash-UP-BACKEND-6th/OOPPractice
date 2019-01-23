import java.io.*;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class BitmapReader {
    FileInputStream fileInputStream;

    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;

    public BitmapHeader readHeader(File file) throws IOException {
       this.fileInputStream = new FileInputStream(file);
       return new BitmapHeader(
               readBfType(),
               readBfSize(),
               readReserved(),
               readReserved(),
               readBfOffbits(),
               readBiSize(),
               readBiWidth(),
               readBiHeight(),
               readBiPlanes(),
               readBitCount(),
               readCompression(),
               readBiSizeImage(),
               readXPelsPerMeter(),
               readXPelsPerMeter(),
               readCirUsed(),
               readCirImportant()
            );
    }
    public String readBfType() throws IOException {
        byte[] bfType = new byte[2];
        fileInputStream.read(bfType);
        return new String(bfType, StandardCharsets.UTF_8);

    }

    public int readBfSize() throws IOException {
        byte[] bfSize = new byte[4];

        fileInputStream.read(bfSize);
        return readInt(bfSize);
    }


    public int readInt(byte[] byteBuf) throws IOException {
        int output = 0;
        int shift = 0;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            for(int i = byteBuf.length - 1; i >= 0; --i) {
                output |= (byteBuf[i] & 0xff) << shift;
                shift += 8;
            }
            return output;

        } else {
            for(int i = 0; i < byteBuf.length; ++i) {
                output |= (byteBuf[i] & 0xff) << shift;
                shift += 8;
            }
            return output;
        }
    }

    public int readReserved() throws IOException {
        byte[] bfSize = new byte[2];
        fileInputStream.read(bfSize);
        return readInt(bfSize);
    }

    public int readBfOffbits() throws IOException {
        byte[] bfOffBits = new byte[4];
        fileInputStream.read(bfOffBits);
        return readInt(bfOffBits);
    }

    public int readBiSize() throws IOException {
        byte[] biSize = new byte[4];
        fileInputStream.read(biSize);
        return readInt(biSize);
    }

    public int readBiWidth() throws IOException {
        byte[] biWidth = readBytes(4);
        return readInt(biWidth);
    }

    public byte[] readBytes(int size) throws IOException {
        byte[] bytes = new byte[size];
        fileInputStream.read(bytes);
        return bytes;
    }

    public int readBiHeight() throws IOException {
        byte[] biHeight = readBytes(4);
        return readInt(biHeight);
    }

    public int readBiPlanes() throws IOException {
        byte[] biPlanes = readBytes(2);
        return readInt(biPlanes);
    }

    public int readBitCount() throws IOException {
        byte[] biBitCount = readBytes(2);
        return readInt(biBitCount);
    }

    public int readCompression() throws IOException {
        byte[] compression = readBytes(4);
        return readInt(compression);
    }

    public int readBiSizeImage() throws IOException {
        byte[] biSizeImage = readBytes(4);
        return readInt(biSizeImage);
    }

    public int readXPelsPerMeter() throws IOException {
        byte[] biXPelsPerMeter = readBytes(4);
        return readInt(biXPelsPerMeter);
    }

    public int readYPelsPerMeter() throws IOException {
        byte[] biYPelsPerMeter = readBytes(4);
        return readInt(biYPelsPerMeter);
    }

    public int readCirUsed() throws IOException {
        byte[] biCirUsed = readBytes(4);
        return readInt(biCirUsed);
    }

    public int readCirImportant() throws IOException {
        byte[] biCirImportant = readBytes(4);
        return readInt(biCirImportant);
    }
}
