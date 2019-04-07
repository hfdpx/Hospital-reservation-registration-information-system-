package system.view.listener;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import system.view.UserDoMessageJpanel;
import system.view.UserMainView;
import system.view.UserMessagePanel;

public class UserViewChangeListener implements ChangeListener {
	private UserMainView userMainView;
	private JTabbedPane tabbedPane;
	private String name;

	public UserViewChangeListener(UserMainView userMainView, String name) {
		this.name = name;
		this.userMainView = userMainView;
		tabbedPane = userMainView.getTabbedPane();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		tabbedPane.add(new UserMessagePanel(name));
		tabbedPane.add(new UserDoMessageJpanel(name));
		tabbedPane.add(new UserMessagePanel(name));
	}

}
