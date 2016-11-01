package goeuro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import goeuro.busroute.BusRoutesService;
import goeuro.busroute.IRoutes;
import goeuro.busroute.NoRouteException;

@SpringBootApplication
public class BusRouteConfiguration
{
	private static IRoutes routes;
	
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Please, supply required parameters");
			System.out.println("Example: java -jar BusStationChallenge.jar BUS_ROUTE_FILE");
			System.exit(-1);
		}
		
		routes = parseFile(args[0]);
		
		SpringApplication.run(BusRouteConfiguration.class, args);
	}
	
	@Bean
	public BusRoutesService busRoutesService()
	{
		return new BusRoutesService(routes);
	}
	
	/**
	 * Parses the file given as parameter
	 * @param fileName : String
	 * @return an IRoutes object with the representation of the data. Null if file was not of the
	 * 			required format (NoRouteException)
	 */
	private static IRoutes parseFile(String fileName)
	{
		BusStationLoader loader = new BusStationLoader();
		try
		{
			return loader.loadRoutes(fileName);
		}
		catch (NoRouteException e)
		{
			System.out.println("Error on parsing the file. Please, correct the file.");
			System.exit(-1);
		}
		
		return null;
	}
}