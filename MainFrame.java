package yty.txz;

import java.awt.Container;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 角色的标签
	private JLabel role;
	// 关卡的设置
	private int pass = 0;
	// 角色的x，y值的赋值
	private int rolex[] = new int[3];
	private int roley[] = new int[3];
	private Container panel;
	private static final int box = 4;
	private static final int cage = 8;
	private static final int cage_box = 12;
	// 数组是先列后行
	private JLabel[][] jlable = new JLabel[12][16];
	// 实际是0-11，0-15
	private int[][][] dates = new int[][][] {
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
					{ 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
					{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
					{ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } },
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } },
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } } };
	private int count = 0;
	private int total[] = { 3, 3, 4 };

	public MainFrame() {
		this.addKeyListener(this);
		this.setMenu();
		this.setBaseMainFrame();
		this.setCage();
		this.setRole();
		this.setBox();
		this.setBarrier();
		this.setBackground();
		// 可视化，可以刷新出来背景
		this.setVisible(true);
	}

	public MainFrame(int pass) {
		this.pass = pass;
		this.addKeyListener(this);
		this.setMenu();
		this.setBaseMainFrame();
		this.setCage();
		this.setRole();
		this.setBox();
		this.setBarrier();
		this.setBackground();
		// 可视化，可以刷新出来背景
		this.setVisible(true);
	}

	private void setBackground() {
		JLabel bg = new JLabel(new ImageIcon("floor.png"));
		bg.setBounds(20, 10, 800, 600);
		this.panel.add(bg);
	}

	private void setCage() {
		// 这是目标地的坐标初始化
		int cagex[][] = { { 4, 11, 8 }, { 14, 14, 14 }, { 4, 4, 3, 3 } };
		int cagey[][] = { { 1, 1, 3 }, { 4, 5, 6 }, { 9, 10, 10, 9 } };
		int cagexl = cagex[pass].length;
		int cageyl = cagey[pass].length;
		int n = 0;
		while (cagex[pass][n] > 0 && cagey[pass][n] > 0 && cagex[pass][n] < 16
				&& cagey[pass][n] < 12) {
			JLabel cg1 = new JLabel(new ImageIcon("8.png"));
			// pass代表当前关卡数
			// cagex[pass][0]代表当前关卡第一个箱子的x值
			cg1.setBounds(cagex[pass][n] * 50 + 20, cagey[pass][n] * 50 + 10,
					50, 50);
			// 把目标地标签添加到画布中
			this.panel.add(cg1);
			// 目的地标签的实际位置
			jlable[cagey[pass][n]][cagex[pass][n]] = cg1;
			// 目标地标签在屏幕的显示位置
			dates[pass][cagey[pass][n]][cagex[pass][n]] = cage;
			n++;
			if (n == cageyl || n == cagexl)
				break;
		}
	}

	private void setBox() {
		// 与设置目的地的做法相同
		int boxx[][] = { { 5, 8, 11 }, { 8, 7, 8 }, { 4, 5, 11, 12 } };
		int boxy[][] = { { 6, 6, 6 }, { 3, 7, 6 }, { 4, 4, 4, 5 } };
		int xlength = boxx[pass].length;
		int ylength = boxy[pass].length;
		int m = 0;
		while (boxx[pass][m] > 0 && boxy[pass][m] > 0 && boxx[pass][m] < 16
				&& boxy[pass][m] < 12) {

			JLabel box1 = new JLabel(new ImageIcon("4.png"));
			box1.setBounds(boxx[pass][m] * 50 + 20, boxy[pass][m] * 50 + 10,
					50, 50);
			this.panel.add(box1);
			jlable[boxy[pass][m]][boxx[pass][m]] = box1;
			dates[pass][boxy[pass][m]][boxx[pass][m]] = box;
			m++;
			if (m == xlength || m == ylength)
				break;
		}
	}

	private void setBarrier() {
		// 设置障碍
		for (int x = 0; x < dates[pass].length; x++) {
			for (int y = 0; y < dates[pass][x].length; y++) {
				if (dates[pass][x][y] == 1) {
					JLabel ba = new JLabel(new ImageIcon("1.png"));
					ba.setBounds(20 + 50 * y, 10 + 50 * x, 50, 50);
					this.panel.add(ba);
				}

			}
		}
	}

	private void setRole() {
		rolex = new int[] { 8, 3, 5 };
		roley = new int[] { 10, 6, 3 };
		role = new JLabel(new ImageIcon("40.png"));
		role.setBounds(rolex[pass] * 50 + 20, roley[pass] * 50 + 10, 50, 50);
		this.panel.add(role);
	}

	private void setBaseMainFrame() {
		this.panel = this.getContentPane();
		this.setSize(850, 680);
		this.setTitle("我的推箱子——v3.0  第" + (pass + 1) + "关");
		// 中间
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// 这是关闭事件
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel.setLayout(null);
		this.getContentPane().setLayout(null);
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage("tb.jpg");
		this.setIconImage(i);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int x = 0;
		int y = 0;
		if (key == 37) {
			x = -1;
			y = 0;
		}
		if (key == 38) {
			x = 0;
			y = -1;
		}
		if (key == 39) {
			x = 1;
			y = 0;
		}
		if (key == 40) {
			x = 0;
			y = 1;
		}
		if (key >= 37 && key <= 40) {
			role.setIcon(new ImageIcon( key + ".png"));
			// 如果前面是空地或者目标地才能走
			if (dates[pass][roley[pass] + y][rolex[pass] + x] == 0
					|| dates[pass][roley[pass] + y][rolex[pass] + x] == cage) {
				move(role, x, y);
				rolex[pass] = rolex[pass] + x;
				roley[pass] = roley[pass] + y;
				return;
			}
			// 如果前面是箱子或者是目标箱子，然后两种情况，前面的前面是空地或者前面的前面是目标地才可以走
			// 人物最后动！！！！！箱子先走！！！！！！！
			if (dates[pass][roley[pass] + y][rolex[pass] + x] == box
					|| dates[pass][roley[pass] + y][rolex[pass] + x] == cage_box) {
				int front = dates[pass][roley[pass] + y][rolex[pass] + x];
				int frontt = dates[pass][roley[pass] + y * 2][rolex[pass] + x
						* 2];
				if (frontt == cage || frontt == 0) {
					move(jlable[roley[pass] + y][rolex[pass] + x], x, y);
					// 箱子实际位置改变，数值改变_4种情况
					jlable[roley[pass] + y * 2][rolex[pass] + x * 2] = jlable[roley[pass]
							+ y][rolex[pass] + x];
					jlable[roley[pass] + y][rolex[pass] + x] = null;
					// 1.箱子——>空地
					if (front == box && frontt == 0) {
						dates[pass][roley[pass] + y * 2][rolex[pass] + x * 2] = box;
						dates[pass][roley[pass] + y][rolex[pass] + x] = 0;
					}
					// 2.箱子——>目的地
					if (front == box && frontt == cage) {
						dates[pass][roley[pass] + y * 2][rolex[pass] + x * 2] = cage_box;
						dates[pass][roley[pass] + y][rolex[pass] + x] = 0;
						count++;
						jlable[roley[pass] + y * 2][rolex[pass] + x * 2]
								.setIcon(new ImageIcon("4-0.png"));
					}
					// 3.目标里箱子——>空地
					if (front == cage_box && frontt == 0) {
						dates[pass][roley[pass] + y * 2][rolex[pass] + x * 2] = box;
						dates[pass][roley[pass] + y][rolex[pass] + x] = cage;
						count--;
						jlable[roley[pass] + y * 2][rolex[pass] + x * 2]
								.setIcon(new ImageIcon("4.png"));
					}
					// 4.目标里箱子——>空地
					if (front == cage_box && frontt == cage) {
						dates[pass][roley[pass] + y * 2][rolex[pass] + x * 2] = cage_box;
						dates[pass][roley[pass] + y][rolex[pass] + x] = cage;
						jlable[roley[pass] + y * 2][rolex[pass] + x * 2]
								.setIcon(new ImageIcon("4-0.png"));
					}
					// 显示位置改变
					move(role, x, y);
					// 实际位置改变
					rolex[pass] = rolex[pass] + x;
					roley[pass] = roley[pass] + y;
					victory();
				}
				return;
			}
		}

	}

	private void victory() {
		if (count == total[pass]) {
			// 移除键盘监控
			this.removeKeyListener(this);
			// JOptionPane.showMessageDialog(this, "游戏结束！");
			final JDialog victory = new JDialog(this, "恭喜你取得了胜利!", true);
			victory.setSize(600, 300);
			victory.setResizable(false);
			victory.setLocationRelativeTo(null);
			victory.setLayout(null);

			JLabel jl = new JLabel(new ImageIcon("gg.jpg"));
			jl.setBounds(110, 10, 381, 146);
			victory.add(jl);

			// JLabel syg = new JLabel("上一关");
			JButton jb = new JButton("上一关");
			jb.setBounds(100, 170, 80, 80);
			jb.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (pass > 0) {
						pass--;
						App.mf.setVisible(false);
						App.mf.dispose();
						victory.setVisible(false);
						victory.dispose();
						new App(pass);
					} else {
						JOptionPane.showMessageDialog(App.mf, "没有上一关了！");
					}
				}
			});
			victory.add(jb);

			// JLabel xyg = new JLabel("下一关");
			JButton jb2 = new JButton("下一关");
			jb2.setBounds(200, 170, 80, 80);

			jb2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (pass < total.length - 1) {
						pass++;
						App.mf.setVisible(false);
						App.mf.dispose();
						victory.setVisible(false);
						victory.dispose();
						new App(pass);
					} else {
						JOptionPane.showMessageDialog(App.mf, "恭喜你通过所有关卡");
					}
				}
			});
			victory.add(jb2);

			// JLabel tc = new JLabel("退出");
			JButton jb3 = new JButton("退出");
			jb3.setBounds(300, 170, 80, 80);
			jb3.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			victory.add(jb3);

			JButton jb4 = new JButton("选关");
			jb4.setBounds(400, 170, 80, 80);
			jb4.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					victory.setVisible(false);
					victory.dispose();
					App.xuanguan();
					App.mf.setVisible(false);
					App.mf.dispose();
				}
			});
			victory.add(jb4);

			victory.setVisible(true);
		}

	}

	private void setMenu() {
		MenuItem m1 = new MenuItem("重新开始");
		MenuItem m2 = new MenuItem("选择关卡");
		MenuItem m3 = new MenuItem("退出游戏");
		Menu m = new Menu("菜单");
		m.add(m1);
		m.add(m2);
		m.add(m3);
		MenuBar mb = new MenuBar();
		mb.add(m);
		this.setMenuBar(mb);
		m1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				App.mf.setVisible(false);
				App.mf.dispose();
				new App(pass);
			}
		});
		m2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				App.xuanguan();
				App.mf.setVisible(false);
				App.mf.dispose();
			}
		});
		m3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void move(JLabel j, int x, int y) {
		j.setLocation(x * 50 + j.getX(), y * 50 + j.getY());
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
