class Dog{
	
	private String name;
	private int cost;
	void display() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
public class Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog();
		d.setName("Sheru");
		System.out.println(d.getName());
		d.setCost(200000);
		System.out.println(d.getCost());
	}

}
