package packages.main;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;
import packages.stage.MainMenu;
import packages.stage.Stage;

public class Main implements Runnable {

	// wid x height
	public static int width;
	public static int height;
	// title of frame
	public static final String TITLE = "LoL In Space";
	private static JFrame frame;
	private static InputHandler input;
	// reads settings from file
	private static Scanner inStream;
	
	// global game variables
	public static int volume;
		
	// privates
	private static Stage stage;
	private static boolean running;
	
	private Main(){
		// first the instream must grab the size of the window
		// try to open it
		try {
			File file = new File("settings.txt");
			inStream = new Scanner(file);

			// try reading in info
			try {
				// ignore the word: 'width'
				inStream.next();
				width = inStream.nextInt();
				// ignore the work: 'height'
				inStream.next();
				height = inStream.nextInt();
			} catch (Exception e){ e.printStackTrace(); stop(); }
			// close it
			inStream.close();
		} catch (Exception e) { e.printStackTrace(); stop(); }
		
		// init
		frame = new JFrame(TITLE);
		frame.setSize(width, height);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		// TODO
		// initialize panel and canvas stuff
		// make sure it is visible
		frame.setVisible(true);
		
		// adding input
		input = new InputHandler();
		frame.addKeyListener(input);
		frame.addMouseWheelListener(input);
		// TODO
		// panel.addMouseListener(input);
		// panel.addMouseMotionListener(input);
		frame.addFocusListener(input);
		
		// print variables to output
		// TODO
		// System.out.println("Width: " +panel.getWidth());
		// System.out.println("Height: " +panel.getHeight());
		
		// default values
		volume = -8;
		running = true;
		stage = new MainMenu();
	}
	
	public static void main(String Args[]){
		new Main().start();
	}

	private synchronized void start(){
		new Thread(this).start();
	}
	
	public synchronized static void stop(){
		System.exit(0);
	}

	// our main funtion
	public void run() {
		// TODO
		/*
		// for frame rate etc
		long lastTime = System.nanoTime(), lastTimer = System.currentTimeMillis(), now;
		double nsPerTick = 1000000000.0 / 60.0, delta = 0;
		int frames = 0, ticks = 0;

		// Main Game Loop
		while (running) {
			// for fps purposes
			now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			// more fps
			while (delta >= 1) {
				ticks++;
				delta -= 1;
				shouldRender = true;
			}

			// sleep
			try { Thread.sleep(SLEEP_TIME); }
			catch (InterruptedException e) { e.printStackTrace(); }

			// every time a frame happens
			if (shouldRender) {
				frames++;
				render();
				shouldRender = false;
			}

			// for fps again
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(frames + " frames , " + ticks + " ticks");
				frames = 0;
				ticks = 0;
			}
		}
		*/

		stop();
	}
	
	// TODO
	// fix drawing
	/*
	public static void draw(Graphics2D g){
		if (stage != null){
			stage.draw(g);
		}
	}
	*/
	
	// mutators
	public static void setStage(Stage s){ stage = s; }
	
	// getters
	public static Stage getStage(){ return stage; }
	// input states
	public static UserInputState getCurrentInputState(){ return input.currentState; }
	public static UserInputState getPreviousInputState(){ return input.prevState; }

	// TODO
	// this shouldn't be called 'render'
	/*
	private void render(){
		//update input
		update();
		//act
		stage.act();

		//draw
		panel.drawing();
	}
	*/
}














