package modelo;

public abstract class DecoratorPosgrado implements IMedico {
protected IMedico encapsulado;

	//Constructores
	public DecoratorPosgrado(IMedico encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario();
	}
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}

	@Override
	public boolean equals(IMedico o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DecoratorPosgrado that = (DecoratorPosgrado) o;

		return encapsulado != null ? encapsulado.equals(that.encapsulado) : that.encapsulado == null;
	}

	@Override
	public int hashCode() {
		return encapsulado != null ? encapsulado.hashCode() : 0;
	}
}
