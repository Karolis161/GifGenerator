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
					setGifs(lastFive)
					setLoading(false);
				})
		}, []);

const tableConfig = gifs.map((info) => {

return(
<div class="container" style={{'padding' : 10}}>
    <div class="card" style={{'border' : '2px solid black'}}>
        <div class="card-header">
            <img src={info.gifUrl} width={100} height={100} alt="new" />
        </div>
        <div class="card-body">
            <h4>{info.text}</h4>
        </div>
    </div>
</div>
);
});

return (
<div>
	<header className="gifs">
		<h1 id="title">View Gifs</h1>
	</header>
	<tbody>{tableConfig}</tbody>
</div>
);
};

export default ViewGifs;