package lightning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import general.boundary.BoardPanel;
import general.boundary.BullpenPanel;
import general.boundary.StockPanel;
import general.controller.anyBuilder.BoardSizeController;
import general.controller.anyBuilder.BuilderPlacePieceController;
import general.controller.anyBuilder.BuilderSelectPieceController;
import general.controller.anyBuilder.SaveBuiltLevelController;
import general.controller.anyBuilder.StockToBullpenController;
import general.controller.anyBuilder.TileMovingController;
import general.controller.anyLevel.FlipController;
import general.controller.anyLevel.MovePieceController;
import general.controller.anyLevel.RotateController;
import general.entity.Kabasuji;
import general.entity.LevelMemento;
import interfaces.IBuilderGUI;
import interfaces.ILevel;
import interfaces.IStock;
import puzzle.ChangeNumberMovesController;
import puzzle.PuzzleBuilderGUI;
import puzzle.PuzzleLevel;

public class LightningBuilderGUI extends JFrame implements IBuilderGUI{

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	ILevel level;
	BoardPanel boardView;
	BullpenPanel bullpenView;
	IStock stock;
	Kabasuji game;

	/**
	 * Create the frame.
	 * @param k 
	 * @param stock 
	 * @param l 
	 */
	public LightningBuilderGUI(ILevel l, IStock stock, Kabasuji k) {
		level = l;
		this.stock = stock;
		game = k;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 558);
		setTitle(level.getType() + " Builder");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane stockScrollPane = new JScrollPane();
		stockScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		stockScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		stockScrollPane.setBounds(541, 11, 175, 497);
		contentPane.add(stockScrollPane);
		
		JScrollPane bullpenScrollPane = new JScrollPane();
		bullpenScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bullpenScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		bullpenScrollPane.setBounds(10, 11, 396, 90);
		contentPane.add(bullpenScrollPane);
		
		
		
		JButton btnRotateCl = new JButton("");
		btnRotateCl.setBackground(new Color(245, 245, 245));
		btnRotateCl.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnRotateCl.setBounds(416, 57, 61, 44);
		contentPane.add(btnRotateCl);
		
		JButton btnRotateCCl = new JButton("");
		btnRotateCCl.setBackground(new Color(245, 245, 245));
		btnRotateCCl.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnRotateCCl.setBounds(416, 11, 61, 44);
		contentPane.add(btnRotateCCl);
		
		JButton btnFlipH = new JButton("");
		btnFlipH.setBackground(new Color(245, 245, 245));
		btnFlipH.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/images/flipHorizontal.png")));
		btnFlipH.setBounds(477, 11, 54, 44);
		contentPane.add(btnFlipH);
		
		JButton btnFlipV = new JButton("");
		btnFlipV.setBackground(new Color(245, 245, 245));
		btnFlipV.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/images/flipVertical.png")));
		btnFlipV.setBounds(477, 57, 54, 44);
		contentPane.add(btnFlipV);
		
		JSpinner timeSpinner = new JSpinner();
		timeSpinner.setFont(new Font("Constantia", Font.PLAIN, 12));
		timeSpinner.setForeground(new Color(105, 105, 105));
		timeSpinner.setModel(new SpinnerNumberModel((int)level.getExtraLogic().get(0), new Integer(1), null, new Integer(1)));
		timeSpinner.setBounds(477, 131, 54, 33);
		contentPane.add(timeSpinner);
		
		JLabel lblNumberOfMoves = new JLabel("Time Given:");
		lblNumberOfMoves.setForeground(new Color(105, 105, 105));
		lblNumberOfMoves.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblNumberOfMoves.setBounds(416, 112, 115, 14);
		contentPane.add(lblNumberOfMoves);
		
		JToggleButton movePiecesBtn = new JToggleButton("Move Pieces");
		movePiecesBtn.setForeground(new Color(105, 105, 105));
		movePiecesBtn.setSelected(true);
		movePiecesBtn.setBackground(new Color(245, 245, 245));
		buttonGroup.add(movePiecesBtn);
		movePiecesBtn.setBounds(416, 260, 115, 44);
		contentPane.add(movePiecesBtn);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(245, 245, 245));
		btnSave.setForeground(new Color(105, 105, 105));
		btnSave.setBounds(416, 464, 115, 44);
		contentPane.add(btnSave);
		
		JToggleButton moveTileBtn = new JToggleButton("Move Tile");
		buttonGroup.add(moveTileBtn);
		moveTileBtn.setForeground(new Color(105, 105, 105));
		moveTileBtn.setBackground(new Color(245, 245, 245));
		moveTileBtn.setBounds(416, 315, 115, 44);
		contentPane.add(moveTileBtn);
		
		JLabel lblBoardSize = new JLabel("Board Size:");
		lblBoardSize.setForeground(SystemColor.controlDkShadow);
		lblBoardSize.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblBoardSize.setBounds(416, 175, 115, 14);
		contentPane.add(lblBoardSize);
		
		JSpinner boardSizeSpinner = new JSpinner();
		boardSizeSpinner.setToolTipText("Number of tiles on the board.");
		boardSizeSpinner.setModel(new SpinnerNumberModel(level.getBoard().numberofTiles(), 1, 144, 1));
		boardSizeSpinner.setFont(new Font("Constantia", Font.PLAIN, 12));
		boardSizeSpinner.setForeground(new Color(105, 105, 105));
		boardSizeSpinner.setBounds(477, 200, 54, 33);
		contentPane.add(boardSizeSpinner);
		
		bullpenView = new BullpenPanel(level.getBullpen(), 10, 7);
		bullpenScrollPane.setViewportView(bullpenView);
		
		StockPanel stockView = new StockPanel(stock, 10, 25);
		stockScrollPane.setViewportView(stockView);
		
		boardView = new BoardPanel(level, 31, 10);
		boardView.setBackground(SystemColor.menu);
		boardView.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		boardView.setBounds(10, 112, 396, 396);
		contentPane.add(boardView);
		
		
		stockView.addMouseListener(new StockToBullpenController(stockView,bullpenView,level));
		
		bullpenView.addMouseListener(new BuilderSelectPieceController(boardView, bullpenView, level, movePiecesBtn));
		
		boardView.addMouseMotionListener(new MovePieceController(level, boardView));
		boardView.addMouseListener(new MovePieceController(level, boardView));
		boardView.addMouseListener(new BuilderPlacePieceController(level, boardView, movePiecesBtn));
		boardView.addMouseListener(new TileMovingController(level, boardView, moveTileBtn));
		boardView.addMouseMotionListener(new TileMovingController(level, boardView, moveTileBtn));
		
		btnRotateCl.addActionListener(new RotateController(level, boardView, true));
		btnRotateCCl.addActionListener(new RotateController(level, boardView, false));
		btnFlipV.addActionListener(new FlipController(level, boardView, true));
		btnFlipH.addActionListener(new FlipController(level, boardView, false));
		
		boardSizeSpinner.addChangeListener(new BoardSizeController(level, boardView, boardSizeSpinner));
		
		timeSpinner.addChangeListener(new SetTimeController(timeSpinner, (LightningLevel) level));
		
		btnSave.addActionListener(new SaveBuiltLevelController(this, k));
	}

	@Override
	public String getLevelName() {
		return "Lightning";
	}

	@Override
	public String getDescription() {
		return "Cover pieces on the board before the time runs out! (written in gui class)";
	}

	@Override
	public void restore(LevelMemento m) {
		ILevel loading = level;
		loading.restore(m);
		new LightningBuilderGUI(loading, stock, game).setVisible(true);
		this.dispose();
	}

	@Override
	public void newBuilder(ILevel l) {
		new LightningBuilderGUI(l, stock, game).setVisible(true);
		this.dispose();
	}

	@Override
	public ILevel newLevel() {
		return new LightningLevel();
	}

	@Override
	public ILevel getLevel() {
		return level;
	}

	@Override
	public void setGame(Kabasuji k) {
		game = k;
	}

}
