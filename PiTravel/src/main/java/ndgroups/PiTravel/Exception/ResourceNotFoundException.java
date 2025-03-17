package ndgroups.PiTravel.Exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String  message){
        super(message);
    }
}