package system.view;

import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;



/*
*@author:yb
*@version 创建时间：2018年1月17日 下午2:50:54
*/
public class MainStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 提供JDK提供的工具类启动Swing的程序,保证其线程的安全.
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try
					    {
						org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();					    
					    }
					    catch(Exception e)
					    {
					        //TODO exception
					    }
						LoginView loginView = new LoginView();
						loginView.setVisible(true);
					}
				});
	}

}
