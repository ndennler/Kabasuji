package general.boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;

import general.controller.EnterBuilderController;
import general.entity.Kabasuji;
import interfaces.ILevel;
import interfaces.IMenu;

import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ButtonGroup;

public class BuilderMenu extends JFrame implements IMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1261755679003541068L;
	private JPanel contentPane;
	private final ButtonGroup selector = new ButtonGroup();
	Kabasuji game;
	ILevel prepped = null;
	JTextArea textArea = new JTextArea();
	
	public void setPrepped(ILevel l){
		prepped = l;
	}
	public ILevel getPreppedLevel(){
		return prepped;
	}
	public ButtonGroup getButtonGroup(){
		return selector;
	}
	
	
	/**
	 * Create the frame.
	 */
	public BuilderMenu(Kabasuji k) {
		game = k;
		setTitle("Kabasuji Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane existingLevelsScrollPane = new JScrollPane();
		existingLevelsScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		existingLevelsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		existingLevelsScrollPane.setBounds(10, 27, 159, 481);
		contentPane.add(existingLevelsScrollPane);
		
		ExistingLevelButtonPanel existingLevelPanel = new ExistingLevelButtonPanel(this, k);
		existingLevelPanel.setLayout(null);
		existingLevelPanel.setBounds(0, 0, 159, 581);
		existingLevelsScrollPane.setViewportView(existingLevelPanel);
		
		
		JLabel lblEditExistingLevels = new JLabel("Edit Existing Levels:");
		lblEditExistingLevels.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblEditExistingLevels.setBounds(10, 11, 159, 14);
		contentPane.add(lblEditExistingLevels);
		
		JScrollPane newLevelScrollPane = new JScrollPane();
		newLevelScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		newLevelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		newLevelScrollPane.setBounds(179, 416, 245, 92);
		contentPane.add(newLevelScrollPane);
		
		NewLevelButtonPanel newLevel = new NewLevelButtonPanel(this, k);
		newLevelScrollPane.setViewportView(newLevel);
		newLevel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create New Level:");
		lblNewLabel.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblNewLabel.setBounds(179, 400, 245, 14);
		contentPane.add(lblNewLabel);
		
		
		textArea.setEditable(false);
		textArea.setFont(new Font("Constantia", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		textArea.setBounds(179, 27, 245, 319);
		contentPane.add(textArea);
		
		JLabel lblLevelDescription = new JLabel("Level Description:");
		lblLevelDescription.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblLevelDescription.setBounds(179, 10, 159, 14);
		contentPane.add(lblLevelDescription);
		
		JButton btnEnterBuilder = new JButton("Enter the Builder");
		btnEnterBuilder.setFont(new Font("Constantia", Font.PLAIN, 12));
		btnEnterBuilder.setBackground(new Color(245, 245, 245));
		btnEnterBuilder.setBounds(179, 357, 245, 32);
		contentPane.add(btnEnterBuilder);
		btnEnterBuilder.addActionListener(new EnterBuilderController(game, this));
	}
	@Override
	public JTextArea getTextArea() {
		return textArea;
	}
	@Override
	public JLabel getImageLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setPreppedLevel(ILevel l) {
		prepped = l;
	}
	@Override
	public void setStarsLabel(int stars) {
		return;
	}
}
