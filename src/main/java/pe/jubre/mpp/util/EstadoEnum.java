package pe.jubre.mpp.util;

public enum EstadoEnum {
	ACTIVO(1), INACTIVO(2), BORRADO(3);
	public final int valor;

	EstadoEnum(int valor) {
		this.valor = valor;
	}

	public static EstadoEnum convertir(int valor) {
		for (EstadoEnum estadoEnum : EstadoEnum.values()) {
			if (estadoEnum.valor == valor)
				return estadoEnum;
		}
		return null;
	}
}
