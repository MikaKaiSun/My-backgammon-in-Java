package ynu.xzw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChessBoardPanel extends JPanel implements MouseListener{
	
	Chess[][] chesses =new Chess[19][19];
	boolean isBlackTurn=true;
	boolean wheatherWin = false;
	String informationString;
	public ChessBoardPanel(){
		//this.setBackground(Color.ORANGE);
		this.addMouseListener(this);
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Font font = new Font("宋体", 10, 30);
		g.setFont(font);
		g.setColor(Color.BLUE);
		informationString="现在轮到"+(isBlackTurn?"黑":"白")+"方落子";
		g.drawString(informationString, 200, 50);
		for (int i = 0; i < 19; i++) {			
			g.drawLine(50, 80+30*i, 590, 80+30*i);
			g.drawLine(50+30*i, 80, 50+30*i, 620);
		}
		g.fillOval(316, 346, 8, 8);
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (chesses[i][j]!=null) {
					if (chesses[i][j].isBlack()) {
						g.setColor(Color.BLACK);
						g.fillOval(39+i*30, 69+30*j, 22, 22);
					}
					else {
						g.setColor(Color.WHITE);
						g.fillOval(39+i*30, 69+30*j, 22, 22);
						g.setColor(Color.BLACK);
						g.drawOval(39+i*30, 69+30*j, 22, 22);
					}
				}
			}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getX()+"-----"+e.getY());
		int X=Caculate.transit(e.getX(), 50);
		int Y=Caculate.transit(e.getY(), 80);
		//System.out.println(X+"-----"+Y);
		if (!wheatherWin&&X>=0&&X<=18&&Y>=0&&Y<=18) {
			if (chesses[X][Y]!=null) {
				JOptionPane.showMessageDialog(this, "该处已经有棋子，请重新落子！");
			}
			else {
				chesses[X][Y]=new Chess(isBlackTurn, X, Y);
				isBlackTurn=!isBlackTurn;
				repaint();
				if (isWin(X,Y)) {
					this.wheatherWin= true;
					JOptionPane.showMessageDialog(this, "恭喜！"+(chesses[X][Y].isBlack()?"黑":"白")+"方赢了！");
				}
				
			}
		}
		
	}
	private boolean isWin(int X,int Y) {
		// TODO Auto-generated method stub
		if(judge(X, Y, 1, 0)||judge(X, Y, 0, 1) ||judge(X, Y, 1, 1) ||judge(X, Y, 1, -1)){
			return true;
		}
		else 
			return false;
	}
	boolean judge(int X,int Y,int xChange,int yChange){
		int x=X;
		int y=Y;
		int sum =1;
		x=x+xChange;
		y=y+yChange;
		while(x>=0&&x<=18&&y>=0&&y<=18&&chesses[x][y]!=null&&chesses[x][y].isBlack()==chesses[X][Y].isBlack()){
			sum++;
			x=x+xChange;
			y=y+yChange;
		}
		x=X;
		y=Y;
		x=x-xChange;
		y=y-yChange;
		while(x>=0&&x<=18&&y>=0&&y<=18&&chesses[x][y]!=null&&chesses[x][y].isBlack()==chesses[X][Y].isBlack()){
			sum++;
			x=x-xChange;
			y=y-yChange;
		}
		if (sum>=5) {
			return true;
		}
			return false;
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
