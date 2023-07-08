public class NotFoundException extends RuntimeException{

    public NotFoundException(int id) {
        super("Товара с id" +id+ "нет в списке");
    }
}
