package ninjase.boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ninjase.controller.MoveController;
import ninjase.controller.ResetController;
import ninjase.model.Model;
import ninjase.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class NinjaSeApp extends JFrame {

	private JPanel contentPane;
	int level;
	BoardPanel panel;
	Model model;
	JButton btnUp, btnDown, btnLeft, btnRight, Level1Btn, Level2Btn, Level3Btn, ResetBtn;
	JLabel ActualMoves, winGame;
	
	public JButton getUpButton() {return btnUp;}
	public JButton getDownButton() {return btnDown;}
	public JButton getLeftButton() {return btnLeft;}
	public JButton getRightButton() {return btnRight;}
	public JButton getResetButton() {return ResetBtn;}
	public JButton getL1Button() {return Level1Btn;}
	public JButton getL2Button() {return Level2Btn;}
	public JButton getL3Button() {return Level3Btn;}
	public JLabel getActualMoves() {return ActualMoves;} 
	public JLabel getWinMessage() {return winGame;}
	public Model getModel() {return this.model;}
	
	public void setModel(Model m) {this.model = m;}
	/**
	 * Create the frame.
	 */

	
	public NinjaSeApp(Model m) {
		super();
		this.model = m;
		
		setTitle("Ninja-se Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 850);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new BoardPanel(model);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 650, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 380, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		btnUp = new JButton("^");
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(model, NinjaSeApp.this).move(MoveType.Up);
			}
			
		});
		
		btnLeft = new JButton("<");
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLeft.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(model, NinjaSeApp.this).move(MoveType.Left);
			}
			
		});
		
		btnRight = new JButton(">");
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRight.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(model, NinjaSeApp.this).move(MoveType.Right);
			}
			
		});
		
		btnDown = new JButton("v");
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDown.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(model, NinjaSeApp.this).move(MoveType.Down);
			}
			
		});
		
		Level2Btn = new JButton("Level 2");
		Level2Btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Level2Btn.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, NinjaSeApp.this).reset(2);
			}
			
		});
		
		Level1Btn = new JButton("Level 1");
		Level1Btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Level1Btn.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, NinjaSeApp.this).reset(1);
			}
			
		});
		
		Level3Btn = new JButton("Level 3");
		Level3Btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Level3Btn.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, NinjaSeApp.this).reset(3);
			}
			
		});
		
		ResetBtn = new JButton("Reset");
		ResetBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ResetBtn.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, NinjaSeApp.this).reset(model.getLevel());
			}
			
		});
		
		ActualMoves = new JLabel("" + model.getNumMove());
		ActualMoves.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel NumMove = new JLabel("Number of Moves: ");
		NumMove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		winGame = new JLabel("");
		winGame.setForeground(Color.RED);
		winGame.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Level2Btn)
						.addComponent(Level1Btn)
						.addComponent(Level3Btn))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(126)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(NumMove)
									.addGap(18)
									.addComponent(ActualMoves)
									.addGap(20))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(ResetBtn)
									.addGap(1))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addGap(44))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(winGame, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
					.addGap(115))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(winGame, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(Level1Btn)
								.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(Level2Btn)
								.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(NumMove)
								.addComponent(ActualMoves))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(ResetBtn)
						.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(Level3Btn))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
		
		UpdateButtons.enableMoveButtons(this, this.model.availableMoves());
		UpdateButtons.enableLevelButtons(this);
	}
}
