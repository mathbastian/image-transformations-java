import java.awt.image.BufferedImage;

public class MirrorHorizontallyModifier implements ImageModifier {

	@Override
	public BufferedImage modify(BufferedImage source) {

		int width = source.getWidth();
		int height = source.getHeight();
		
		BufferedImage image = new BufferedImage(width, height, source.getType());
		
		for( int y = 0; y < height; y++ ) {
			for( int lx = 0, rx = width - 1; lx < width; lx++, rx-- ) {
				
				int pixel = source.getRGB(lx, y);
				image.setRGB(rx, y, pixel);
			}
		}
		
		return image;
		
	}

	@Override
	public String getName() {
		return "Virada para a direita";
	}

}
