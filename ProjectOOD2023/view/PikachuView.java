package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.crypto.BadPaddingException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.PikachuModel;

public class PikachuView extends JFrame {
	private PikachuModel pikachuModel;
	private JPanel mainPanel;
	private int width = 800;
	private int height = 650;
	private int row = 10;
	private int col = 10;
	private JButton btnNewGame;
	private String author = "Trương Nguyễn Hương Giang-21130338 and Phạm Đức Đại-";

	public PikachuView() {
		super();
	}

	private void init() {
		this.add(mainPanel = creatMainPanel());
		this.setTitle("Pokemon Game");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
	}

	private JPanel creatMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createGraphicsPanel(), BorderLayout.CENTER);
		panel.add(createControlPanel(), BorderLayout.EAST);
		panel.add(createStatusGame(), BorderLayout.PAGE_END);
		return panel;
	}

	private JPanel createStatusGame() {
		JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jPanel.setBackground(Color.lightGray);
		JLabel jLabel_author = new JLabel(author);
		jLabel_author.setForeground(Color.BLACK);
		jPanel.add(jLabel_author);
		return jPanel;
	}

	private JPanel createControlPanel() {

		// Tạo panel cho Score and Time

		JLabel jLabel_Score = new JLabel("0"); // score
		JProgressBar progressTime = new JProgressBar(0, 100); // start -- end
		progressTime.setValue(100);

		JPanel jPanel_Left = new JPanel(new GridLayout(0, 1, 5, 5));
		jPanel_Left.add(new Label("Score"));
		jPanel_Left.add(new Label("Time"));

		JPanel jPanelCenter = new JPanel(new GridLayout(0, 1, 5, 5));
		jPanelCenter.add(jLabel_Score);
		jPanelCenter.add(progressTime);

		JPanel jPanel_ScoreAndTime = new JPanel(new BorderLayout(10, 10));
		jPanel_ScoreAndTime.add(jPanel_Left, BorderLayout.WEST);
		jPanel_ScoreAndTime.add(jPanelCenter, BorderLayout.CENTER);

		// Tạo panel chứa panel_ScoreAnhTime và Button bắt đầu game

		JPanel jPanel_Control = new JPanel(new BorderLayout(10, 10));
		jPanel_Control.setBorder(new EmptyBorder(10, 3, 5, 3));
		jPanel_Control.add(jPanel_ScoreAndTime, BorderLayout.CENTER);
		jPanel_Control.add(btnNewGame = createButton("New Game"),
				BorderLayout.PAGE_END);
		
		// Khởi tạo Icon Game
		
		Icon icon = new ImageIcon(getClass().getResource("/icon/pokemon.png"));

		// Sử dụng Panel để chỉnh Layout BorderLyout đến Panel Control lên trên đỉnh (top)
		
		JPanel jPanel = new JPanel(new BorderLayout());
		jPanel.setBorder(new TitledBorder("status"));
		jPanel.add(jPanel_Control, BorderLayout.PAGE_START);
		jPanel.add(new JLabel(icon), BorderLayout.CENTER);
		return jPanel;
	}

		// Khởi tạo button Start Game

	private JButton createButton(String buttonName) {
		JButton btn_Start  = new JButton(buttonName);
		return btn_Start;
	}

	private JPanel createGraphicsPanel() {

		// Khởi Tạo ma trận Pikachu 
		
		MyGraphics graphicsPanel = new MyGraphics(this, row, col);
		
		JPanel jPanel = new JPanel(new GridLayout());
		jPanel.setBackground(Color.gray);
		jPanel.add(graphicsPanel);
		return jPanel;
	}
}
