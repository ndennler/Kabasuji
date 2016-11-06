package general.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import general.controller.PlayLevelController;
import general.entity.Kabasuji;
import interfaces.ILevel;
import interfaces.IMenu;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class PlayerMenu extends JFrame implements IMenu{

	private JPanel contentPane;
	private ButtonGroup buttonGroup  = new ButtonGroup();

	JTextArea textArea = new JTextArea();
	JLabel imageLabel = new JLabel("possible image one day");
	JLabel lblStars = new JLabel("");
	ILevel prepped;
	Kabasuji game;
	
	public ButtonGroup getButtonGroup(){
		return buttonGroup;
	}
	

	/**
	 * Create the frame.
	 */
	public PlayerMenu(Kabasuji k) {
		game = k;
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 493);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 236, 432);
		contentPane.add(scrollPane);
		
		LevelSelectButtonPanel panel = new LevelSelectButtonPanel(this, game);
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		imageLabel.setFont(new Font("Constantia", Font.PLAIN, 12));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(256, 11, 406, 240);
		contentPane.add(imageLabel);
		
		
		lblStars.setHorizontalAlignment(SwingConstants.CENTER);
		lblStars.setBounds(256, 323, 406, 58);
		contentPane.add(lblStars);
		
		JButton btnPlayLevel = new JButton("Play Level");
		btnPlayLevel.setFont(new Font("Constantia", Font.PLAIN, 12));
		btnPlayLevel.setBackground(new Color(245, 245, 245));
		btnPlayLevel.setBounds(398, 392, 124, 51);
		contentPane.add(btnPlayLevel);
		textArea.setFont(new Font("Constantia", Font.PLAIN, 14));
		
		
		textArea.setEditable(false);
		textArea.setBounds(256, 261, 406, 51);
		contentPane.add(textArea);
		
		btnPlayLevel.addActionListener(new PlayLevelController(game, this));
	}

	@Override
	public JTextArea getTextArea() {
		return textArea;
	}

	@Override
	public JLabel getImageLabel() {
		return imageLabel;
	}

	@Override
	public void setPreppedLevel(ILevel l) {
		prepped = l;
		
	}

	@Override
	public void setStarsLabel(int stars) {
		if(stars == 0){
			lblStars.setIcon(null);
		}
		if(stars == 1){
			lblStars.setIcon(new ImageIcon(PlayerMenu.class.getResource("/images/OneStar.png")));
		}
		if(stars == 2){
			lblStars.setIcon(new ImageIcon(PlayerMenu.class.getResource("/images/TwoStars.png")));
		}
		if (stars == 3){
			lblStars.setIcon(new ImageIcon(PlayerMenu.class.getResource("/images/ThreeStars.png")));
		}
	}


	public ILevel getPreppedLevel() {
		return prepped;
	}
}
