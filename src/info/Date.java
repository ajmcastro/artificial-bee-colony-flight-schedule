package info;

import org.joda.time.DateTime;

public class Date {
	private int ano = 0, mes = 0, dia = 0, hora = 0, minuto = 0, segundo = 0;
	
	public Date(String d) {
		if(d.length() == 8){
			int iter = d.indexOf(":");
			hora = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf(":")+1);
			iter = d.indexOf(":");
			minuto = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf(":")+1);
			segundo = Integer.valueOf(d.substring(0, iter));
		}
		else if(d.length() == 10){
			int iter = d.indexOf("-");
			ano = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf("-")+1);
			iter = d.indexOf("-");
			mes = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf("-")+1);
			dia = Integer.valueOf(d.substring(0, iter));
		}
		else{
			int iter = d.indexOf("-");
			ano = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf("-")+1);
			iter = d.indexOf("-");
			mes = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf("-")+1);
			iter = d.indexOf(" ");
			dia = Integer.valueOf(d.substring(0, iter));
			
			d = d.substring(d.indexOf(" ")+1);
			iter = d.indexOf(":");
			hora = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf(":")+1);
			iter = d.indexOf(":");
			minuto = Integer.valueOf(d.substring(0, iter));
			d = d.substring(d.indexOf(":")+1);
			segundo = Integer.valueOf(d.substring(0, d.length()));
		}
	}
	
	public int difWithMinutes(Date that){
		DateTime d1 = new DateTime(this.ano, this.mes, this.dia, this.hora, this.minuto, this.segundo);
		DateTime d2 = new DateTime(that.ano, that.mes, that.dia, that.hora, that.minuto, that.segundo);
		long seconds = (d1.getMillis() - d2.getMillis())/1000;
		int minutes = (int) (seconds/60);
		
		return minutes;
	}
	
	public int compareTo(Date that){
		DateTime d1 = new DateTime(this.ano, this.mes, this.dia, this.hora, this.minuto, this.segundo);
		DateTime d2 = new DateTime(that.ano, that.mes, that.dia, that.hora, that.minuto, that.segundo);
		
		if(d1.getMillis() < d2.getMillis())
			return -1;
		else if (d1.getMillis() > d2.getMillis())
			return 1;
		else return 0;
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public int getSegundo() {
		return segundo;
	}
	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}
	
	public String toString() {
		if(ano==-1 && mes==-1 && dia==-1)
			return hora + ":" + minuto + ":" + segundo;
		else if(hora==-1 && minuto==-1 && segundo==-1)
			return ano + "-" + mes + "-" + dia;
		return ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo;
	}
}
