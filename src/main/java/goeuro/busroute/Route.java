package goeuro.busroute;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fra_m
 * Representation of a Route.
 * A Route has an unique identifier ( = routeID : int) and a Set of stations ( = stations : Set<Integer)
 */
public class Route implements IRoute, Cloneable
{
	private int routeID;
	private Set<Integer> stations;
	
	/**
	 * Create a new Route
	 * @param routeID : int
	 * @param stations : Set<Integer>
	 */
	public Route(int routeID, Set<Integer> stations)
	{
		this.routeID = routeID;
		this.stations = stations;
	}
	
	@Override
	public int getRouteID()
	{
		return routeID;
	}
	
	@Override
	public Set<Integer> getStations()
	{
		Set<Integer> copiedStations = new HashSet<Integer>(stations);
		return copiedStations;
	}
	
	/* Overrided clone() method to provide a deep copy of the Route object to avoid 
	 * possible modifications by reference (escaping)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Route clone() throws CloneNotSupportedException
	{
		Route cloned = (Route) super.clone();
		return cloned;
	}
}