package be.klak.whatsthat.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.googlecode.objectify.annotation.Embed;

@Embed
public class Drawing {

	private List<DrawablePiece> pieces = new ArrayList<DrawablePiece>();

	public Drawing() {
	}

	public Drawing(DrawablePiece... pieces) {
		setPieces(Arrays.asList(pieces));
	}

	public void setPieces(List<DrawablePiece> pieces) {
		this.pieces = pieces;
	}

	public List<DrawablePiece> getPieces() {
		return pieces;
	}
}
