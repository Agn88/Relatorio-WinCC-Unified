package br.ind.rosseti.GeradorRelatorio.model;

public class IsegSegment {
	private long fk_StorageId;
	private String leftBound;
	private String rightBound;
	private String estimatedEndTime;
	private String location;
	private String name;
	private String status;
	
	public IsegSegment(long fk_StorageId, String leftBound, String rightBound, String estimatedEndTime, String location,
			String name, String status) {
		super();
		this.fk_StorageId = fk_StorageId;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
		this.estimatedEndTime = estimatedEndTime;
		this.location = location;
		this.name = name;
		this.status = status;
	}
	
	public IsegSegment() {
		super();
	}

	public long getFk_StorageId() {
		return fk_StorageId;
	}

	public void setFk_StorageId(long fk_StorageId) {
		this.fk_StorageId = fk_StorageId;
	}

	public String getLeftBound() {
		return leftBound;
	}

	public void setLeftBound(String leftBound) {
		this.leftBound = leftBound;
	}

	public String getRightBound() {
		return rightBound;
	}

	public void setRightBound(String rightBound) {
		this.rightBound = rightBound;
	}

	public String getEstimatedEndTime() {
		return estimatedEndTime;
	}

	public void setEstimatedEndTime(String estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "IsegSegment [fk_StorageId=" + fk_StorageId + ", leftBound=" + leftBound + ", rightBound=" + rightBound
				+ ", estimatedEndTime=" + estimatedEndTime + ", location=" + location + ", name=" + name + ", status="
				+ status + "]";
	}
	
	
	
	
}
