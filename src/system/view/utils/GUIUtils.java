package system.view.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

/**
 * 
 * 窗口居中显示
 * 
 * @author yb 2018-1-16
 */
public class GUIUtils {
	/**
	 * 将一个窗口在屏幕中居中显示
	 * 
	 * @param jf
	 */
	public static void setCenterInWindow(Window jf) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// 获得屏幕信息
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - jf.getWidth()) / 2;
		int y = (screenSize.height - jf.getHeight()) / 2;

		jf.setLocation(x, y);
	}

}
