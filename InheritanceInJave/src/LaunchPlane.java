class Plane
{
	public void takeOff()
	{
		System.out.println("Plane is taking off");
	}
	
	public void fly()
	{
		System.out.println("Plane is flying");
	}
	public void landing()
	{
		System.out.println("Plane is landing");
	}
}
class CargoPlane extends Plane
{
	public void fly()
	{
		System.out.println("Cargo plane flies at lower height");
	}
	public void carryGoods()
	{
		System.out.println("Cargo plane cariies goods");
	}
}
class PassagenrPlane extends Plane
{

	public void fly()
	{
		System.out.println("PassagenrPlane flies at lower height");
	}
	public void carryGoods()
	{
		System.out.println("PassagenrPlane cariies passangers");
	}
}
public class LaunchPlane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CargoPlane cp=new CargoPlane();
		PassagenrPlane pp=new PassagenrPlane();
		
		cp.fly();//overridden method
		cp.takeOff();//
		cp.carryGoods();
		cp.landing();
		
		pp.fly();
		pp.takeOff();
		pp.carryGoods();
		pp.landing();

	}

}
