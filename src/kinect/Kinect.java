package kinect;

import edu.ufl.digitalworlds.j4k.J4KSDK;

public class Kinect extends J4KSDK {

	@Override
	public void onColorFrameEvent(byte[] arg0) {
		System.out.println("Color frame event");
	}

	@Override
	public void onDepthFrameEvent(short[] arg0, byte[] arg1, float[] arg2, float[] arg3) {
		System.out.println("Depth frame event");
	}

	@Override
	public void onSkeletonFrameEvent(boolean[] arg0, float[] arg1, float[] arg2, byte[] arg3) {
		System.out.println("Skeleton frame event");
	}

}
