import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class BitmapReaderTest {
    BitmapReader bitmapReader;

    @Test
    public void getBfType() throws IOException {
        File input = new File("/Users/user/Projects/mashup/OOP/changmin/AsciiArt/brown.bmp");
        bitmapReader = new BitmapReader();
        bitmapReader.open(input);
        Assert.assertEquals("BM", bitmapReader.readBfType());
    }

    @Test
    public void getBfSize() throws IOException {
        getBfType();
        Assert.assertEquals(30138, bitmapReader.readBfSize());
    }

    @Test
    public void getReserved1() throws IOException {
        getBfSize();
        Assert.assertEquals(0, bitmapReader.readReserved());
    }

    @Test
    public void getReserved2() throws IOException {
        getReserved1();
        Assert.assertEquals(0, bitmapReader.readReserved());
    }

    @Test
    public void getBfOffbits() throws IOException {
        getReserved2();
        Assert.assertEquals(138, bitmapReader.readBfOffbits());
    }

    @Test
    public void getBiSize() throws IOException {
        getBfOffbits();
        Assert.assertEquals(124, bitmapReader.readBiSize());
    }

    @Test
    public void getWidth() throws IOException {
        getBiSize();
        Assert.assertEquals(100, bitmapReader.readBiWidth());
    }

    @Test
    public void getHeight() throws IOException {
        getWidth();
        Assert.assertEquals(100, bitmapReader.readBiHeight());
    }

    @Test
    public void getPlanes() throws IOException {
        getHeight();
        Assert.assertEquals(1, bitmapReader.readBiPlanes());
    }

    @Test
    public void getBitCount() throws IOException {
        getPlanes();
        Assert.assertEquals(24, bitmapReader.readBitCount());
    }

    @Test
    public void getCompression() throws IOException {
        getBitCount();
        Assert.assertEquals(0, bitmapReader.readCompression());
    }

    @Test
    public void getSizeImage() throws IOException {
        getCompression();
        Assert.assertEquals(30000, bitmapReader.readBiSizeImage());
    }

    @Test
    public void getXPelsPerMeter() throws IOException {
        getSizeImage();
        Assert.assertEquals(0, bitmapReader.readXPelsPerMeter());
    }

    @Test
    public void getYPelsPerMeter() throws IOException {
        getXPelsPerMeter();
        Assert.assertEquals(0, bitmapReader.readYPelsPerMeter());
    }

    @Test
    public void getCirUsed() throws IOException {
        getYPelsPerMeter();
        Assert.assertEquals(0, bitmapReader.readCirUsed());
    }

    @Test
    public void getCirImportant() throws IOException {
        getCirUsed();
        Assert.assertEquals(0, bitmapReader.readCirImportant());
    }

    @Test
    public void readBitmapHeader() throws IOException {
        File input = new File("/Users/user/Projects/mashup/OOP/changmin/AsciiArt/brown.bmp");
        BitmapReader bitmapReader = new BitmapReader();
        BitmapHeader bitmapHeader = bitmapReader.read(input).getBitmapHeader();
        Assert.assertEquals("BM", bitmapHeader.getBfType());
        Assert.assertEquals(30138, bitmapHeader.getBfSize());
        Assert.assertEquals(0, bitmapHeader.getBfReserved1());
        Assert.assertEquals(0, bitmapHeader.getBfReserved2());
        Assert.assertEquals(138, bitmapHeader.getBfOffBits());

        Assert.assertEquals(124, bitmapHeader.getBiSize());
        Assert.assertEquals(100, bitmapHeader.getBiWidth());
        Assert.assertEquals(100, bitmapHeader.getBiHeight());
        Assert.assertEquals(1, bitmapHeader.getBiPlanes());
        Assert.assertEquals(24, bitmapHeader.getBiBitCount());
        Assert.assertEquals(0, bitmapHeader.getBiCompression());
        Assert.assertEquals(30000, bitmapHeader.getBiSizeImage());
        Assert.assertEquals(0, bitmapHeader.getBiXPelsPerMeter());
        Assert.assertEquals(0, bitmapHeader.getBiYPelsPerMeter());
        Assert.assertEquals(0, bitmapHeader.getBiClrUsed());
        Assert.assertEquals(0, bitmapHeader.getBiClrImportant());
    }
}
