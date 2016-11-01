package goeuro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import goeuro.busroute.BusRoutesService;
import goeuro.busroute.RouteResponse;

@Controller
@RequestMapping("/api")
public class BusRouteController
{
	@Autowired
    private BusRoutesService busRoutesService;
	
    @RequestMapping(value = "direct", method=RequestMethod.GET, produces={"application/json"})
    public @ResponseBody String sayHello(@RequestParam(value = "dep_sid", required = true) Integer dep_sid,
    									 @RequestParam(value = "arr_sid", required = true) Integer arr_sid)
    {
    	Gson gson = new Gson();
    	// check input as Integers can be null. If at least one is null, print error message
    	if(dep_sid == null || arr_sid == null)
    	{
    		return "Bad parameters. Please use this format: http://localhost:8088/api/direct?dep_sid={}&arr_sid={}"
        			+ " \nwhere {} represents 32 bit integers.";
    	}
    	
    	boolean pathFound = busRoutesService.routeExists(dep_sid, arr_sid);
    	return gson.toJson(new RouteResponse(dep_sid, arr_sid, pathFound));
    }
}