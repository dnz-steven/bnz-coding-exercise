package nz.co.bnz.lapworkshop.common;

public class ExceptionModel {
    private String errorMessage;

    public ExceptionModel() {

    }

    public ExceptionModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
