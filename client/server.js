const express = require('express')
const path = require('path')

const app = express()
const PORT = 3000


app.set('view engine', 'ejs')

// I can now use req.body.username
app.use(express.urlencoded({ extended : true }))

app.get('/', (req, res) => {
	res.render('login')
})

app.post('/chat', (req, res) => {
	const userName = req.body.username
	res.render('chat', {'username': userName})                        
})

app.use(express.static(path.join(__dirname, 'static')))

app.listen(PORT, () => {
	console.log('Server running at ' + PORT + 'port')
})

