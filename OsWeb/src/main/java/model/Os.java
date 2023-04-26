package model;

public class Os {
	
	private int id;
	private String descrizione;
	private String company;
	private int openSource;
	
	public Os(int id, String descrizione, String company, int openSource) {
		//super();
		this.id = id;
		this.descrizione = descrizione;
		this.company = company;
		this.openSource = openSource;
	}
	
	public Os() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getOpenSource() {
		return openSource;
	}

	public void setOpenSource(int openSource) {
		this.openSource = openSource;
	}
	
	
}
