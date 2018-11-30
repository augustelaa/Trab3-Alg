
public class Principal {

	public static void main(String[] args) {
		MapaDispersao<String,Veiculo> mp = new MapaDispersao<String,Veiculo>(2001);
		
		Veiculo v = new Veiculo();
		v.setPlaca("Ea");
		v.setModelo("Hyundai Creta");
		v.setAno(2017);
		v.setProprietario("João da Silva");
		
		mp.inserir(v.getPlaca(), v);
		
		
		
		v = new Veiculo();
		v.setPlaca("FB");
		v.setModelo("Hyundai HB20");
		v.setAno(2016);
		v.setProprietario("Tobias Fernandes");
		
		mp.inserir(v.getPlaca(), v);
		
		
		
		Veiculo item = mp.buscar("Ea");
		System.out.println("Ea: " + item);
		
		item = mp.buscar("FB");
		System.out.println("FB: " + item);
		
		mp.remover("FB");
		System.out.println("Remove FB");
		item = mp.buscar("FB");
		System.out.println("FB: " + item);
		
		System.out.println("Adiciona FB");
		mp.inserir(v.getPlaca(), v);
		item = mp.buscar("FB");
		System.out.println("FB: " + item);
		
	}

}
