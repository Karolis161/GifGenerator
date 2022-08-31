import React, {
	useState,
	useEffect
} from "react";
import axios from "axios";

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

return (
<div className="container">
	<header className="gifs">
		<h1 id="title">Generate Gif</h1>
	</header>
	<form>
		<input type="text" id="gif-name" onChange={handleChange} value={text} />
		<button onClick={handleClick}>Generate gif</button>
	</form>
	{gifs.map(gif => (
	<tr key={gif.id}>
		<td><img src={gif.gifUrl} width={300} height={300} alt="new" /></td>
	</tr>
	))}
</div>
);
};

export default GenerateGifs;
