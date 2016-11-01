package goeuro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import goeuro.busroute.IRoutes;
import goeuro.busroute.NoRouteException;
import goeuro.busroute.Route;
import goeuro.busroute.Routes;

public class BusStationLoader
{	
	public IRoutes loadRoutes(String fileName) throws NoRouteException
	{
		IRoutes r = new Routes();
		try
		{
			BufferedReader fileInput = new BufferedReader(new FileReader(fileName));
			StringTokenizer st;
			
			String line = fileInput.readLine();
			int nLines = Integer.parseInt(line);
			
			int routeId;
			Set<Integer> stations;
			for(int i = 0; i < nLines; i++)
			{
				line = fileInput.readLine();
				st = new StringTokenizer(line);
				
				routeId = Integer.parseInt(st.nextToken());
				stations = new HashSet<Integer>();
				while(st.hasMoreTokens())
				{
					stations.add(Integer.parseInt(st.nextToken()));
				}
				
				r.addRoute(new Route(routeId, stations));
			}
			
			fileInput.close();
		}
		catch(Exception e)
		{
			throw new NoRouteException("Error on parsing file."
					+ " Please, check that your file meets the requiremenrs");
		}
		
		return r;
	}
}