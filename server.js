import { WebSocketServer } from 'ws';

const wss = new WebSocketServer({ port: 8080 });
var clients = new Set();

wss.on('connection', function connection(ws) {
	ws.on('error', console.error);

	clients.add(ws);

	ws.onmessage = function message(data) {
		console.log(JSON.stringify(data));
		var m = (data.data);
		for(const c of clients) {
			c.send(m);
		}
		console.log('received: ' + m);
	};

	ws.send('server connected');
});

