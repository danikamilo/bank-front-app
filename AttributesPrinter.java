package soat.examples.portlet;

public class AttributesPrinter {

	final int M = 1000;
	final int RR = 50;
	final int CC = 4;
	final int ORDMAX = 30;
	int P[] = new int[M + 1];
	int PAGENUMBER;
	int PAGEOFFSET;
	int ROWOFFSET;
	int C;
	int J;
	int K;
	boolean JPRIME;
	int ORD;
	int SQUARE;
	int N = 0;
	int MULT[] = new int[ORDMAX + 1];

	public AttributesPrinter() {
		super();
	}
	
	/**
	 * Metodo inicial del procesamiento de informacion,
	 * devide el algoritmo en tres procesos.
	 * 
	 * @param obj
	 */
	public void iniciarProcesamientoPaginas(AttributesPrinter obj) {
		cargarInformacionInicial(obj);
		procesarLogicaDeInformacion(obj);
		procesarImpresionDeInformacion(obj);
	}
	
	/**
	 * Se asignan los parametro iniciales de la funcionalidad.
	 * 
	 * @param obj
	 */
	public void cargarInformacionInicial(AttributesPrinter obj) {
		obj.setJ(1);
		obj.setK(1);
		obj.setPInicialization();
		obj.setORD(2);
		obj.setSQUARE(9);
	}	
	
	/**
	 * Se asignan los valores que los arreglos deben tener al 
	 * momento de impirmir la información.
	 * 
	 * @param obj
	 */
	public void procesarLogicaDeInformacion(AttributesPrinter obj) {
 		while (obj.K < obj.M) {
			do {
				obj.adicionarInfoMULT(obj);
			} while (!obj.JPRIME);
			obj.K++;
			obj.P[obj.K] = obj.J;
		}
 		obj.setPAGENUMBER(1);
		obj.setPAGEOFFSET(1);
	}
	
	/**
	 * Metodo que sirve para añadir informacion al arreglo MULT o 
	 * para asignar valor a la variable PRIME.
	 * 
	 * @param obj
	 */
	public void adicionarInfoMULT(AttributesPrinter obj) {
		obj.setJ(obj.J += 2);
		if (obj.J == obj.SQUARE) {
			obj.setORD(obj.ORD++);
			obj.setSQUARE(obj.P[obj.ORD] * obj.P[obj.ORD]);
			obj.MULT[obj.ORD - 1] = obj.J;
		}
		obj.setN(2);
		obj.setJPRIME(true);		
		while (obj.N < obj.ORD && obj.JPRIME) {
			while (obj.MULT[obj.N] < obj.J) {
				obj.MULT[obj.N] += obj.P[obj.N] + obj.P[obj.N];
			}
			if (obj.MULT[obj.N] == obj.J) {
				obj.setJPRIME(false);	
			}
			obj.setN(obj.N++);
		}
	}

	/**
	 * Metodo encargado de controlar la impresion de informacion de la
	 * funcionalidad.
	 * 
	 * @param obj
	 */
	public void procesarImpresionDeInformacion(AttributesPrinter obj) {
		while (obj.PAGEOFFSET <= obj.M) {
			impirmirCabecerasPagina(obj.M, obj.PAGENUMBER);
			imprimirInformacionPagina(obj);
		}
	}

	/**
	 * Procesamiento para imprimir una pagina especifica.
	 * 
	 * @param obj
	 */
	public void imprimirInformacionPagina(AttributesPrinter obj) {
		for (obj.ROWOFFSET = obj.PAGEOFFSET; obj.ROWOFFSET <= obj.PAGEOFFSET + obj.RR - 1; obj.ROWOFFSET++) {	
			for (obj.C = 0; obj.C <= obj.CC - 1; obj.C++) {
				if (ROWOFFSET + C * RR <= M) {
					imprimeRegistro(obj);
				}
			}
			System.out.println();
		}
		System.out.println("\f");
		obj.PAGENUMBER++;
		obj.PAGEOFFSET += obj.RR * obj.CC;			
	}
	
	
	/**
	 * Metodo encargado de imprirmi un registro.
	 * 
	 */
	public void imprimeRegistro(AttributesPrinter obj) {
		System.out.printf("%10d", obj.P[obj.ROWOFFSET + obj.C * obj.RR]);
	}

	public void impirmirCabecerasPagina(int M, int PAGENUMBER) {
		System.out.print("The First ");
		System.out.print(Integer.toString(M));
		System.out.print(" Prime Numbers === Page ");
		System.out.print(Integer.toString(PAGENUMBER));
		System.out.println("\n");
	}

	public int[] getP() {
		return P;
	}

	public void setP(int[] p) {
		P = p;
	}

	public void setPInicialization() {
		P[1] = 2;
	}

	public int getPAGENUMBER() {
		return PAGENUMBER;
	}

	public void setPAGENUMBER(int pAGENUMBER) {
		PAGENUMBER = pAGENUMBER;
	}

	public int getPAGEOFFSET() {
		return PAGEOFFSET;
	}

	public void setPAGEOFFSET(int pAGEOFFSET) {
		PAGEOFFSET = pAGEOFFSET;
	}

	public int getROWOFFSET() {
		return ROWOFFSET;
	}

	public void setROWOFFSET(int rOWOFFSET) {
		ROWOFFSET = rOWOFFSET;
	}

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}

	public int getJ() {
		return J;
	}

	public void setJ(int j) {
		J = j;
	}

	public int getK() {
		return K;
	}

	public void setK(int k) {
		K = k;
	}

	public boolean isJPRIME() {
		return JPRIME;
	}

	public void setJPRIME(boolean jPRIME) {
		JPRIME = jPRIME;
	}

	public int getORD() {
		return ORD;
	}

	public void setORD(int oRD) {
		ORD = oRD;
	}

	public int getSQUARE() {
		return SQUARE;
	}

	public void setSQUARE(int sQUARE) {
		SQUARE = sQUARE;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int[] getMULT() {
		return MULT;
	}

	public void setMULT(int[] mULT) {
		MULT = mULT;
	}

	public int getM() {
		return M;
	}

	public int getRR() {
		return RR;
	}

	public int getCC() {
		return CC;
	}

	public int getORDMAX() {
		return ORDMAX;
	}
}
