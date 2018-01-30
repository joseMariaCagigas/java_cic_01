package es.cic.curso.curso05.ejercicio017;

import java.io.Serializable;

import org.springframework.stereotype.Service;
@Service
public class Centro implements Serializable{

	private static final long serialVersionUID = -3510926865361123538L;

	private int x;
	private int y;
	
 	public Centro() {
 		super();
 	}
 
 	public Centro(int x1, int y1) {
 		this.x = x1;
 		this.y = y1;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Centro [x=" + x + ", y=" + y + "]";
	}
}