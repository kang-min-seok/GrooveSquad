package rhythmOrchestra;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RhythmOrchestra extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));

	private ImageIcon loginButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/loginButtonEntered.png"));
	
	private ImageIcon logoutButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/logoutButtonBasic.png"));
	private ImageIcon logoutButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/logoutButtonEntered.png"));
	
	
	private ImageIcon loginButtonBasicImage = new ImageIcon(Main.class.getResource("../images/loginButtonBasic.png"));
	private ImageIcon loginpassButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/loginpassButtonEntered.png"));
	private ImageIcon loginpassButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/loginpassButtonBasic.png"));
	
	private Image userNameBackgroundImage = new ImageIcon(Main.class.getResource("../images/userNameBackground.png")).getImage();
	private ImageIcon signupButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/signupButtonEntered.png"));
	private ImageIcon signupButtonBasicImage = new ImageIcon(Main.class.getResource("../images/signupButtonBasic.png"));
	private ImageIcon signuppassButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/signuppassButtonEntered.png"));
	private ImageIcon signuppassButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/signuppassButtonBasic.png"));

	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));

	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));

	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	
	private ImageIcon rankEasyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rankEasyButtonEntered.png"));
	private ImageIcon rankEasyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankEasyButtonBasic.png"));
	private ImageIcon rankHardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rankHardButtonEntered.png"));
	private ImageIcon rankHardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankHardButtonBasic.png"));
	
	private ImageIcon rankPianoButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rankPianoButtonEntered.png"));
	private ImageIcon rankPianoButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankPianoButtonBasic.png"));
	private ImageIcon rankViolinButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rankViolinButtonEntered.png"));
	private ImageIcon rankViolinButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankViolinButtonBasic.png"));
	private ImageIcon rankGuitarButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rankGuitarButtonEntered.png"));
	private ImageIcon rankGuitarButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankGuitarButtonBasic.png"));

	private ImageIcon rankingButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankingButtonBasic.png"));
	private ImageIcon rankingButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rankingButtonEntered.png"));

	private ImageIcon pianoButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/pianoButtonEntered.png"));
	private ImageIcon pianoButtonBasicImage = new ImageIcon(Main.class.getResource("../images/pianoButtonBasic.png"));
	private ImageIcon violinButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/violinButtonEntered.png"));
	private ImageIcon violinButtonBasicImage = new ImageIcon(Main.class.getResource("../images/violinButtonBasic.png"));
	private ImageIcon guitarButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/guitarButtonEntered.png"));
	private ImageIcon guitarButtonBasicImage = new ImageIcon(Main.class.getResource("../images/guitarButtonBasic.png"));

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);

	private JButton loginButton = new JButton(loginButtonBasicImage);
	private JButton loginpassButton = new JButton(loginpassButtonBasicImage);
	private JButton logoutButton = new JButton(logoutButtonBasicImage);
	private JButton signupButton = new JButton(signupButtonBasicImage);
	private JButton signuppassButton = new JButton(signuppassButtonBasicImage);

	private JButton backloginButton = new JButton(backButtonBasicImage);
	private JButton backsignupButton = new JButton(backButtonBasicImage);
	private JButton backRankingButton = new JButton(backButtonBasicImage);
	
	private JButton rankingButton = new JButton(rankingButtonBasicImage);
	private JButton rankEasyButton = new JButton(rankEasyButtonBasicImage);
	private JButton rankHardButton = new JButton(rankHardButtonBasicImage);

	private JButton rankPianoButton = new JButton(rankPianoButtonBasicImage);
	private JButton rankViolinButton = new JButton(rankViolinButtonBasicImage);
	private JButton rankGuitarButton = new JButton(rankGuitarButtonBasicImage);
	

	private JButton backStartButton = new JButton(backButtonBasicImage);

	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);

	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private JButton pianoButton = new JButton(pianoButtonBasicImage);
	private JButton violinButton = new JButton(violinButtonBasicImage);
	private JButton guitarButton = new JButton(guitarButtonBasicImage);

	JTextField tfid = new JTextField();
	JPasswordField tfpw = new JPasswordField();
	JTextField newid = new JTextField();
	JPasswordField newpw = new JPasswordField();
	JPasswordField confirmpw = new JPasswordField();

	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	private boolean isRankScreen = false;

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music backIntroMusic;
	private boolean backChk = false;

	private String userName;
	private boolean loginChk=false;
	Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected = 0;

	public static Game game;
	public static RankingPage rankingPage;

	public RhythmOrchestra() {
		trackList.add(new Track("dittoTitleImage.png", "dittoSelectImage.jpg", "pianoGameImage.jpg",
				"ditto_piano_selected.mp3", "ditto_piano.mp3", "Ditto-NewJeans", "piano"));
		trackList.add(new Track("dittoTitleImage.png", "dittoSelectImage.jpg", "violinGameImage.jpg",
				"ditto_violin_selected.mp3", "ditto_violin.mp3", "Ditto-NewJeans", "violin"));
		trackList.add(new Track("dittoTitleImage.png", "dittoSelectImage.jpg", "guitarGameImage.jpg",
				"ditto_guitar_selected.mp3", "ditto_guitar.mp3", "Ditto-NewJeans", "guitar"));

		trackList.add(new Track("endTheoryTitleImage.png", "endTheorySelectImage.jpg", "pianoGameImage.jpg",
				"endTheory_piano_selected.mp3", "endTheory_piano.mp3", "EndTheory-YOUNHA", "piano"));
		trackList.add(new Track("endTheoryTitleImage.png", "endTheorySelectImage.jpg", "violinGameImage.jpg",
				"endTheory_violin_selected.mp3", "endTheory_violin.mp3", "EndTheory-YOUNHA", "violin"));
		trackList.add(new Track("endTheoryTitleImage.png", "endTheorySelectImage.jpg", "guitarGameImage.jpg",
				"endTheory_guitar_selected.mp3", "endTheory_guitar.mp3", "EndTheory-YOUNHA", "guitar"));

		trackList.add(new Track("bigbangTitleImage.png", "bigbangSelectImage.jpg", "pianoGameImage.jpg",
				"bigbang_piano_selected.mp3", "bigbang_piano.mp3", "Still Life-BIGBANG", "piano"));
		trackList.add(new Track("bigbangTitleImage.png", "bigbangSelectImage.jpg", "violinGameImage.jpg",
				"bigbang_violin_selected.mp3", "bigbang_violin.mp3", "Still Life-BIGBANG", "violin"));
		trackList.add(new Track("bigbangTitleImage.png", "bigbangSelectImage.jpg", "guitarGameImage.jpg",
				"bigbang_guitar_selected.mp3", "bigbang_guitar.mp3", "Still Life-BIGBANG", "guitar"));

		setUndecorated(true);
		setTitle("RhythmOrchestra");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		addKeyListener(new KeyListener());

		introMusic.start();

		exitButton.setBounds(1160, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(300);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		startButton.setBounds(680, 400, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				enterMain();

			}
		});
		add(startButton);

		quitButton.setBounds(680, 550, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(300);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		// --------------------------------------------------------------------------------------------------
		tfid.setBounds(290, 230, 200, 50);
		tfid.setVisible(false);
		add(tfid);
		tfid.setColumns(20);

		tfpw.setBounds(290, 340, 200, 50);
		tfpw.setVisible(false);
		add(tfpw);

		newid.setBounds(290, 230, 200, 50);
		newid.setVisible(false);
		add(newid);

		newpw.setBounds(290, 340, 200, 50);
		newpw.setVisible(false);
		add(newpw);

		confirmpw.setBounds(290, 450, 200, 50);
		confirmpw.setVisible(false);
		add(confirmpw);

		loginButton.setBounds(430, 430, 200, 200);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setIcon(loginButtonEnteredImage);
				loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setIcon(loginButtonBasicImage);
				loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				enterLogin();
			}
		});
		add(loginButton);
		
		
		
		
		logoutButton.setBounds(273, 62, 55, 55);
		logoutButton.setVisible(false);
		logoutButton.setBorderPainted(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setFocusPainted(false);
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutButton.setIcon(logoutButtonEnteredImage);
				logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				logoutButton.setIcon(logoutButtonBasicImage);
				logoutButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				logoutEvent();
			}
		});
		add(logoutButton);
		
		
		
		
		

		loginpassButton.setVisible(false);
		loginpassButton.setBounds(430, 440, 80, 80);
		loginpassButton.setBorderPainted(false);
		loginpassButton.setContentAreaFilled(false);
		loginpassButton.setFocusPainted(false);
		loginpassButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginpassButton.setIcon(loginpassButtonEnteredImage);
				loginpassButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginpassButton.setIcon(loginpassButtonBasicImage);
				loginpassButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				loginEvent();
			}
		});
		add(loginpassButton);

		signupButton.setVisible(false);
		signupButton.setBounds(210, 440, 160, 80);
		signupButton.setBorderPainted(false);
		signupButton.setContentAreaFilled(false);
		signupButton.setFocusPainted(false);
		signupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupButton.setIcon(signupButtonEnteredImage);
				signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signupButton.setIcon(signupButtonBasicImage);
				signupButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				enterJoin();
			}
		});
		add(signupButton);

		signuppassButton.setVisible(false);
		signuppassButton.setBounds(480, 160, 80, 30);
		signuppassButton.setBorderPainted(false);
		signuppassButton.setContentAreaFilled(false);
		signuppassButton.setFocusPainted(false);
		signuppassButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signuppassButton.setIcon(signuppassButtonEnteredImage);
				signuppassButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signuppassButton.setIcon(signuppassButtonBasicImage);
				signuppassButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				joinEvent();
			}
		});
		add(signuppassButton);

		backloginButton.setVisible(false);
		backloginButton.setBounds(20, 50, 60, 60);
		backloginButton.setBorderPainted(false);
		backloginButton.setContentAreaFilled(false);
		backloginButton.setFocusPainted(false);
		backloginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backloginButton.setIcon(backButtonEnteredImage);
				backloginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backloginButton.setIcon(backButtonBasicImage);
				backloginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				StartMenu();
			}
		});
		add(backloginButton);

		backsignupButton.setVisible(false);
		backsignupButton.setBounds(20, 50, 60, 60);
		backsignupButton.setBorderPainted(false);
		backsignupButton.setContentAreaFilled(false);
		backsignupButton.setFocusPainted(false);
		backsignupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backsignupButton.setIcon(backButtonEnteredImage);
				backsignupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backsignupButton.setIcon(backButtonBasicImage);
				backsignupButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				enterLogin();
			}
		});
		add(backsignupButton);
		
		
		backStartButton.setVisible(false);
		backStartButton.setBounds(20, 50, 60, 60);
		backStartButton.setBorderPainted(false);
		backStartButton.setContentAreaFilled(false);
		backStartButton.setFocusPainted(false);
		backStartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backStartButton.setIcon(backButtonEnteredImage);
				backStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backStartButton.setIcon(backButtonBasicImage);
				backStartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				backStart();
			}
		});
		add(backStartButton);
		
		
		backRankingButton.setVisible(false);
		backRankingButton.setBounds(20, 50, 60, 60);
		backRankingButton.setBorderPainted(false);
		backRankingButton.setContentAreaFilled(false);
		backRankingButton.setFocusPainted(false);
		backRankingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backRankingButton.setIcon(backButtonEnteredImage);
				backRankingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backRankingButton.setIcon(backButtonBasicImage);
				backRankingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				backRankToMain();
			}
		});
		add(backRankingButton);
		// --------------------------------------------------------------------------

		leftButton.setVisible(false);
		leftButton.setBounds(300, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectLeft();
			}
		});
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(840, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectRight();
			}
		});
		add(rightButton);

		easyButton.setVisible(false);
		easyButton.setBounds(335, 620, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);

		hardButton.setVisible(false);
		hardButton.setBounds(615, 620, 250, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);

		
		rankingButton.setVisible(false);
		rankingButton.setBounds(840, 460, 180, 70);
		rankingButton.setBorderPainted(false);
		rankingButton.setContentAreaFilled(false);
		rankingButton.setFocusPainted(false);
		rankingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankingButton.setIcon(rankingButtonEnteredImage);
				rankingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rankingButton.setIcon(rankingButtonBasicImage);
				rankingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				enterRanking(nowSelected);
			}
		});
		add(rankingButton);
		
		
		rankEasyButton.setVisible(false);
		rankEasyButton.setBounds(885, 120, 190, 65);
		rankEasyButton.setBorderPainted(false);
		rankEasyButton.setContentAreaFilled(false);
		rankEasyButton.setFocusPainted(false);
		rankEasyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankEasyButton.setIcon(rankEasyButtonEnteredImage);
				rankEasyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rankEasyButton.setIcon(rankEasyButtonBasicImage);
				rankEasyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//gameStart(nowSelected, "Easy");
			}
		});
		add(rankEasyButton);

		rankHardButton.setVisible(false);
		rankHardButton.setBounds(885, 200, 190, 65);
		rankHardButton.setBorderPainted(false);
		rankHardButton.setContentAreaFilled(false);
		rankHardButton.setFocusPainted(false);
		rankHardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankHardButton.setIcon(rankHardButtonEnteredImage);
				rankHardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rankHardButton.setIcon(rankHardButtonBasicImage);
				rankHardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//gameStart(nowSelected, "Hard");
			}
		});
		add(rankHardButton);
		
		
		
		
		

		rankPianoButton.setVisible(false);
		rankPianoButton.setBounds(885, 300, 190, 65);
		rankPianoButton.setBorderPainted(false);
		rankPianoButton.setContentAreaFilled(false);
		rankPianoButton.setFocusPainted(false);
		rankPianoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankPianoButton.setIcon(rankPianoButtonEnteredImage);
				rankPianoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rankPianoButton.setIcon(rankPianoButtonBasicImage);
				rankPianoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//selectPiano();
			}
		});
		add(rankPianoButton);

		rankViolinButton.setVisible(false);
		rankViolinButton.setBounds(885, 380, 190, 65);
		rankViolinButton.setBorderPainted(false);
		rankViolinButton.setContentAreaFilled(false);
		rankViolinButton.setFocusPainted(false);
		rankViolinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankViolinButton.setIcon(rankViolinButtonEnteredImage);
				rankViolinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rankViolinButton.setIcon(rankViolinButtonBasicImage);
				rankViolinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//selectViolin();
			}
		});
		add(rankViolinButton);

		rankGuitarButton.setVisible(false);
		rankGuitarButton.setBounds(885, 460, 190, 65);
		rankGuitarButton.setBorderPainted(false);
		rankGuitarButton.setContentAreaFilled(false);
		rankGuitarButton.setFocusPainted(false);
		rankGuitarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankGuitarButton.setIcon(rankGuitarButtonEnteredImage);
				rankGuitarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rankGuitarButton.setIcon(rankGuitarButtonBasicImage);
				rankGuitarButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//selectGuitar();
			}
		});
		add(rankGuitarButton);
		
		
		
		pianoButton.setVisible(false);
		pianoButton.setBounds(295, 540, 250, 67);
		pianoButton.setBorderPainted(false);
		pianoButton.setContentAreaFilled(false);
		pianoButton.setFocusPainted(false);
		pianoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pianoButton.setIcon(pianoButtonEnteredImage);
				pianoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pianoButton.setIcon(pianoButtonBasicImage);
				pianoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectPiano();
			}
		});
		add(pianoButton);

		violinButton.setVisible(false);
		violinButton.setBounds(476, 540, 250, 67);
		violinButton.setBorderPainted(false);
		violinButton.setContentAreaFilled(false);
		violinButton.setFocusPainted(false);
		violinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				violinButton.setIcon(violinButtonEnteredImage);
				violinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				violinButton.setIcon(violinButtonBasicImage);
				violinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectViolin();
			}
		});
		add(violinButton);

		guitarButton.setVisible(false);
		guitarButton.setBounds(657, 540, 250, 67);
		guitarButton.setBorderPainted(false);
		guitarButton.setContentAreaFilled(false);
		guitarButton.setFocusPainted(false);
		guitarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				guitarButton.setIcon(guitarButtonEnteredImage);
				guitarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				guitarButton.setIcon(guitarButtonBasicImage);
				guitarButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectGuitar();
			}
		});
		add(guitarButton);

		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				backMain();
			}
		});
		add(backButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	//화면 그리는 함수
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if (isMainScreen) {
			if(loginChk) {
				g.drawImage(userNameBackgroundImage, 20, 40, null);
				g.setFont(new Font("Arial", Font.BOLD, 30));
				g.setColor(Color.WHITE);
				g.drawString(userName, 30, 95);
			}
			g.drawImage(selectedImage, 375, 100, null);
			g.drawImage(titleImage, 375, 70, null);
		}
		if (isGameScreen) {
			game.screenDraw(g);
		}
		if (isRankScreen) {
			rankingPage.screenDraw(g);
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}

	//곡선택 함수
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	//왼쪽으로 곡 넘기기
	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 3;
		else if (nowSelected == 1)
			nowSelected = trackList.size() - 2;
		else if (nowSelected == 2)
			nowSelected = trackList.size() - 1;
		else
			nowSelected -= 3;
		selectTrack(nowSelected);
	}

	//오른쪽으로 곡 넘기기
	public void selectRight() {
		if (nowSelected == trackList.size() - 3)
			nowSelected = 0;
		else if (nowSelected == trackList.size() - 2)
			nowSelected = 1;
		else if (nowSelected == trackList.size() - 1)
			nowSelected = 2;
		else
			nowSelected += 3;
		selectTrack(nowSelected);
	}

	//피아노 버튼 선택 함수
	public void selectPiano() {
		background = new ImageIcon(Main.class.getResource("../images/pianoGameImage.jpg")).getImage();
		if (nowSelected == 1 || nowSelected == 2)
			nowSelected = 0;
		else if (nowSelected == 4 || nowSelected == 5)
			nowSelected = 3;
		else if (nowSelected == 7 || nowSelected == 8)
			nowSelected = 6;
		selectTrack(nowSelected);
	}

	//바이올린 선택 버튼 함수
	public void selectViolin() {
		background = new ImageIcon(Main.class.getResource("../images/violinGameImage.jpg")).getImage();
		if (nowSelected == 0 || nowSelected == 2)
			nowSelected = 1;
		else if (nowSelected == 3 || nowSelected == 5)
			nowSelected = 4;
		else if (nowSelected == 6 || nowSelected == 8)
			nowSelected = 7;
		selectTrack(nowSelected);
	}

	//기타 선택 버튼 함수
	public void selectGuitar() {
		background = new ImageIcon(Main.class.getResource("../images/guitarGameImage.jpg")).getImage();
		if (nowSelected == 0 || nowSelected == 1)
			nowSelected = 2;
		else if (nowSelected == 3 || nowSelected == 4)
			nowSelected = 5;
		else if (nowSelected == 6 || nowSelected == 7)
			nowSelected = 8;
		selectTrack(nowSelected);
	}

	//게임시작 함수
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		logoutButton.setVisible(false);
		backStartButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		rankingButton.setVisible(false);
		pianoButton.setVisible(false);
		violinButton.setVisible(false);
		guitarButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		if(loginChk) {
			game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,
					trackList.get(nowSelected).getGameMusic(), trackList.get(nowSelected).getInstrumentType(),userName);
		}else {
			game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,
					trackList.get(nowSelected).getGameMusic(), trackList.get(nowSelected).getInstrumentType());
		}
		
		game.start();
		setFocusable(true);
	}

	//게임하다가 취소하고 곡선택화면으로 돌아가는 함수
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		rankingButton.setVisible(true);
		pianoButton.setVisible(true);
		violinButton.setVisible(true);
		guitarButton.setVisible(true);
		if(!loginChk) {
			backStartButton.setVisible(true);
		}else if(loginChk) {
			logoutButton.setVisible(true);
		}
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}

	//비로그인으로 게임시작하는 함수
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		loginButton.setVisible(false);
		tfid.setVisible(false);
		tfpw.setVisible(false);
		loginpassButton.setVisible(false);
		signupButton.setVisible(false);
		backloginButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		isMainScreen = true;
		backStartButton.setVisible(true);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		rankingButton.setVisible(true);
		pianoButton.setVisible(true);
		violinButton.setVisible(true);
		guitarButton.setVisible(true);
		introMusic.close();
		if(backChk) {
			backIntroMusic.close();
		}
		selectTrack(0);
	}

	//로그인창 띄우는 함수
	public void enterLogin() {

		startButton.setVisible(false);
		quitButton.setVisible(false);
		loginButton.setVisible(false);
		newid.setVisible(false);
		newpw.setVisible(false);
		confirmpw.setVisible(false);
		signuppassButton.setVisible(false);
		backsignupButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/introBackground(login).jpg")).getImage();
		tfid.setVisible(true);
		tfpw.setVisible(true);
		loginpassButton.setVisible(true);
		signupButton.setVisible(true);
		backloginButton.setVisible(true);

	}

	//로그인함수
	public void loginEvent() {
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(tfid.getText(), new String(tfpw.getPassword()));

		if (result == 1) {
			loginChk = true;
			startButton.setVisible(false);
			quitButton.setVisible(false);
			loginButton.setVisible(false);
			tfid.setVisible(false);
			tfpw.setVisible(false);
			loginpassButton.setVisible(false);
			signupButton.setVisible(false);
			backloginButton.setVisible(false);
			background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
					.getImage();
			isMainScreen = true;
			leftButton.setVisible(true);
			rightButton.setVisible(true);
			easyButton.setVisible(true);
			hardButton.setVisible(true);
			rankingButton.setVisible(true);
			pianoButton.setVisible(true);
			violinButton.setVisible(true);
			guitarButton.setVisible(true);
			introMusic.close();
			if(backChk) {
				backIntroMusic.close();
			}
			selectTrack(0);
			logoutButton.setVisible(true);
			userName = tfid.getText();
			
		} else if (result == 0) {
			System.out.println("wrong pw");
		} else if (result == -1) {
			System.out.println("wrong id");
		} else if (result == -2) {
			System.out.println("database error");
		}
	}
	
	//로그아웃 함수
	public void logoutEvent() {
		loginChk = false;
		backChk = true;
		userName = null;
		isMainScreen = false;
		logoutButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		rankingButton.setVisible(false);
		pianoButton.setVisible(false);
		violinButton.setVisible(false);
		guitarButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();
		startButton.setVisible(true);
		quitButton.setVisible(true);
		loginButton.setVisible(true);
		selectedMusic.close();
		backIntroMusic = new Music("introMusic.mp3", true);
		backIntroMusic.start();
	}

	//회원가입 창 띄우는 함수
	public void enterJoin() {
		tfid.setVisible(false);
		tfpw.setVisible(false);
		loginpassButton.setVisible(false);
		signupButton.setVisible(false);
		backloginButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/introBackground(signup).jpg")).getImage();
		newid.setVisible(true);
		newpw.setVisible(true);
		confirmpw.setVisible(true);
		signuppassButton.setVisible(true);
		backsignupButton.setVisible(true);
	}

	//회원가입 함수
	public void joinEvent() {
		User user = new User();
		user.setUserID(newid.getText());
		user.setUserPW(new String(newpw.getPassword()));
		if (newid.getText() == null || new String(newpw.getPassword()) == null || new String(confirmpw.getPassword()) == null ) {
			System.out.println("not enter");
			} else {
				UserDAO userDAO = new UserDAO();
				int result = userDAO.join(user);
				if (result == -1) {
					System.out.println("already id");
				} else {
					enterLogin();
				}
			}
	}
	public void StartMenu() {
		tfid.setVisible(false);
		tfpw.setVisible(false);
		loginpassButton.setVisible(false);
		signupButton.setVisible(false);
		backloginButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();
		startButton.setVisible(true);
		quitButton.setVisible(true);
		loginButton.setVisible(true);
	}
	
	//비로그인시 메인창에서 로그인창으로 넘어가는 버튼 함수
	public void backStart() {
		isMainScreen = false;
		backChk = true;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		rankingButton.setVisible(false);
		pianoButton.setVisible(false);
		violinButton.setVisible(false);
		guitarButton.setVisible(false);
		backStartButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();
		startButton.setVisible(true);
		quitButton.setVisible(true);
		loginButton.setVisible(true);
		selectedMusic.close();
		backIntroMusic = new Music("introMusic.mp3", true);
		backIntroMusic.start();
	}
	
	
	public void enterRanking(int nowSelected) {
		isMainScreen = false;
		leftButton.setVisible(false);
		logoutButton.setVisible(false);
		backStartButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		rankingButton.setVisible(false);
		pianoButton.setVisible(false);
		violinButton.setVisible(false);
		guitarButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backRankingButton.setVisible(true);
		rankEasyButton.setVisible(true);
		rankHardButton.setVisible(true);
		rankPianoButton.setVisible(true);
		rankViolinButton.setVisible(true);
		rankGuitarButton.setVisible(true);
		isRankScreen = true;
		rankingPage = new RankingPage(trackList.get(nowSelected).getTitleName(), trackList.get(nowSelected).getInstrumentType(),background);
		
		rankingPage.start();
		setFocusable(true);
	}
	public void backRankToMain() {
		isMainScreen = true;
		rankEasyButton.setVisible(false);
		rankHardButton.setVisible(false);
		rankPianoButton.setVisible(false);
		rankViolinButton.setVisible(false);
		rankGuitarButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		rankingButton.setVisible(true);
		pianoButton.setVisible(true);
		violinButton.setVisible(true);
		guitarButton.setVisible(true);
		if(!loginChk) {
			backStartButton.setVisible(true);
		}else if(loginChk) {
			logoutButton.setVisible(true);
		}
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backRankingButton.setVisible(false);
		selectTrack(nowSelected);
		isRankScreen = false;
		rankingPage.close();
	}

}