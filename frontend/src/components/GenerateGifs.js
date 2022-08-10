import React, {
    useState
} from "react";
import axios from "axios";

const GenerateGifs = () => {

        const [text, setText] = useState('');

        const handleChange = event => {
            setText(event.target.value);
        }

        const handleClick = event => {
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

return (
<div className="container">
    <header className="gifs">
        <h1 id="title">Generate Gif</h1>
    </header>
    <form>
        <input type="text" id="gif-name" onChange={handleChange} value={text} />
        <button onClick={handleClick}>Generate gif</button>
    </form>
</div>
);
};

export default GenerateGifs;
