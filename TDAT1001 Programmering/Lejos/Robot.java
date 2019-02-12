import lejos.hardware.motor.*;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.port.Port;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.robotics.SampleProvider;

class Robot {
	public Brick brick;
	public Port s1;
	public Port s2;
	public EV3ColorSensor colorSensor;
	public SampleProvider colorReader;
	public float[] colorSample;

	public SampleProvider touchSensor;
	public float[] touchSample;

	int xMotorDegree = 55;
	int yMotorDegree = 110;
	int zMotorDegree = 10;

	// Les fargeverdi
	public int readColorID(){
		this.colorReader.fetchSample(this.colorSample, 0);
		double colorID = this.colorSample[0];
		if (colorID == 3){
			return 1;
		}
		else if (colorID == 11){
			return 2;
		}
		else{
			return 0;
		}
	}

	public void run() {
		Motor.A.setSpeed(100);
		Motor.B.setSpeed(200);
		Motor.C.setSpeed(200);

		int tabell[][] = new int[7][6];
		int xPosition = 0;
		int yPosition = 0;
		boolean running = true;
		while (running) {
			if (xPosition > 7) {
				running = false;
			} else {
				Motor.A.rotate(xMotorDegree);
				tabell[xPosition][yPosition] = readColorID();
				xPosition++;
			}
		}

		connect_four ai = new connect_four(tabell);
		ai.bestMove();
		System.out.println("Legg i: " + ai.bestMove());
	}

	public static void main(String[] args) {
		Robot testBot = new Robot();
		testBot.run();
	}
}