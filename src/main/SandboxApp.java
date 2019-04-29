package main;

import edu.ufl.digitalworlds.j4k.J4KSDK;
import kinect.Kinect;
import processing.core.PApplet;

public class SandboxApp extends PApplet {

	Kinect kinect;

	public static void main(String[] args) {
		PApplet.main("main.SandboxApp");
	}

	public void settings() {
		size(512, 424);
	}

	public void setup() {
		kinect = new Kinect();
		kinect.start(J4KSDK.DEPTH | J4KSDK.XYZ);
		fill(120, 50, 240);
	}

	public void draw() {
		if (kinect.depthMapLoaded) {
			loadPixels();
			int index = 0;
			for (int y = 0; y < 424; y++) {
				for (int x = 0; x < 512; x++) {
					pixels[index] = color((int) map(kinect.depthMap[y][x], 0, 5, 0, 255));
//				System.out.println(kinect.dataMap[y][x]);
					index++;
				}
			}
			for (int x = 0; x < 2 * 512; x++) {
				pixels[x] = color(255, 0, 0);
			}
			updatePixels();
		}
	}

	public void mousePressed() {
		close();
	}

	private void close() {
		kinect.stop();
		exit();
	}

}
