package goeuro.busroute;

@SuppressWarnings("serial")
public class NoRouteException extends Exception
{
	public NoRouteException(String message)
	{
		super(message);
	}
}