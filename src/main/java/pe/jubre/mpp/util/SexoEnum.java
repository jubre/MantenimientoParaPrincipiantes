package pe.jubre.mpp.util;

public enum SexoEnum {
	MASCULINO(1), FEMENINO(2);
	public final int valor;

	SexoEnum(int valor) {
		this.valor = valor;
	}

	public static SexoEnum convertir(int valor) {
		for (SexoEnum sexoEnum : SexoEnum.values()) {
			if (sexoEnum.valor == valor)
				return sexoEnum;
		}
		return null;
	}
}
