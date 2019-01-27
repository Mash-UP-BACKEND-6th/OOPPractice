public class Bitmap {
    static final int PIXEL_SIZE = 3;
    static final int PIXEL_ALIGN = 4;
    BitmapHeader bitmapHeader;
    byte[] imageOfByte;

    public Bitmap(BitmapHeader bitmapHeader, byte[] imageOfByte) {
        this.bitmapHeader = bitmapHeader;
        this.imageOfByte = imageOfByte;
    }

    public BitmapHeader getBitmapHeader() {
        return bitmapHeader;
    }

    public byte[] getImageOfByte() {
        return imageOfByte;
    }

    public RGB24 getPixel(int x, int y) {
        int padding = (PIXEL_ALIGN - ((bitmapHeader.getBiWidth() * PIXEL_SIZE) % PIXEL_ALIGN)) % PIXEL_ALIGN;

        // 일렬로 된 배열에 접근하기 위해 인덱스를 계산
        // (x * 픽셀 크기)는 픽셀의 가로 위치
        // (y * (세로 크기 * 픽셀 크기))는 픽셀이 몇 번째 줄인지 계산
        // 남는 공간 * y는 줄별로 누적된 남는 공간
        int index = (x * PIXEL_SIZE) + (y * (bitmapHeader.getBiWidth() * PIXEL_SIZE)) + (padding * y);

        // 현재 픽셀의 주소를 RGBTRIPLE 포인터로 변환하여 RGBTRIPLE 포인터에 저장
        RGB24 pixel = new RGB24(imageOfByte[index], imageOfByte[index+1], imageOfByte[index+2]);
        return pixel;
    }
}
