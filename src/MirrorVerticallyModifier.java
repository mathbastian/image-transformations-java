import java.awt.image.BufferedImage;

public class MirrorVerticallyModifier implements ImageModifier {

	@Override
	public BufferedImage modify(BufferedImage source) {
		
		int width = source.getWidth();
		int height = source.getHeight();
		
		BufferedImage image = new BufferedImage(width, height, source.getType());
		
		for( int uy = 0, ly = height - 1; uy < height; uy++, ly-- ) {
			for( int x = 0;  x < width; x++ ) {
				
				int pixel = source.getRGB(x, uy);
				image.setRGB(x, ly, pixel);
			}
		}
		
		return image;
		
	}

	@Override
	public String getName() {
		return "Espelhada vertical";
	}

}
