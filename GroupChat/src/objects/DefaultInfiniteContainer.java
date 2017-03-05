package objects;

import java.util.List;

import com.codename1.ui.Component;
import com.codename1.ui.InfiniteContainer;

public class DefaultInfiniteContainer extends InfiniteContainer {

	private List<? extends Component> components;

	public void setComponents(List<? extends Component> components) {
		this.components = components;
	}

	@Override
	public Component[] fetchComponents(int index, int amount) {
		Component[] toReturn = new Component[Math.min(amount, components.size())];

		for (int i = 0; i < toReturn.length; i++) {
			if ((index + i) < components.size()) {
				toReturn[i] = components.get(index + i);
			}
			else {
				return null;
			}
		}
		
		return toReturn;
	}
}
