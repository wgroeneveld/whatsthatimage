package be.klak.whatsthat.domain;

import com.googlecode.objectify.annotation.Embed;

@Embed
public class DrawablePiece {

	private int x;
	private int y;
	private boolean piece;

	public DrawablePiece() {
	}

	public DrawablePiece(int x, int y) {
		this(x, y, false);
	}

	public DrawablePiece(int x, int y, boolean piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isPiece() {
		return piece;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setPiece(boolean piece) {
		this.piece = piece;
	}

}
