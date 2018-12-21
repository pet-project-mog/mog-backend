package br.com.caelum.mog.enums;

public enum CompanyUnit {

	SP {
		@Override
		public String getNome() {
			return "São Paulo";
		}
		
		@Override
		public String getEmail() {
			return "corporativo@caelum.com.br";
		}
	},
	
	RJ {
		
		@Override
		public String getNome() {
			return "Rio de Janeiro";
		}
		
		public String getEmail() {
			return "contato.rj@caelum.com.br";
		}
	},
	
	BSB {
		@Override
		public String getNome() {
			return "Brasília";
		}
		
		@Override
		public String getEmail() {
			return "contato.df@caelum.com.br";
		}
	};

	public String getNome() {
		return "";
	}

	public String getEmail() {
		return "";
	}
}
