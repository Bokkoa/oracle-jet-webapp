package schedule;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import schedule.utils.ServicesUtils;

@Path("api")
public class ScheduleWebServices {
    
    @GET
    @Path("/users")
    public String getUsers(){

        int dMLStatement = ServicesUtils.executeDMLStatement("INSERT INTO jet_services (`services_name`, `service_description`) VALUES (`archiving`, `archiving database`)");
        return "A User";
    }
}
