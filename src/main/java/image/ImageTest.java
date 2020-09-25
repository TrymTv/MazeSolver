package image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

public class ImageTest {
	BufferedImage img = null; 
    File f = null; 
	
    void setImg(String path) {
		try {
			f = new File(path);
			img = ImageIO.read(f);
		}
		catch(IOException e){
			e.printStackTrace();
		}
    }
    public BufferedImage getImg() {
		return img;
	}
    
    public static void main(String[] args) {
		ImageTest test = new ImageTest();
		test.setImg("C:\\Users\\tiltr\\Pictures\\maze\\mazeTest.png");
		byte[] pixels = ((DataBufferByte) test.getImg().getRaster().getDataBuffer()).getData();
		for (int i = 0; i < pixels.length; i += 3) {
			System.out.println("i: " + i/3 + " " + pixels[i]);
		}
	}
}