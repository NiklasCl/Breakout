package projekt;



import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class AnimatedBall extends GraphicsProgram {

	private static final double SIZE = 10;
	public static final double CANVASWIDTH = 400;
	public static final double CANVASHEIGHT = 200;
	private static final double SPEED = 2;
	private static final int PAUSE_TIME = 20;

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private double direction;
	private double originalDirection;

	public void run() {
		GRect canvas = new GRect(0, 0, CANVASWIDTH, CANVASHEIGHT);
		add(canvas);

		originalDirection = rgen.nextDouble(0, 360);
		direction = originalDirection;

		double y = 50;
		double x = 300;

		GOval ball = new GOval(x, y, SIZE, SIZE);
		ball.setFilled(true);
		add(ball);

		GPoint check = ball.getLocation();

		while (check.getY() <= CANVASHEIGHT - SIZE) {
			check = ball.getLocation();

			if (check.getX() >= CANVASWIDTH - SIZE) {
				direction = 180 - direction;
			}

			if (check.getX() <= 0) {
				direction = 180 + direction;
			}

			if (check.getY() <= 0) {
				if (direction <= 90) {
					direction = 90 - direction;
				}
			}

			ball.movePolar(SPEED, direction);
			pause(PAUSE_TIME);
		}

	}

}
