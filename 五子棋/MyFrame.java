package ynu.xzw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class MyFrame extends JFrame implements ActionListener{
	ChessBoardPanel chessBoard = new ChessBoardPanel();
	JMenu menu= new JMenu("系统");
	JMenuBar bar=new JMenuBar();
	JMenuItem restartItem=new JMenuItem("重新开始");
	JMenuItem exitItem=new JMenuItem("退出游戏");;
	
	public MyFrame(){
		this.setTitle("五子棋游戏");
		this.setSize(640, 680);
		this.add(chessBoard);
		menu.add(restartItem);
		menu.add(exitItem);
		bar.add(menu);
		restartItem.addActionListener(this);
		exitItem.addActionListener(this);
		this.setJMenuBar(bar);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==this.restartItem) {
			//System.out.println("重新开始");
			chessBoard.wheatherWin=false;
			chessBoard.isBlackTurn=true;
			for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 19; j++) {
					chessBoard.chesses[i][j]=null;
				}
			}
			repaint();
		}
		if (arg0.getSource()==this.exitItem) {
			if(JOptionPane.showConfirmDialog(this, "确定要退出吗？", "退出", 0)==0){
			System.exit(0);}
		}
	}
	
	
	

}
