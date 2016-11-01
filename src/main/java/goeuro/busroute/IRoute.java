package goeuro.busroute;

import java.util.Set;

public interface IRoute
{
	/**
	 * @return the route ID of the current Route object
	 */
	public int getRouteID();
	
	/**
	 * @return a Set of Integers of the stations of the current object
	 */
	public Set<Integer> getStations();
	
	public Route clone() throws CloneNotSupportedException;
}