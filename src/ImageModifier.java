import java.awt.image.BufferedImage;

public interface ImageModifier {
	public BufferedImage modify( BufferedImage source );
	public String getName();
}
