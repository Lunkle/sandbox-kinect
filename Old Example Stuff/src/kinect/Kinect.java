package kinect;

import edu.ufl.digitalworlds.j4k.J4KSDK;

public class Kinect extends J4KSDK {

	public float[][] depthMap;
	public boolean depthMapLoaded = false;

	public Kinect() {
		depthMap = new float[424][512];
	}

	@Override
	public void onColorFrameEvent(byte[] arg0) {
		System.out.println("Color frame event");

	}

	@Override
	public void onDepthFrameEvent(short[] depth_frame, byte[] player_index, float[] XYZ, float[] UV) {
		System.out.println("Depth frame event");
		depthMapLoaded = true;
		int index = 0;
		for (int y = 0; y < getDepthHeight(); y++) {
			for (int x = 0; x < getDepthWidth(); x++) {
				float value = XYZ[index];
				depthMap[y][x] = value;
				index++;
			}
		}
	}

	@Override
	public void onSkeletonFrameEvent(boolean[] arg0, float[] arg1, float[] arg2, byte[] arg3) {
		System.out.println("Skeleton frame event");
	}

}
