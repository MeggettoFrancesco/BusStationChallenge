package goeuro.busroute;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class BusRoutesService
{
	private IRoutes routes;
	
	/**
	 * @param routes : IRoutes
	 */
	public BusRoutesService(IRoutes routes)
	{
		this.routes = routes;
	}
	
	/**
	 * @param dep_sid : Integer representing departure station
	 * @param arr_sid : Integer representing arrival station
	 * @return true if there exists a direct connection between dep_sid and arr_sid.
	 * 		   false otherwise
	 */
	public boolean routeExists(int dep_sid, int arr_sid)
	{	
		Set<Integer> set;
		for(IRoute r : routes.getRoutes())
		{
			set = r.getStations();
			if(set.contains(dep_sid) && set.contains(arr_sid))
				return true;
		}
		
		return false;
	}
}