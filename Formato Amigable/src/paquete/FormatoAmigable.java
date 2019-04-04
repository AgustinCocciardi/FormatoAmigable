package paquete;

public class FormatoAmigable {
	int valido;
	int años;
	int dias;
	int horas;
	int minutos;
	int segundos;
	int medicionesEnUso;

	public FormatoAmigable() {
		this.valido = 2;
		this.años = 0;
		this.horas = 0;
		this.dias = 0;
		this.minutos = 0;
		this.segundos = 0;
		this.medicionesEnUso = 0;
	}
	
	public void duracion(int segundos) {
		if (segundos < 0)
			this.valido = 0;
		if (segundos == 0)
			this.valido = 1;
		if (segundos >= 31536000) {
			this.años = segundos / 31536000;
			segundos %= 31536000;
			this.medicionesEnUso++;
		}
		if (segundos >= 86400) {
			this.dias = segundos / 86400;
			segundos %= 86400;
			if (this.dias >= 365) {
				this.años += this.dias / 365;
				this.dias %= 365;
			}
			this.medicionesEnUso++;
		}
		if (segundos >= 3600) {
			this.horas = segundos / 3600;
			segundos %= 3600;
			if (this.horas >= 24) {
				this.dias += this.horas / 24;
				this.horas %= 24;
			}
			this.medicionesEnUso++;
		}
		if (segundos >= 60) {
			this.minutos = segundos / 60;
			segundos %= 60;
			if (this.minutos >= 60) {
				this.horas += this.minutos / 60;
				this.minutos %= 60;
			}
			this.medicionesEnUso++;
		}
		if(segundos>0) {
			this.segundos = segundos;
			this.medicionesEnUso++;
			if (this.segundos > 60) {
				this.minutos += this.segundos / 60;
				this.segundos %= 60;
			}
		}

		if (this.dias >= 365) {
			this.años += this.dias / 365;
			this.dias %= 365;
			if (this.dias == 0)
				this.medicionesEnUso--;
		}
		if (this.horas >= 24) {
			this.dias += this.horas / 24;
			this.horas %= 24;
			if (this.horas == 0)
				this.medicionesEnUso--;
			if(this.dias>0)
				this.medicionesEnUso++;
		}
		if (this.minutos >= 60) {
			this.horas += this.minutos / 60;
			this.minutos %= 60;
			if (this.minutos == 0)
				this.medicionesEnUso--;
			if(this.horas>0)
				this.medicionesEnUso++;
		}
		if (this.segundos > 60) {
			this.minutos += this.segundos / 60;
			this.segundos %= 60;
			if (this.segundos != 0)
				this.medicionesEnUso--;
			if(this.minutos>0)
				this.medicionesEnUso++;
		}
		
		
	}
	
	public void mostrar() {
		if (this.valido == 0)
			System.out.println("No se aceptan segundos negativos");
		if (this.valido == 1)
			System.out.println("ahora");

		if (this.años > 0) {
			System.out.print(this.años + " ");
			if (this.años > 1)
				System.out.print("años");
			else
				System.out.print("año");
			this.medicionesEnUso--;
			if (this.medicionesEnUso > 1)
				System.out.print(", ");
			if (this.medicionesEnUso == 1)
				System.out.print(" y ");
			if (this.medicionesEnUso == 0)
				System.out.print("\0");
		}

		if (this.dias > 0) {
			System.out.print(this.dias + " ");
			if (this.dias > 1)
				System.out.print("dias");
			else
				System.out.print("dia");
			this.medicionesEnUso--;
			if (this.medicionesEnUso > 1)
				System.out.print(", ");
			if (this.medicionesEnUso == 1)
				System.out.print(" y ");
			if (this.medicionesEnUso == 0)
				System.out.print("\0");
		}

		if (this.horas > 0) {
			System.out.print(this.horas + " ");
			if (this.horas > 1)
				System.out.print("horas");
			else
				System.out.print("hora");
			this.medicionesEnUso--;
			if (this.medicionesEnUso > 1)
				System.out.print(", ");
			if (this.medicionesEnUso == 1)
				System.out.print(" y ");
			if (this.medicionesEnUso == 0)
				System.out.print("\0");
		}
		
		if (this.minutos > 0) {
			System.out.print(this.minutos + " ");
			if (this.minutos > 1)
				System.out.print("minutos");
			else
				System.out.print("minuto");
			this.medicionesEnUso--;
			if(this.medicionesEnUso==1)
				System.out.print(" y ");
			if(this.medicionesEnUso==0)
				System.out.print("\0");
		}
		
		if (this.segundos > 0) {
			System.out.print(this.segundos + " ");
			if (this.segundos > 1)
				System.out.print("segundos");
			else
				System.out.print("segundo");
			System.out.print("\0");
		}
	}

	public static void main(String[] args) {
		FormatoAmigable fa0 = new FormatoAmigable();
		FormatoAmigable fa01 = new FormatoAmigable();
		FormatoAmigable fa1 = new FormatoAmigable();
		FormatoAmigable fa2 = new FormatoAmigable();
		FormatoAmigable fa3 = new FormatoAmigable();
		FormatoAmigable fa4 = new FormatoAmigable();
		FormatoAmigable fa5 = new FormatoAmigable();
		FormatoAmigable fa6 = new FormatoAmigable();
		FormatoAmigable fa7 = new FormatoAmigable();
		FormatoAmigable fa8 = new FormatoAmigable();
		FormatoAmigable fa9 = new FormatoAmigable();
		FormatoAmigable fa10 = new FormatoAmigable();
		FormatoAmigable fa11 = new FormatoAmigable();
		
		///VALORES TRIVIALES///
		/*fa0.duracion(-10);
		fa0.mostrar();
		System.out.println("\n");
		fa01.duracion(0);
		fa01.mostrar();
		System.out.println("\n");
		fa1.duracion(60);
		fa1.mostrar();
		System.out.println("\n");
		fa2.duracion(3600);
		fa2.mostrar();
		System.out.println("\n");
		fa3.duracion(86400);
		fa3.mostrar();
		System.out.println("\n");
		fa4.duracion(31536000);
		fa4.mostrar();
		System.out.println("\n");*/
		
		///VALORES NO TRIVIALES///
		fa0.duracion(70);
		fa0.mostrar();
		System.out.println("\0");
		fa01.duracion(3660);
		fa01.mostrar();
		System.out.println("\0");
		fa1.duracion(90351);
		fa1.mostrar();
		System.out.println("\0");
		fa2.duracion(15);
		fa2.mostrar();
		System.out.println("\0");
		fa3.duracion(34279474);
		fa3.mostrar();
		System.out.println("\0");
		fa4.duracion(75124);
		fa4.mostrar();
		System.out.println("\0");
		fa5.duracion(31536001);
		fa5.mostrar();
		System.out.println("\0");
		fa6.duracion(15000);
		fa6.mostrar();
		System.out.println("\0");
		fa7.duracion(189783610);
		fa7.mostrar();
		System.out.println("\0");
		fa8.duracion(31535999);
		fa8.mostrar();
		System.out.println("\0");
		fa9.duracion(86399);
		fa9.mostrar();
		System.out.println("\0");
		fa10.duracion(3599);
		fa10.mostrar();
		System.out.println("\0");
		fa11.duracion(31536061);
		fa11.mostrar();
		System.out.println("\0");
	}

}
