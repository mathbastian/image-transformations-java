import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Rotate90DegreesModifier implements ImageModifier {

	@Override
	public BufferedImage modify(BufferedImage source) {
		
		double rads = Math.toRadians(90);
		double sin = Math.abs(Math.sin(rads));
		double cos = Math.abs(Math.cos(rads));
		int width = (int) Math.floor(source.getWidth() * cos + source.getHeight() * sin);
		int height = (int) Math.floor(source.getHeight() * cos + source.getWidth() * sin);
		
		BufferedImage image = new BufferedImage(width, height, source.getType());
		
		AffineTransform trasform = new AffineTransform();
		trasform.translate(width / 2, height / 2);
		trasform.rotate(rads,0, 0);
		trasform.translate(-source.getWidth() / 2, -source.getHeight() / 2);
		AffineTransformOp rotate = new AffineTransformOp(trasform, AffineTransformOp.TYPE_BILINEAR);
		rotate.filter(source,image);
				
		return image;
		
	}

	@Override
	public String getName() {
		return "Rotacionado 90 graus";
	}

}
