package puzzle;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.boundary.BoardPanel;
import general.boundary.BullpenPanel;
import general.controller.anyLevel.FlipController;
import general.controller.anyLevel.MovePieceController;
import general.controller.anyLevel.PlayerSelectPieceController;
import general.controller.anyLevel.RotateController;
import general.entity.Kabasuji;
import general.entity.LevelMemento;
import interfaces.ILevel;
import interfaces.ILevelGUI;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PuzzleLevelGUI extends JFrame implements ILevelGUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7377915525033111193L;
	private JPanel contentPane;
	
	JProgressBar progressBar = new JProgressBar();

	Kabasuji game;
	
	/**
	 * Create the frame.
	 */
	public PuzzleLevelGUI(PuzzleLevel level, Kabasuji game) {
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 540);
		setTitle(level.getType());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 359, 114);
		contentPane.add(scrollPane);

		
		JButton btnRotateCC = new JButton("");
		btnRotateCC.setBackground(new Color(245, 245, 245));
		btnRotateCC.setIcon(new ImageIcon(PuzzleLevelGUI.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnRotateCC.setBounds(379, 11, 47, 59);
		contentPane.add(btnRotateCC);
		
		JButton btnFlipH = new JButton("");
		btnFlipH.setBackground(new Color(245, 245, 245));
		btnFlipH.setIcon(new ImageIcon(PuzzleLevelGUI.class.getResource("/images/flipHorizontal.png")));
		btnFlipH.setBounds(427, 11, 47, 59);
		contentPane.add(btnFlipH);
		
		JButton btnRotateC = new JButton("");
		btnRotateC.setBackground(new Color(245, 245, 245));
		btnRotateC.setIcon(new ImageIcon(PuzzleLevelGUI.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnRotateC.setBounds(379, 66, 47, 59);
		contentPane.add(btnRotateC);
		
		JButton btnFlipV = new JButton("");
		btnFlipV.setBackground(new Color(245, 245, 245));
		btnFlipV.setIcon(new ImageIcon(PuzzleLevelGUI.class.getResource("/images/flipVertical.png")));
		btnFlipV.setBounds(427, 66, 47, 59);
		contentPane.add(btnFlipV);
		
		
		progressBar.setForeground(new Color(173, 216, 230));
		progressBar.setValue(0);
		progressBar.setMaximum(3);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(379, 136, 17, 168);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PuzzleLevelGUI.class.getResource("/images/ThreeStars.png")));
		lblNewLabel.setBounds(400, 130, 74, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PuzzleLevelGUI.class.getResource("/images/TwoStars.png")));
		lblNewLabel_1.setBounds(400, 185, 74, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PuzzleLevelGUI.class.getResource("/images/OneStar.png")));
		lblNewLabel_2.setBounds(400, 240, 46, 19);
		contentPane.add(lblNewLabel_2);
		
		JButton btnReturn = new JButton("Return to Menu");
		btnReturn.setBackground(new Color(245, 245, 245));
		btnReturn.setFont(new Font("Constantia", Font.PLAIN, 9));
		btnReturn.setBounds(379, 455, 95, 35);
		contentPane.add(btnReturn);
		
		JButton btnGiveUp = new JButton("Give Up");
		btnGiveUp.setBackground(new Color(245, 245, 245));
		btnGiveUp.setForeground(new Color(0, 0, 0));
		btnGiveUp.setFont(new Font("Constantia", Font.PLAIN, 9));
		btnGiveUp.setBounds(379, 409, 95, 35);
		contentPane.add(btnGiveUp);
		
		JLabel lblMovesLeft = new JLabel("Moves Left:");
		lblMovesLeft.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblMovesLeft.setBounds(379, 315, 67, 14);
		contentPane.add(lblMovesLeft);
		
		JLabel lblMoves = new JLabel(level.movesLeft.toString());
		lblMoves.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		lblMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoves.setBounds(380, 331, 94, 67);
		contentPane.add(lblMoves);
		
		BullpenPanel bullpenView = new BullpenPanel(level.getBullpen(), 13, 10);
		scrollPane.setViewportView(bullpenView);
		
		BoardPanel boardView = new BoardPanel(level, 28, 10);
		boardView.setBounds(10, 131, 359, 359);
		contentPane.add(boardView);
		
		
		
		//attach controllers
		bullpenView.addMouseListener(new PuzzleSelectPieceController(boardView, bullpenView, level, lblMoves));
		
		boardView.addMouseMotionListener(new MovePieceController(level, boardView));
		boardView.addMouseListener(new MovePieceController(level, boardView));
		boardView.addMouseListener(new PlacePuzzlePieceController(level, boardView, lblMoves, game, this));
		
		btnFlipV.addActionListener(new FlipController(level, boardView, true));
		btnFlipH.addActionListener(new FlipController(level, boardView, false));
		btnRotateC.addActionListener(new RotateController(level, boardView, true));
		btnRotateCC.addActionListener(new RotateController(level, boardView, false));
		
		
	}

	@Override
	public String getLevelType() {
		return "Puzzle";
	}

	@Override
	public ILevel getGenericLevel() {
		return new PuzzleLevel();
	}

	@Override
	public void restore(LevelMemento level) {
		PuzzleLevel l = new PuzzleLevel();
		l.restore(level);
		new PuzzleLevelGUI(l, game).setVisible(true);
		this.dispose();
	}

	@Override
	public JFrame getFrame() {
		return this;
	}

	@Override
	public void setGame(Kabasuji k) {
		game = k;
	}

	@Override
	public void setProgressBar(int p) {
		progressBar.setValue(p);
	}
}
