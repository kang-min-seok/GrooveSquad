package rhythmOrchestra_KJB;

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
	
	private ImageIcon pianoButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/pianoButtonEntered.png"));
	private ImageIcon pianoButtonBasicImage = new ImageIcon(Main.class.getResource("../images/pianoButtonBasic.png"));
	private ImageIcon violinButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/violinButtonEntered.png"));
	private ImageIcon violinButtonBasicImage = new ImageIcon(Main.class.getResource("../images/violinButtonBasic.png"));
	private ImageIcon guitarButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/guitarButtonEntered.png"));
	private ImageIcon guitarButtonBasicImage = new ImageIcon(Main.class.getResource("../images/guitarButtonBasic.png"));
	

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);

	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);

	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private JButton pianoButton = new JButton(pianoButtonBasicImage);
	private JButton violinButton = new JButton(violinButtonBasicImage);
	private JButton guitarButton = new JButton(guitarButtonBasicImage);
	
	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;

	Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected = 0;

	public static Game game;

	public RhythmOrchestra() {
		trackList.add(new Track("dittoTitleImage.png", "dittoSelectImage.jpg", "pianoGameImage.jpg",
				"ditto_piano_selected.mp3", "ditto_piano.mp3", "Ditto-NewJeans","piano"));
		trackList.add(new Track("dittoTitleImage.png", "dittoSelectImage.jpg", "violinGameImage.jpg",
				"ditto_violin_selected.mp3", "ditto_violin.mp3", "Ditto-NewJeans","violin"));
		trackList.add(new Track("dittoTitleImage.png", "dittoSelectImage.jpg", "guitarGameImage.jpg",
				"ditto_guitar_selected.mp3", "ditto_guitar.mp3", "Ditto-NewJeans","guitar"));
		
		trackList.add(new Track("endTheoryTitleImage.png", "endTheorySelectImage.jpg", "pianoGameImage.jpg",
				"endTheory_piano_selected.mp3", "endTheory_piano.mp3", "EndTheory-YOUNHA","piano"));
		trackList.add(new Track("endTheoryTitleImage.png", "endTheorySelectImage.jpg", "violinGameImage.jpg",
				"endTheory_violin_selected.mp3", "endTheory_violin.mp3", "EndTheory-YOUNHA","violin"));
		trackList.add(new Track("endTheoryTitleImage.png", "endTheorySelectImage.jpg", "guitarGameImage.jpg",
				"endTheory_guitar_selected.mp3", "endTheory_guitar.mp3", "EndTheory-YOUNHA","guitar"));
		
		trackList.add(new Track("bigbangTitleImage.png", "bigbangSelectImage.jpg", "pianoGameImage.jpg",
				"bigbang_piano_selected.mp3", "bigbang_piano.mp3", "Still Life-BIGBANG","piano"));
		trackList.add(new Track("bigbangTitleImage.png", "bigbangSelectImage.jpg", "violinGameImage.jpg",
				"bigbang_violin_selected.mp3", "bigbang_violin.mp3", "Still Life-BIGBANG","violin"));
		trackList.add(new Track("bigbangTitleImage.png", "bigbangSelectImage.jpg", "guitarGameImage.jpg",
				"bigbang_guitar_selected.mp3", "bigbang_guitar.mp3", "Still Life-BIGBANG","guitar"));

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

		startButton.setBounds(170, 400, 400, 100);
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

		quitButton.setBounds(170, 550, 400, 100);
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

		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
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
		rightButton.setBounds(1080, 310, 60, 60);
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
		easyButton.setBounds(375, 620, 250, 67);
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
		hardButton.setBounds(655, 620, 250, 67);
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

		
		pianoButton.setVisible(false);
		pianoButton.setBounds(335, 540, 250, 67);
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
		violinButton.setBounds(516, 540, 250, 67);
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
		guitarButton.setBounds(697, 540, 250, 67);
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

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if (isMainScreen) {
			g.drawImage(selectedImage, 415, 100, null);
			g.drawImage(titleImage, 415, 70, null);
		}
		if (isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.repaint();
	}

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

	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 3;
		else if (nowSelected == 1)
			nowSelected = trackList.size() - 2;
		else if (nowSelected == 2)
			nowSelected = trackList.size() - 1;
		else
			nowSelected-=3;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 3)
			nowSelected = 0;
		else if (nowSelected == trackList.size() - 2)
			nowSelected = 1;
		else if (nowSelected == trackList.size() - 1)
			nowSelected = 2;
		else
			nowSelected+=3;
		selectTrack(nowSelected);
	}
 

	public void selectPiano() {
		if (nowSelected == 1 || nowSelected == 2)
			nowSelected = 0;
		else if (nowSelected == 4 || nowSelected == 5)
			nowSelected = 3;
		else if (nowSelected == 7 || nowSelected == 8)
			nowSelected = 6;
		selectTrack(nowSelected);
	}
	
	public void selectViolin() {
		if (nowSelected == 0 || nowSelected == 2)
			nowSelected = 1;
		else if (nowSelected == 3 || nowSelected == 5)
			nowSelected = 4;
		else if (nowSelected == 6 || nowSelected == 8)
			nowSelected = 7;
		selectTrack(nowSelected);
	}
	
	public void selectGuitar() {
		if (nowSelected == 0 || nowSelected == 1)
			nowSelected = 2;
		else if (nowSelected == 3 || nowSelected == 4)
			nowSelected = 5;
		else if (nowSelected == 6 || nowSelected == 7)
			nowSelected = 8;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		pianoButton.setVisible(false);
		violinButton.setVisible(false);
		guitarButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,
				trackList.get(nowSelected).getGameMusic(),trackList.get(nowSelected).getInstrumentType());
		game.start();
		setFocusable(true);
	}

	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		pianoButton.setVisible(true);
		violinButton.setVisible(true);
		guitarButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}

	public void enterMain() {

		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		pianoButton.setVisible(true);
		violinButton.setVisible(true);
		guitarButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}
}
