public class BitmapHeader {
    private String bfType;
    private int bfSize;
    private int bfReserved1;
    private int bfReserved2;
    private int bfOffBits;

    private int biSize;
    private int biWidth;
    private int biHeight;
    private int biPlanes;
    private int biBitCount;
    private int biCompression;
    private int biSizeImage;
    private int biXPelsPerMeter;
    private int biYPelsPerMeter;
    private int biClrUsed;
    private int biClrImportant;

    public BitmapHeader(String bfType, int bfSize, int bfReserved1, int bfReserved2, int bfOffBits, int biSize, int biWidth, int biHeight, int biPlanes, int biBitCount, int biCompression, int biSizeImage, int biXPelsPerMeter, int biYPelsPerMeter, int biClrUsed, int biClrImportant) {
        this.bfType = bfType;
        this.bfSize = bfSize;
        this.bfReserved1 = bfReserved1;
        this.bfReserved2 = bfReserved2;
        this.bfOffBits = bfOffBits;
        this.biSize = biSize;
        this.biWidth = biWidth;
        this.biHeight = biHeight;
        this.biPlanes = biPlanes;
        this.biBitCount = biBitCount;
        this.biCompression = biCompression;
        this.biSizeImage = biSizeImage;
        this.biXPelsPerMeter = biXPelsPerMeter;
        this.biYPelsPerMeter = biYPelsPerMeter;
        this.biClrUsed = biClrUsed;
        this.biClrImportant = biClrImportant;
    }

    public String getBfType() {
        return bfType;
    }

    public int getBfSize() {
        return bfSize;
    }

    public int getBfReserved1() {
        return bfReserved1;
    }

    public int getBfReserved2() {
        return bfReserved2;
    }

    public int getBfOffBits() {
        return bfOffBits;
    }

    public int getBiSize() {
        return biSize;
    }

    public int getBiWidth() {
        return biWidth;
    }

    public int getBiHeight() {
        return biHeight;
    }

    public int getBiPlanes() {
        return biPlanes;
    }

    public int getBiBitCount() {
        return biBitCount;
    }

    public int getBiCompression() {
        return biCompression;
    }

    public int getBiSizeImage() {
        return biSizeImage;
    }

    public int getBiXPelsPerMeter() {
        return biXPelsPerMeter;
    }

    public int getBiYPelsPerMeter() {
        return biYPelsPerMeter;
    }

    public int getBiClrUsed() {
        return biClrUsed;
    }

    public int getBiClrImportant() {
        return biClrImportant;
    }
}
