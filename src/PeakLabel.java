import java.io.Serializable;

public class PeakLabel implements Serializable {
	private int intensity;
	private String element;

	public PeakLabel(int intensity, String element) {
		this.intensity = intensity;
		this.element = element;
	}

	public int getIntensity() {
		return intensity;
	}

	public String getElement() {
		return element;
	}
}