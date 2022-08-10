import React, {
    useEffect,
    useState
} from 'react';
import ReactDOM from "react-dom";

const ViewGifs = () => {

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

return (
<div className="container">
    <header className="gifs">
        <h1 id="title">View Gifs</h1>
    </header>
    <table>
        <tbody>
            <tr>
                <th>Keyword</th>
                <th>Gif</th>
            </tr>
            {gifs.map(gif => (
            <tr key={gif.id}>
                <td>{gif.text}</td>
                <td><img src={gif.gifUrl} width={200} height={200} alt="new" /></td>
            </tr>
            ))}
        </tbody>
    </table>
</div>
);
};

export default ViewGifs;
