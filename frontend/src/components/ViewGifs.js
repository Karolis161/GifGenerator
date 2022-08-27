import React, {
	useEffect,
	useState
} from 'react';
import ReactDOM from "react-dom";

function ViewGifs() {

		const [gifs, setGifs] = useState([]);
		const [loading, setLoading] = useState(false);

useEffect(() => {
			setLoading(true);
			fetch('api/admin/gif/data')
				.then(res => res.json())
				.then(data => {
					const lastFive = data.slice(-5);
					setGifs(lastFive);
					setLoading(false);
				})
		}, []);

const tableRows = gifs.map((info) => {

return(
<tr>
<td>{info.text}</td>
<td><img src={info.gifUrl} width={100} height={100} alt="new" /></td>
</tr>
);
});

const addRows = () => {
};

return (
<div>
	<header className="gifs">
		<h1 id="title">View Gifs</h1>
	</header>
	<table className="table table-stripped">
		<thead>
			<tr>
				<th>Keyword</th>
				<th>Gif</th>
			</tr>
		</thead>
		<tbody>{tableRows}</tbody>
	</table>
</div>
);
};

export default ViewGifs;