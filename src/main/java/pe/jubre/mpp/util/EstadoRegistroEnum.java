package pe.jubre.mpp.util;

public enum EstadoRegistroEnum {
	REGISTRADO(1), PENDIENTE(2), ACEPTADO(3), RECHAZADO(4);
	public final int valor;

	EstadoRegistroEnum(int valor) {
		this.valor = valor;
	}

	public static EstadoRegistroEnum convertir(int valor) {
		for (EstadoRegistroEnum estadoRegistroEnum : EstadoRegistroEnum.values()) {
			if (estadoRegistroEnum.valor == valor)
				return estadoRegistroEnum;
		}
		return null;
	}
}
