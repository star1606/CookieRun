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
	private CookiePanel cp = new CookiePanel();

	public CookierunSwing() {
		setTitle("Cookierun");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(cp);

		setSize(500, 300);
		setVisible(true);
	}

	class CookiePanel extends JPanel {
		int imgX = 0;
		int imgY = 0;

		public CookiePanel() {
			setFocusable(true);
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					System.out.println("keycod :" + e.getKeyCode());
					System.out.println("keychar :" + e.getKeyChar());
					
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			ImageIcon imgBlack = new ImageIcon("img/black.png");
			ImageIcon imgRunning = new ImageIcon("img/running.gif");

			Image black = imgBlack.getImage();
			Image running = imgRunning.getImage();
			g.drawImage(black, imgX, 0, this.getWidth(), this.getHeight(), this);

			g.drawImage(running, 120, 100, 50, 50, this);
		
			
			
			
			
		
			
			
		}
		public void actionPerformed(ActionEvent e) {
			if(imgX < 0 || imgX> 500) {
				imgX = imgX - 10;
			}
			repaint();
		}
	
	
	}

	public static void main(String[] args) {
		new CookierunSwing();
	}

}

//이미지를 넣기
//캐릭터위치 (고정)