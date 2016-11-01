package goeuro.busroute;

import java.util.List;
import java.util.Vector;

/**
 * @author fra_m
 * Representation of Routes.
 * A Routes holds a list of Route object
 */
public class Routes implements IRoutes
{
	private List<IRoute> routes;
	
	/**
	 * Default constructor. Sets up the Routes class
	 */
	public Routes()
	{
		routes = new Vector<IRoute>();
	}
	
	@Override
	public boolean addRoute(IRoute newRoute) throws NoRouteException
	{
		if(newRoute == null)
			throw new NoRouteException("Error. Route reference is null");
		
		if(routes.contains(newRoute))
			return false;
		
		routes.add(newRoute);
		return true;
	}
	
	@Override
	public List<IRoute> getRoutes()
	{
		// make a deep clone -> avoid escaping
		List<IRoute> copiedRoutes = new Vector<IRoute>();
		try
		{
			for(IRoute r : routes)
			{
				copiedRoutes.add(r.clone());
			}
		}
		catch(CloneNotSupportedException e)
		{
			// should never happen. If it happens, returns original List
			e.printStackTrace();
			return routes;
		}
		
		return copiedRoutes;
	}
}