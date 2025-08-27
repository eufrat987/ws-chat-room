const express = require('express')

const app = express()
const PORT = 3000


app.set('view engine', 'ejs')

app.use(express.urlencoded({ extended : true }))

app.get('/', (req, res) => {
	res.render('login')
})

app.post('/chat', (req, res) => {
	const userName = req.body.username
	res.render('chat', {'username': userName})                        
})

app.listen(PORT, () => {
	console.log('Server running at ' + PORT + 'port')
})

