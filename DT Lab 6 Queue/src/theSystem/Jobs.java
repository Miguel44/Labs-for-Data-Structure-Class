package theSystem;

public class Jobs {
	int arrivalTime;
	int serviceTime;
	int departureTime;
	
	public Jobs(int arrivalTime, int serviceTime,int departureTime){
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.departureTime =departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}
}
