package tests;

import static org.junit.Assert.*;

import renderer.*;

import org.junit.Test;

public class ImageWriterTests {

    @Test
    public void test() {
        ImageWriter imaget = new ImageWriter("ImageWriterTests_test", 501, 501, 501, 501);
        for (int i = 0; i < 501; i++)
            for (int j = 0; j < 501; j++) {
                if (i % 50 == 0 || j % 50 == 0)
                    imaget.writePixel(i, j, 255, 255, 255);
            }
        imaget.writeToimage();
    }

}
