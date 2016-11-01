package goeuro;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import goeuro.busroute.BusRoutesService;
import goeuro.busroute.IRoutes;
import goeuro.busroute.NoRouteException;
import goeuro.busroute.Route;
import goeuro.busroute.Routes;

public class BusRouteControllerTests
{
	BusRoutesService busRoutesService;
	
	@SuppressWarnings("serial")
	@Before
	public void setUp() throws NoRouteException
	{
		IRoutes testR = new Routes();
		
		testR.addRoute(new Route(1, new HashSet<Integer>() {
			{ add(100); add(101); add(200); add(250); }
			}));
		testR.addRoute(new Route(2, new HashSet<Integer>() {
			{ add(50); add(51); add(52); add(53); }
			}));
		testR.addRoute(new Route(3, new HashSet<Integer>() {
			{ add(101); add(102); add(103); add(104); }
			}));
		testR.addRoute(new Route(4, new HashSet<Integer>() {
			{ add(250); add(50); add(104); add(100); }
			}));
		
		busRoutesService = new BusRoutesService(testR);
	}
	
	@Test
	public void testDirectRoute1()
	{
		boolean result = busRoutesService.routeExists(100, 101);
		assertEquals(true, result);
	}
	
	@Test
	public void testDirectRoute2()
	{
		boolean result = busRoutesService.routeExists(101, 104);
		assertEquals(true, result);
	}
	
	@Test
	public void testDirectRoute3()
	{
		boolean result = busRoutesService.routeExists(101, 52);
		assertEquals(false, result);
	}
}