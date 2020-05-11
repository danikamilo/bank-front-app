package soat.examples.portlet;

public class Printer {
	private static void procesar() {
		AttributesPrinter obj = new AttributesPrinter();
		obj.iniciarProcesamientoPaginas(obj);
	}

	public static void main(String[] args) {
		procesar();
	}
}