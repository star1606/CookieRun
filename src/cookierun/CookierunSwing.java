package cookierun;

import java.awt.Component;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CookierunSwing extends JFrame {
	private CookiePanel cp;

	ImageIcon backIc = new ImageIcon("img/bg.png");
	Image backImg = backIc.getImage();
	Image backImg2 = backIc.getImage();

	ImageIcon human = new ImageIcon("img/finn.gif");
	Image finn = human.getImage();

	int backX = 0;
	int backX2 = backImg.getWidth(null);
	int humanPosition = 200;

	public CookierunSwing() {
		setTitle("Cookierun");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		cp = new CookiePanel();
		setContentPane(cp);

		setSize(700, 500);
		setVisible(true);
	}

	class CookiePanel extends JPanel {

		public CookiePanel() {
			setFocusable(true);
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					System.out.println("keycod :" + e.getKeyCode());
					System.out.println("keychar :" + e.getKeyChar());
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						new Thread(new Runnable() {

							@Override
							public void run() {
								int a = 100;
								while (a > 0) {

									if (a >= 50) {
										humanPosition = humanPosition - 5;
									} else
										humanPosition = humanPosition + 5;
									a = a - 1;
									
									try {
										Thread.sleep(10);
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}

							}
						}).start();
					}

				}
			});

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						backX = backX - 10;
						backX2 = backX2 - 10;

						if (backX < -(backImg.getWidth(null))) {
							System.out.println("good");
							backX = backImg.getWidth(null) - 1;
						}
						if (backX2 < -(backImg.getWidth(null))) {
							System.out.println("good");
							backX2 = backImg.getWidth(null) - 1;
						}
						repaint();

						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}
			}).start();

		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(backImg, backX, 0, this);
			g.drawImage(backImg, backX2+1, 0, this);
			g.drawImage(backImg, backX2-1, 0, this);
			g.drawImage(finn, 250, humanPosition, 200, 200, this);

		}

	}

	public static void main(String[] args) {
		new CookierunSwing();
	}

}

//이미지를 넣기
//캐릭터위치 (고정)