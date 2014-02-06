
var Guesswhat = (function() {

	var context, canvas, server;
	var painting = false;
	var rebus = null;

	function log(obj) {
		console.log(obj);
		if($("#debug")) {
			$("#debug").html("<br/>" + obj);
		}
	}
	
	function coord(e, me, isStartingOfNewPiece) {
		var coordToAdd = {
			x: e.pageX - me.offsetLeft,
			y: e.pageY - me.offsetTop,
			piece: isStartingOfNewPiece
		};
		if(coordToAdd.x >= 0 && coordToAdd.y >= 0) {
			log("adding coord " + coordToAdd.x + "," + coordToAdd.y);
			if(!rebus.drawing) {
				rebus.drawing = { pieces: [] };
			}
			rebus.drawing.pieces.push(coordToAdd);
		}
	}

	function clear() {
		context.save();
		context.setTransform(1, 0, 0, 1, 0, 0);
		context.clearRect(0, 0, context.canvas.width, context.canvas.height);
		context.restore();
		
		rebus = {
			answer: "",
			drawing: {
				pieces: []
			}
		}
	}
	
	function random(callback) {
		log("fetching random rebus...");
		server.rebus.random().execute(function(fetchedRebus) {
			log("fetched rebus, drawing...");
			clear();
			rebus = fetchedRebus;
			
			repaint();
			callback(rebus);
		});
	}
	
	function initContext() {
		context.strokeStyle = "#df4b26";
		context.lineJoin = "round";
		context.lineWidth = 5;		
	}
	
	function repaint() {
		initContext();
		context.beginPath();
		if(rebus.drawing) {
			rebus.drawing.pieces.forEach(function(coord) {
				if(!coord.piece) {
					context.lineTo(coord.x, coord.y);
				}
				context.moveTo(coord.x, coord.y);
			});
		}
		context.closePath();
		context.stroke();
	}

	function initCanvas(canvasjQueryElem, gapi) {
		canvas = canvasjQueryElem;
		server = gapi;
		context = canvas[0].getContext('2d');
		canvas.mousedown(function(e) {
			painting = true;
			coord(e, this, true);
			repaint();
		});
		canvas.mouseleave(function(e) {
			painting = false;
		});
		canvas.mouseup(function(e) {
			painting = false;
		});
		
		canvas.mousemove(function(e) {
			if(painting) {
				coord(e, this);
				repaint();
			}
		});
		
		clear();
	}

	function submit(answer, callback) {
		log("uploading rebus to server...");
		rebus.answer = answer;
		server.rebus.set(rebus).execute(function() {
			log("uploaded successfully!");
			clear();
			callback();
		});
	}
	
	return {
		initCanvas: initCanvas,
		getRebus: function() {
			return rebus;
		},
		clear: clear,
		repaint: repaint,
		submit: submit,
		random: random
	};


})();
