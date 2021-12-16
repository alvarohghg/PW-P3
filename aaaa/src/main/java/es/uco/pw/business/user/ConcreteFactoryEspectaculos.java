package es.uco.pw.business.user;

public class ConcreteFactoryEspectaculos extends AbstractFactoryEspectaculo {
	// Implementation of creation methods
	
	

		public EspectaculoPuntual createEspectaculoPuntual() {
			EspectaculoPuntual espectP = new EspectaculoPuntual(null, null, null, 0, 0, null);
			return espectP;
		}

		public EspectaculoMultiple createEspectaculoMultiple() {
			EspectaculoMultiple espectM = new EspectaculoMultiple(null, null, null, 0, 0, null);
			return espectM;
		}
		public EspectaculoTemporada createEspectaculoTemporada() {
			EspectaculoTemporada espectT = new EspectaculoTemporada(null, null, null, 0, 0, null, null, null);
			return espectT;
		}
}
