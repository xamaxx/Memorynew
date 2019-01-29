package memorymitgui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input extends MouseAdapter {
	private boolean click = false;
public boolean isClick() {
		return click;
	}
	public void setClick(boolean click) {
		this.click = click;
	}
@Override
public void mouseClicked(MouseEvent e) {
	click = true;
}

}
