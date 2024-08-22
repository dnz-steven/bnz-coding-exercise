package nz.co.bnz.lapworkshop.exception;

public class UpstreamApiException extends Exception {

    public UpstreamApiException() {
        super("Unable to fetch data from a service.");
    }
}
