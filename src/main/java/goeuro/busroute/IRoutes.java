package goeuro.busroute;

import java.util.List;

public interface IRoutes
{
	
	/**
	 * @param newRoute : Route
	 * @return false if this contains already the Route, true otherwise
	 * @throws NoRouteException if null object is being passed as parameter
	 */
	public boolean addRoute(IRoute newRoute) throws NoRouteException;
	
	/**
	 * @return the List<Route> held by the current object. If no Route objects have been added,
	 * it returns an empty list
	 */
	public List<IRoute> getRoutes();
}