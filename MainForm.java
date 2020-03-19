package form;
import javax.imageio.ImageIO;
import javax.swing.*;

import helper.Database;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame implements ActionListener{

	public MainForm(){
		setBackground();
		Menu();
		setTitle("BlueJack Library || Main Form");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		if(Database.Role.equals("admin")){
			
			cp.setVisible(false);	
		}
		
		
		dp.add(new InternalForm(this,dp));
	}
	
	JDesktopPane dp;
	Image img;
	
	void setBackground(){
		try{
			img=ImageIO.read(new File("assets/background.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
		dp = new JDesktopPane(){
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(img,0,0,getWidth(),getHeight(),null);

			}
		};
		
		setContentPane(dp);
	
	}
	JMenuBar mBar;
	JMenu mAccount;
	JMenuItem exit,cp;
	
	void Menu(){
		mBar = new JMenuBar();
		mAccount = new JMenu("Account");
		mAccount.addActionListener(this);
		exit = new JMenuItem("Log out");
		exit.addActionListener(this);
		cp = new JMenuItem("Change Password");
		cp.addActionListener(this);
		mAccount.add(cp);
		mAccount.addSeparator();
		mAccount.add(exit);
		mBar.add(mAccount);
		setJMenuBar(mBar);
		
	}
	
	ChangePasswordForm cpf;
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==exit){
			dispose();
			new LoginForm();
		}else if(e.getSource()==cp){
			if(cpf==null ||cpf.isClosed()){
				cpf=new ChangePasswordForm(this);
				dp.add(cpf);
			}
		}
		
	}

}
