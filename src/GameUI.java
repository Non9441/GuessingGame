import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameUI {
	private JFrame frame;
	private JLabel hint, enterPrompt, countShown;
	private JPanel centerPanel, northPanel;
	private JTextField answer;
	private JButton enter, giveup;
	private GuessingGame game;

	public GameUI(GuessingGame game) {
		this.game = game;
		initComponent();
	}

	private void initComponent() {
		FlowLayout flow = new FlowLayout();
		frame = new JFrame();
		centerPanel = new JPanel();
		northPanel = new JPanel();
		hint = new JLabel(game.getHint());
		enterPrompt = new JLabel("Enter your guess:");
		countShown = new JLabel("You used " + game.getCount() + " guesses");
		answer = new JTextField(7);
		enter = new JButton("Enter");
		giveup = new JButton("Give Up");
		
		Enter enterlistener = new Enter();
		GiveUp giveuplistener = new GiveUp();
		
		enter.addActionListener(enterlistener);
		giveup.addActionListener(giveuplistener);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(countShown, BorderLayout.SOUTH);
		northPanel.setBorder(BorderFactory.createTitledBorder("Hint"));
		northPanel.add(hint);
		centerPanel.setLayout(flow);
		centerPanel.add(enterPrompt);
		centerPanel.add(answer);
		centerPanel.add(enter);
		centerPanel.add(giveup);
		frame.pack();

	}
	class Enter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				if(!game.guess(Integer.parseInt(answer.getText()))){
					hint.setText(game.getHint());
					countShown.setText("You used " + game.getCount() + " guesses");
				}
				else if(game.guess(Integer.parseInt(answer.getText()))){
					game.count--;
					hint.setText(game.getHint());
					countShown.setText("You used " + game.getCount() + " guesses");
				}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(frame, "Input invalid!!");
			}
			
		}
		
	}
	
	class GiveUp implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame, "You loose!\n"+"Secret number is "+game.secret);
			game.newRandom();
			
		}
		
	}

	public void run() {
		frame.setVisible(true);
	}

}
