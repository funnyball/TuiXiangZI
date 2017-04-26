package yty.txz;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
	public static MainFrame mf;
	private static JButton jb[] = new JButton[3];
	public int change;

	public App() {
	}

	public App(int pass) {
		mf = new MainFrame(pass);
		
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(MyLookAndFeel.JTATTOO_MINT);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		xuanguan();

	}
	public static void xuanguan(){
		final JFrame jf = new JFrame("ѡ��");
		Toolkit t=Toolkit.getDefaultToolkit();
		Image i= t.getImage("tb.jpg");
		jf.setIconImage(i);
		jf.setSize(300, 120);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setLayout(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int x = 0; x < 3; x++) {
			// ��Ӱ�ť
			jb[x] = new JButton("��" + (x + 1) + "��");
			jb[x].setBounds(0 + x * 100, 0, 100, 100);
			jf.add(jb[x]);
		}
		for (int y = 0; y < jb.length; y++) {
			// ��ÿ����ť���������¼�
			final App a = new App();
			a.change = y;
			jb[y].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					jf.dispose();
					if (a.change == 0) {
						mf = new MainFrame();
					} else {
						mf = new MainFrame(a.change);
					}
				}
			});
		}
	}
}
