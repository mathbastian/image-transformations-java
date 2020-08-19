import java.util.ArrayList;
import java.util.List;

public class ImageModifiersAssembler {
	
	public static List<ImageModifier> create(){
		
		List<ImageModifier> modifiers = new ArrayList<ImageModifier>();
		modifiers.add(new MirrorHorizontallyModifier());
		modifiers.add(new MirrorVerticallyModifier());
		modifiers.add(new DoubleSizeModifier());
		//modifiers.add(new FlipRightModifier());
		modifiers.add(new MoveToTheRightModifier());
		modifiers.add(new Rotate90DegreesModifier());
		modifiers.add(new reduceHalfModifier());
		
		return modifiers;
		
	}
}
