package twoAndaHalfCoverUp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import general.controller.anyBuilder.SaveBuiltLevelController;
import general.controller.anyBuilder.StockToBullpenController;
import general.controller.anyBuilder.TileMovingController;
import general.controller.anyLevel.FlipController;
import general.controller.anyLevel.MovePieceController;
import general.controller.anyLevel.RotateController;
import general.entity.DennlerStock;
import general.entity.Kabasuji;
import general.entity.LevelMemento;
import interfaces.IBuilderGUI;
import interfaces.ILevel;
import interfaces.IStock;
import puzzle.PuzzleBuilderGUI;
import release.ReleaseBuilderGUI;

import javax.swing.JComboBox;

public class CoverUpBuilderGUI extends JFrame implements IBuilderGUI{

	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	JToggleButton numberTileBtn = new JToggleButton();
	CoverUpLevel level;
	IStock stock;
	BoardPanel boardView;
	BullpenPanel bullpenView;
	Kabasuji game;

	/**
	 * Create the frame.
	 */
	public CoverUpBuilderGUI(CoverUpLevel l, IStock stock, Kabasuji k) {
		level = l;
		this.stock = stock;
		game = k;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 558);
		setTitle(level.getType() + " Builder");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane stockScrollPane = new JScrollPane();
		stockScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		stockScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		stockScrollPane.setBounds(949, 11, 175, 497);
		contentPane.add(stockScrollPane);
		
		JScrollPane bullpenScrollPane = new JScrollPane();
		bullpenScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bullpenScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		bullpenScrollPane.setBounds(10, 11, 804, 153);
		contentPane.add(bullpenScrollPane);
		
		
		
		JButton btnRotateCl = new JButton("");
		btnRotateCl.setBackground(new Color(245, 245, 245));
		btnRotateCl.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnRotateCl.setBounds(824, 57, 61, 44);
		contentPane.add(btnRotateCl);
		
		JButton btnRotateCCl = new JButton("");
		btnRotateCCl.setBackground(new Color(245, 245, 245));
		btnRotateCCl.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnRotateCCl.setBounds(824, 11, 61, 44);
		contentPane.add(btnRotateCCl);
		
		JButton btnFlipH = new JButton("");
		btnFlipH.setBackground(new Color(245, 245, 245));
		btnFlipH.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/images/flipHorizontal.png")));
		btnFlipH.setBounds(885, 11, 54, 44);
		contentPane.add(btnFlipH);
		
		JButton btnFlipV = new JButton("");
		btnFlipV.setBackground(new Color(245, 245, 245));
		btnFlipV.setIcon(new ImageIcon(PuzzleBuilderGUI.class.getResource("/images/flipVertical.png")));
		btnFlipV.setBounds(885, 57, 54, 44);
		contentPane.add(btnFlipV);
		
		JLabel lblNumberOfMoves = new JLabel("Tile/Piece Color:");
		lblNumberOfMoves.setForeground(new Color(105, 105, 105));
		lblNumberOfMoves.setFont(new Font("Constantia", Font.PLAIN, 10));
		lblNumberOfMoves.setBounds(824, 112, 115, 14);
		contentPane.add(lblNumberOfMoves);
		
		JToggleButton movePiecesBtn = new JToggleButton("Move Pieces");
		movePiecesBtn.setFont(new Font("Constantia", Font.PLAIN, 12));
		buttonGroup.add(movePiecesBtn);
		movePiecesBtn.setForeground(new Color(105, 105, 105));
		movePiecesBtn.setSelected(true);
		movePiecesBtn.setBackground(new Color(245, 245, 245));
		buttonGroup.add(movePiecesBtn);
		movePiecesBtn.setBounds(824, 260, 115, 33);
		contentPane.add(movePiecesBtn);
		
		JToggleButton addHintBtn = new JToggleButton("Add Hint");
		addHintBtn.setFont(new Font("Constantia", Font.PLAIN, 12));
		buttonGroup.add(addHintBtn);
		addHintBtn.setForeground(new Color(105, 105, 105));
		addHintBtn.setBackground(new Color(245, 245, 245));
		buttonGroup.add(addHintBtn);
		addHintBtn.setBounds(824, 304, 115, 33);
		contentPane.add(addHintBtn);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Constantia", Font.PLAIN, 12));
		btnSave.setBackground(new Color(245, 245, 245));
		btnSave.setForeground(new Color(105, 105, 105));
		btnSave.setBounds(824, 464, 115, 44);
		contentPane.add(btnSave);
		
		JToggleButton moveTileBtn = new JToggleButton("Move Tile");
		moveTileBtn.setFont(new Font("Constantia", Font.PLAIN, 12));
		buttonGroup.add(moveTileBtn);
		buttonGroup.add(moveTileBtn);
		moveTileBtn.setForeground(new Color(105, 105, 105));
		moveTileBtn.setBackground(new Color(245, 245, 245));
		moveTileBtn.setBounds(824, 348, 115, 33);
		contentPane.add(moveTileBtn);
		
		JLabel lblBoardSize = new JLabel("Board Size:");
		lblBoardSize.setForeground(SystemColor.controlDkShadow);
		lblBoardSize.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblBoardSize.setBounds(824, 175, 115, 14);
		contentPane.add(lblBoardSize);
		
		JSpinner boardSizeSpinner = new JSpinner();
		boardSizeSpinner.setToolTipText("Number of tiles on the board.");
		boardSizeSpinner.setModel(new SpinnerNumberModel(144, 1, 144, 1));
		boardSizeSpinner.setFont(new Font("Constantia", Font.PLAIN, 12));
		boardSizeSpinner.setForeground(new Color(105, 105, 105));
		boardSizeSpinner.setBounds(885, 200, 54, 33);
		contentPane.add(boardSizeSpinner);
		
		
		buttonGroup.add(numberTileBtn);
		numberTileBtn.setFont(new Font("Constantia", Font.PLAIN, 10));
		numberTileBtn.setText("Color Piece/Tile");
		numberTileBtn.setBackground(new Color(245, 245, 245));
		numberTileBtn.setForeground(new Color(105, 105, 105));
		numberTileBtn.setBounds(824, 392, 115, 33);
		contentPane.add(numberTileBtn);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(245, 245, 245));
		comboBox.setFont(new Font("Constantia", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"None", "Blue", "Green", "Yellow"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(824, 137, 115, 27);
		contentPane.add(comboBox);
		
		
		bullpenView = new BullpenPanel(level.getBullpen(), 20, 15);
		bullpenScrollPane.setViewportView(bullpenView);
		
		StockPanel stockView = new StockPanel(stock, 10, 25);
		stockScrollPane.setViewportView(stockView);
		
		boardView = new BoardPanel(level, 44, 260);
		boardView.setBackground(SystemColor.menu);
		boardView.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		boardView.setBounds(10, 173, 804, 336);
		contentPane.add(boardView);
		
		//Attach controllers.
		
		stockView.addMouseListener(new CoverUpStockToBullpenController(stockView,bullpenView,level));
		
		bullpenView.addMouseListener(new SlantedSelectPieceController(boardView, bullpenView, level, movePiecesBtn));
		
		boardView.addMouseMotionListener(new MovePieceController(level, boardView));
		boardView.addMouseListener(new MovePieceController(level, boardView));
		boardView.addMouseListener(new BuilderPlacePieceController(level, boardView, movePiecesBtn));
		boardView.addMouseListener(new TileMovingController(level, boardView, moveTileBtn));
		boardView.addMouseMotionListener(new TileMovingController(level, boardView, moveTileBtn));
		boardView.addMouseListener(new NumberPieceTileController(level, boardView, numberTileBtn, comboBox));
		
		btnRotateCl.addActionListener(new RotateController(level, boardView, true));
		btnRotateCCl.addActionListener(new RotateController(level, boardView, false));
		btnFlipV.addActionListener(new FlipController(level, boardView, true));
		btnFlipH.addActionListener(new FlipController(level, boardView, false));
		
		boardSizeSpinner.addChangeListener(new BoardSizeController(level, boardView, boardSizeSpinner));
		
		btnSave.addActionListener(new SaveBuiltLevelController(this, k));
	}

	@Override
	public String getLevelName() {
		return "Cover Up";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "cover the tiles with the pieces of the same color.";
	}

	@Override
	public void restore(LevelMemento m) {
		level.restore(m);
		new CoverUpBuilderGUI(level, stock, game).setVisible(true);
		this.dispose();
	}

	@Override
	public void newBuilder(ILevel l) {
		new CoverUpBuilderGUI((CoverUpLevel) l, stock, game).setVisible(true);
		this.dispose();
	}

	@Override
	public ILevel newLevel() {
		// TODO Auto-generated method stub
		return new CoverUpLevel();
	}

	@Override
	public ILevel getLevel() {
		// TODO Auto-generated method stub
		return level;
	}

	@Override
	public void setGame(Kabasuji k) {
		// TODO Auto-generated method stub
		game = k;
	}
}
