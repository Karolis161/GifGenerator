import React, {
	useState,
	useEffect
} from "react";
import axios from "axios";
import Select from 'react-select'

const GenerateGifs = () => {

		const [text, setText] = useState('');
		const [gifs, setGifs] = useState([]);
		const [loading, setLoading] = useState(false);

		const handleChange = event => {
			setText(event.target.value);
		}

		const handleClick = event => {
			event.preventDefault();
			axios.post('/api/admin/gif/generate', {
					inputText: text
				})
				.then(function(response) {
					return response;
				})
				.catch(function(error) {
					return error;
				});
		};

		const getGifs = async () => {
		setLoading(true);
        			fetch('api/admin/gif/data')
        				.then(res => res.json())
        				.then(data => {
        					const currentGif = data.slice(-1);
        					setGifs(currentGif);
        					setLoading(false);
        				})
		}

		useEffect(() => {
		getGifs()

		const interval = setInterval(() => {
		getGifs();
		}, 1000)
return()=>clearInterval(interval)
		}, []);

		const options = [
          { value: text, label: text }
        ]

return (
<div className="container">
	<header className="gifs">
		<h2 id="title" style={{'lineHeight' : 2}}>Generate Gif</h2>
	</header>
	<Select options = {options}/>
	<form>
		<input type="text" id="gif-name" onChange={handleChange} value={text} /> &nbsp;&nbsp;&nbsp;
		<button className="btn btn-primary" onClick={handleClick}>Generate gif</button>
	</form>
	<h4 id="title" style={{'lineHeight' : 2}}>Newest Gif</h4>
	{gifs.map(gif => (
	<tr key={gif.id}>
		<td style={{'border' : '2px solid black'}}>
		    <img src={gif.gifUrl} width={300} height={300} alt="new" />
		</td>
	</tr>
	))}
</div>
);
};

export default GenerateGifs;
