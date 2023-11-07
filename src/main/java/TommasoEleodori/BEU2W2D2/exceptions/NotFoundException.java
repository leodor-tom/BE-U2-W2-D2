package TommasoEleodori.BEU2W2D2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Element whit id " + id + " not found");
    }
}
