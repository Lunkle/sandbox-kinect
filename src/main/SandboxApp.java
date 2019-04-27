package main;

import edu.ufl.digitalworlds.j4k.J4KSDK;
import kinect.Kinect;

public class SandboxApp {

	public static void main(String[] args) {
		System.out.println("hello world");
		Kinect kinect = new Kinect();
		kinect.start(J4KSDK.COLOR | J4KSDK.DEPTH | J4KSDK.SKELETON);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

}
