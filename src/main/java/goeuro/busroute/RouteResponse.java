package goeuro.busroute;

public class RouteResponse
{
	private int dep_sid;
	private int arr_sid;
	private boolean direct_bus_route;
	
	public RouteResponse(int dep_sid, int arr_sid, boolean direct_bus_route)
	{
		this.dep_sid = dep_sid;
		this.arr_sid = arr_sid;
		this.direct_bus_route = direct_bus_route;
	}
	
	public int getDepSid()
	{
		return dep_sid;
	}
	
	public int getArrSid()
	{
		return arr_sid;
	}
	
	public boolean getDirectRoute()
	{
		return direct_bus_route;
	}
}
