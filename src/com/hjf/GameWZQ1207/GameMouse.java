package com.hjf.GameWZQ1207;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameMouse extends MouseAdapter implements Config, ActionListener {
	private JPanel j;
	private Graphics g;
	private int x1, y1;
	private int xx, yy; // ��ǰ���ӵĽ���λ��
	private int count = 0; // �������ӵ���ɫ
	private int[][] chessArray = new int[LINE + 2][LINE + 2]; // �������ӵĶ�ά����
	// ʹ����ֻ���ڽ�����
	AI a;

	// �����ʤ��Ľ���
	public void bwin() {
		javax.swing.JFrame jf = new javax.swing.JFrame();
		java.awt.FlowLayout fl = new java.awt.FlowLayout();
		jf.setLayout(fl);
		javax.swing.JLabel jlb = new javax.swing.JLabel("�����ʤ");
		jlb.setFont(new java.awt.Font("Dialog", 1, 100));
		// ��dialog���������壬1������ʽ(1�Ǵ��壬0��ƽ���ģ�15���ֺ�
		jf.setSize(500, 200);
		jf.add(jlb);
		// javax.swing.JButton jbu=new javax.swing.JButton("����һ��");
		// Dimension di=new Dimension(100,60);
		// jbu.setPreferredSize(di);
		// jf.add(jbu);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);
	}

	// �����ʤ��Ľ���
	public void hwin() {
		javax.swing.JFrame jf = new javax.swing.JFrame();
		java.awt.FlowLayout fl = new java.awt.FlowLayout();
		jf.setLayout(fl);
		javax.swing.JLabel jlb = new javax.swing.JLabel("�����ʤ");
		jlb.setFont(new java.awt.Font("Dialog", 1, 100));
		// ��dialog���������壬1������ʽ(1�Ǵ��壬0��ƽ���ģ�15���ֺ�
		jf.setSize(500, 200);
		jf.add(jlb);
		// javax.swing.JButton jbu=new javax.swing.JButton("����һ��");
		// Dimension di=new Dimension(100,60);
		// jbu.setPreferredSize(di);
		// jf.add(jbu);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);
	}

	/**
	 * ���幹�췽����������ʼ�����ʶ���
	 * 
	 * @param g
	 */
	// �����������
	public GameMouse(Graphics g, int[][] chessArray, JPanel j) {
		this.chessArray = chessArray;
		this.j = j;
		this.g = g;

	}

	// �жϺ���Ͱ���Ļ�ʤ��ʽ
	// ��
	public int checkrow(int x, int y) {
		int count1 = 0;// �����������ͬ��ɫ��������
		for (int i = x + 1; i < 15; i++) {
			if (chessArray[Math.abs(i)][y] == chessArray[x][y]) {
				count1++;
				System.out.println(count1);
			} else {
				break;
			}
		}
		for (int i = x; i >= 0; i--) {
			if (chessArray[Math.abs(i)][y] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}

		return count1;
	}

	// ��
	public int checkcolumn(int x, int y) {
		int count1 = 0;// �����������ͬ��ɫ��������
		for (int i = y + 1; i < 15; i++) {
			if (chessArray[x][Math.abs(i)] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		for (int i = y; i >= 0; i--) {
			if (chessArray[x][Math.abs(i)] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}

		return count1;
	}

	// б
	public int checkinclined1(int x, int y) {
		int count1 = 0;// �����������ͬ��ɫ��������
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
				System.out.println(count1);
			} else {
				break;
			}
		}
		for (int i = x + 1, j = y + 1; i < LINE && j < LINE; i++, j++) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		return count1;
		
	}

	public int checkinclined2(int x, int y) {
		int count1 = 0;
		for (int i = x - 1, j = y + 1; i >= 0 && j < LINE; i--, j++) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		for (int i = x + 1, j = y - 1; i < LINE && j >= 0; i++, j--) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		return count1;
	}
	public void gameWin(int x,int y){
		if(checkinclined1(x, y)>=4||checkinclined2(x,y)>=4||checkcolumn(x,y)>=5||checkrow(x,y)>=5){
			if(chessArray[x][y] == -1){
				hwin();
			}else if(chessArray[x][y] == 1){
				bwin();
			}
		}
	}



	public void rr() {
		// �������ӽ���
		if ((x1 - X) % SIZE > SIZE / 2) {
			xx = (x1 - X) / SIZE + 1;
		} else {
			xx = (x1 - X) / SIZE;
		}
		if ((y1 - Y) % SIZE > SIZE / 2) {
			yy = (y1 - Y) / SIZE + 1;
		} else {
			yy = (y1 - Y) / SIZE;
		}

		// �������ӵĺڰ�ɫ�������
		if (chessArray[xx][yy] == 0) {
			if (count == 1) {
				g.setColor(Color.WHITE);
				chessArray[xx][yy] = 1;
				count--;
			} else {
				g.setColor(Color.BLACK);
				chessArray[xx][yy] = -1;
				count++;
			}
			//�ж�ʤ��
			g.fillOval(xx * SIZE + X - CHESS / 2, yy * SIZE + Y - CHESS / 2,CHESS, CHESS);
			gameWin(xx, yy);
		}
	}

	public void rj() {
		// �������ӽ���
		if ((x1 - X) % SIZE > SIZE / 2) {
			xx = (x1 - X) / SIZE + 1;
		} else {
			xx = (x1 - X) / SIZE;
		}
		if ((y1 - Y) % SIZE > SIZE / 2) {
			yy = (y1 - Y) / SIZE + 1;
		} else {
			yy = (y1 - Y) / SIZE;
		}

		if (chessArray[xx][yy] == 0) {
			g.setColor(Color.BLACK);
			chessArray[xx][yy] = -1;
			g.fillOval(xx * SIZE + X - CHESS / 2, yy * SIZE + Y - CHESS / 2,
					CHESS, CHESS);
		}

	}

	public void mouseClicked(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		if (z == 1) {
			rr();
		}
		if (z == 2) {
			rj();
			gameWin(xx, yy);
			try {
		    	  Thread.sleep(350);
		       }catch(Exception ef) {}
			a.ai();
			gameWin(a.getmaxi(), a.getmaxj());
			
			// for(int j=0;j<LINE;j++){
			// for(int i=0;i<LINE;i++){
			// System.out.print(chessArray[i][j]+"  ");
			// }
			// System.out.println();
			// }
		}

	}

	// �����õİ�ť���й���ʵ��
	public int z;

	public void actionPerformed(ActionEvent e) {
		System.out.println("str" + e.getActionCommand());

		if (e.getActionCommand().equals("��ʼ��Ϸ")) {
			j.addMouseListener(this);
		}
		if (e.getActionCommand().equals("���˶�ս")) {
			z = 1;
		}
		if (e.getActionCommand().equals("�˻���ս")) {
			a = new AI(g, chessArray, j);
			z = 2;
		}
		if (e.getActionCommand().equals("����")) {
			System.out.println("2");
			for (int i = 0; i < LINE; i++) {
				for (int j = 0; j < LINE; j++) {
					chessArray[xx][yy] = 0;
					count = 0;
				}
			}
			j.repaint();

		}
		if (e.getActionCommand().equals("���¿�ʼ")) {
			System.out.println("1");
			// ����repaint������е����Ӳ�ʹÿ���¹��ĵ��������
			for (int i = 0; i < LINE; i++) {
				for (int j = 0; j < LINE; j++) {
					chessArray[i][j] = 0;
					count = 0;
				}
			}
			j.repaint();
		}

	}

}
